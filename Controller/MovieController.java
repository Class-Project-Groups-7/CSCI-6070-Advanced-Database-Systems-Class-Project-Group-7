import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class MovieController {
	private MovieView view=new MovieView();
	public void getTopRatingMovies(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM SHOW_INFO_MOVIE ";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String title=rs.getString(1);
			String region=rs.getString(2);
			String language=rs.getString(3);
			String year=rs.getString(4);
			double rating=rs.getDouble(5);
			int votes=rs.getInt(6);
			Movie movie=new Movie(title,region,language,year,rating,votes);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	public int getCount(String str){
		int count=0;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery(str);
		rs.last(); 
		count=rs.getRow();
		con.close(); 
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		return count;
	}
	public void getTopTenDirecterNames(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM  SHOW_INFO_DIRECTED_NAMES";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		//System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String directorName=rs.getString(1);
			Movie movie=new Movie();
			movie.setDirectorName(directorName);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printGetTopTenDirecterNamesResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
		
	}
	public void getTopTenTvSeries(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM SHOW_TOP_TEN_TV_SERIES";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String title=rs.getString(1);
			int seasonnumber=rs.getInt(2);
			double rating=rs.getDouble(3);
			Movie movie=new Movie(title,rating,seasonnumber);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printTopTenTvSeriesResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	public void getCountOfParticularRating(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM SHOW_COUNT_PARTICULAR_RATING";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			double rating=rs.getDouble(1);
			int moviecount=rs.getInt(2);
			Movie movie=new Movie(rating,moviecount);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printCountOfParticularRatingResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	public void getInfoTvEpisodesNotNull(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM  SHOW_INFO_TV_EPISODES_NOT_NULL";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String title=rs.getString(1);
			String types=rs.getString(2); 
			int isadult=rs.getInt(3);
			String startyear=rs.getString(4);
			int seasonnumber=rs.getInt(5);
			int episodenumber=rs.getInt(6);
			int numvotes=rs.getInt(7);
			Movie movie=new Movie(title,types,isadult,startyear,seasonnumber,episodenumber,numvotes);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printInfoTvEpisodesNotNullResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	public void getInfoMoivieRunTimeMinutes(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM SHOW_INFO_MOVIE_RUNTIMEMINUTES";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String title=rs.getString(1);
			String types=rs.getString(2); 
			int runtimeminutes=rs.getInt(3);
			Movie movie=new Movie(title,types,runtimeminutes);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printInfoMoivieRunTimeMinutesResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	public void getInfoMoivieTitleDirectedby(){
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");    
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","shashank","password");  
		Statement st=con.createStatement();
		String str="SELECT * FROM SHOW_INFO_MOVIE_TITLE_DIRECTED";
		ResultSet rs=st.executeQuery(str);
		int count=getCount(str);
		System.out.println(count);
		Movie[] movielist=new Movie[count];
		int i=0;
		//System.out.println(movielist.length);
		while(rs.next()){
			String title=rs.getString(1);
			Movie movie=new Movie(title);
			movielist[i]=movie;
			i++;
		}
		con.close();  
		this.view.setResult(movielist);
		this.view.printInfoMoivieTitleDirectedbyResult();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}

}
