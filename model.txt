public class Movie {
private String TITLE;
private String REGION;
private String LANGUAGE;
private String YEAR;
private double RATING;
private int VOTES;
private String directorName;
private int SEASONNUMBER;
private int COUNT;
private String TYPE;
private int RUNTIMEMINUTES;
public Movie(String tITLE, String tYPE, int rUNTIMEMINUTES) {
	super();
	TITLE = tITLE;
	TYPE = tYPE;
	RUNTIMEMINUTES = rUNTIMEMINUTES;
}
public int getRUNTIMEMINUTES() {
	return RUNTIMEMINUTES;
}
public Movie(String tITLE) {
	super();
	TITLE = tITLE;
}
public void setRUNTIMEMINUTES(int rUNTIMEMINUTES) {
	RUNTIMEMINUTES = rUNTIMEMINUTES;
}
public Movie(String tITLE,String tYPE,int iSADULT, String yEAR, int sEASONNUMBER,
		 int ePIDOSENUMBER,int vOTES) {
	super();
	TITLE = tITLE;
	YEAR = yEAR;
	VOTES = vOTES;
	SEASONNUMBER = sEASONNUMBER;
	TYPE = tYPE;
	ISADULT = iSADULT;
	EPIDOSENUMBER = ePIDOSENUMBER;
}
public String getTYPE() {
	return TYPE;
}
public void setTYPE(String tYPE) {
	TYPE = tYPE;
}
public int getISADULT() {
	return ISADULT;
}
public void setISADULT(int iSADULT) {
	ISADULT = iSADULT;
}
public int getEPIDOSENUMBER() {
	return EPIDOSENUMBER;
}
public void setEPIDOSENUMBER(int ePIDOSENUMBER) {
	EPIDOSENUMBER = ePIDOSENUMBER;
}
private int ISADULT;
private int EPIDOSENUMBER;
public int getCOUNT() {
	return COUNT;
}
public Movie(double rATING, int cOUNT) {
	super();
	RATING = rATING;
	COUNT = cOUNT;
}
public void setCOUNT(int cOUNT) {
	COUNT = cOUNT;
}
public Movie(String tITLE, double rATING, int sEASONNUMBER) {
	super();
	TITLE = tITLE;
	RATING = rATING;
	SEASONNUMBER = sEASONNUMBER;
}
public int getSEASONNUMBER() {
	return SEASONNUMBER;
}
public void setSEASONNUMBER(int sEASONNUMBER) {
	SEASONNUMBER = sEASONNUMBER;
}
public String getDirectorName() {
	return directorName;
}
public void setDirectorName(String directorName) {
	this.directorName = directorName;
}
public String getTITLE() {
	return TITLE;
}
public Movie(String tITLE, String rEGION, String lANGUAGE, String yEAR,
		double rATING, int vOTES) {
	super();
	TITLE = tITLE;
	REGION = rEGION;
	LANGUAGE = lANGUAGE;
	YEAR = yEAR;
	RATING = rATING;
	VOTES = vOTES;
}
public Movie() {
	super();
	// TODO Auto-generated constructor stub
}
public void setTITLE(String tITLE) {
	TITLE = tITLE;
}
public String getREGION() {
	return REGION;
}
public void setREGION(String rEGION) {
	REGION = rEGION;
}
public String getLANGUAGE() {
	return LANGUAGE;
}
public void setLANGUAGE(String lANGUAGE) {
	LANGUAGE = lANGUAGE;
}
public String getYEAR() {
	return YEAR;
}
public void setYEAR(String yEAR) {
	YEAR = yEAR;
}
public double getRATING() {
	return RATING;
}
public void setRATING(double rATING) {
	RATING = rATING;
}
public int getVOTES() {
	return VOTES;
}
public void setVOTES(int vOTES) {
	VOTES = vOTES;
}
}
