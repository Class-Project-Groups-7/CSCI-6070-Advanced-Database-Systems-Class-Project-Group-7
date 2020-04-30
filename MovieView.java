public class MovieView {
	private Movie[] result;
	String line = new String(new char[115]).replace('\0', '-');
	public void setResult(Movie[] res){
		this.result=res;	
	}
	public void printResult(){
		System.out.println("Information of movies (Title, Region, Language, Year, Rating, Votes) which have average rating greater than 7 and number of votes greater than 1000.");
		line = new String(new char[150]).replace('\0', '-');
		System.out.println(line);
		System.out.printf("|%-83s%-15s%-15s%-15s%-15s%-6s| %n","TITLE","REGION","LANGUAGE","YEAR","RATING","VOTES");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
		    System.out.printf("%-85s%-15s%-15s%-15s%-15.1f%-15d %n",result[i].getTITLE(),result[i].getREGION(),result[i].getLANGUAGE(),result[i].getYEAR(),result[i].getRATING(),result[i].getVOTES());
		}
		System.out.println(line);
	}
	public void printGetTopTenDirecterNamesResult(){
		System.out.println("Names of persons who have directed more than 10 movies");
		System.out.println(line);
		System.out.printf("|%-114s| %n","DirectorName");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
			System.out.printf("%-83s %n", result[i].getDirectorName());
			
			
		}
		System.out.println(line);
	}
	public void printTopTenTvSeriesResult(){
		System.out.println("                   Top 10 TV series (more than 1 season) which most average ratings");
		System.out.println(line);
		System.out.printf("|%-83s%-15s%16s| %n","TITLE","RATING","SEASONNUMBER");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
		    System.out.printf("%-85s%-15s%10d %n", result[i].getTITLE(),result[i].getRATING(),result[i].getSEASONNUMBER());
			
		}
		System.out.println(line);
	}
	public void printCountOfParticularRatingResult(){
		line = new String(new char[30]).replace('\0', '-');
		System.out.println("Number of movies ( count )  for a particular rating");
		System.out.println(line);
		System.out.printf("|%-22s%s | %n","RATING","COUNT");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
		    System.out.printf("%-22.1f%5d %n",result[i].getRATING(),result[i].getCOUNT());
			
		}
		System.out.println(line);
	}
	public void printInfoTvEpisodesNotNullResult(){
		System.out.println("Information of TV Series (Title, Types, Is Adult, Start Year, Season Number, Episode Number,  Votes) which have episode number is NOT NULL");
		line = new String(new char[164]).replace('\0', '-');
		System.out.println(line);
		System.out.printf("|%-83s%-15s%-15s%-15s%-15s%-15s%-6s| %n","TITLE","TYPE","ISADULT","YEAR","SEASONNUMBER","EPIDOSENUMBER","VOTES");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
		    System.out.printf("%-83s%-15s%-15d%-15s%-15d%-15d%-6d %n",result[i].getTITLE(),result[i].getTYPE(),result[i].getISADULT(),result[i].getYEAR(),result[i].getSEASONNUMBER(),result[i].getEPIDOSENUMBER(),result[i].getVOTES());
			
		}
		System.out.println(line);
	}
	public void printInfoMoivieRunTimeMinutesResult(){
		System.out.println("        Information of Movies (Title, Types, RunTimeMinutes) which have RunTimeMinutes=1");
		System.out.println(line);
		System.out.printf("|%-83s%-15s%16s| %n","TITLE","TYPES","RUNTIMEMINUTES");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
		    //System.out.println(result[i].getTITLE()+" "+result[i].getTYPE()+" "+result[i].getRUNTIMEMINUTES());
			//%-15s%03d %n
			System.out.printf("%-83s%-15s%10d %n", result[i].getTITLE(),result[i].getTYPE(),result[i].getRUNTIMEMINUTES());
		}
		System.out.println(line);
		}
	public void printInfoMoivieTitleDirectedbyResult(){
		System.out.println("     Information of Movies (Title) which are  directed by 'William K.L. Dickson' and average rating more than 3");
		System.out.println(line);
		System.out.printf("|%-114s| %n","TITLE");
		System.out.println(line);
		for(int i=0;i<result.length;i++){
			System.out.printf("%-83s %n", result[i].getTITLE());
			
			
		}
		System.out.println(line);
		}
}

