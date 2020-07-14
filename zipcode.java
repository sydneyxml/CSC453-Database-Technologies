// Ximan Liu

package CSC453;


import java.sql.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class zipcode
{
    Connection c;
    String link = "jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:ACADPRD0";

    public static void main(String[] args) throws java.sql.SQLException
    {
    	zipcode part = new zipcode();

    	part.runTest(Integer.parseInt(args[0]));
    }
 
    public zipcode()
    {
    try
	{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    
	    String URL = "jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:ACADPRD0";
	    this.link = URL;
	    /*3. Creating Database Connection*/
	    c = DriverManager.getConnection(URL, "xliu115", "cdm1935858");
	    
	    run();

	}
    catch (ClassNotFoundException ex) {System.err.println("Class not found " + ex.getMessage());}
    catch (SQLException ex)           {System.err.println(ex.getMessage());}
    }

    public void runTest( int w ) throws java.sql.SQLException
    {
	c = DriverManager.getConnection(link, "xliu115", "cdm1935858");

	switch (w) {
	case 1:  
	    Test1();
	    break;
	case 2:  
		Test2();
	    break;
	case 3:
		Test3("60064");
		Test3("60086");
		Test3("60185");
		Test3("60186");
		Test3("60411");
		Test3("60412");
		Test3("60415");
		Test3("60601");
		Test3("60602");
		Test3("60603");
		Test3("60604");
		Test3("60605");
		Test3("60606");
		Test3("60607");
		Test3("60608");
		Test3("60609");
		Test3("60610");
		Test3("60611");
		Test3("60612");
		Test3("60613");
		Test3("60614");
		Test3("60615");
		Test3("60616");
		Test3("60617");
		Test3("60618");
		Test3("60619");
		Test3("60620");
		Test3("60621");
		Test3("60622");
		Test3("60623");
		Test3("60624");
		Test3("60625");
		Test3("60626");
		Test3("60628");
		Test3("60629");
		Test3("60630");
		Test3("60631");
		Test3("60632");
		Test3("60633");
		Test3("60634");
		Test3("60636");
		Test3("60637");
		Test3("60638");
		Test3("60639");
		Test3("60640");
		Test3("60641");
		Test3("60643");
		Test3("60644");
		Test3("60645");
		Test3("60646");
		Test3("60647");
		Test3("60649");
		Test3("60650");
		Test3("60651");
		Test3("60652");
		Test3("60653");
		Test3("60654");
		Test3("60655");
		Test3("60656");
		Test3("60657");
		Test3("60659");
		Test3("60660");
		Test3("60661");
		Test3("60663");
		Test3("60664");
		Test3("60665");
		Test3("60667");
		Test3("60668");
		Test3("60669");
		Test3("60670");
		Test3("60671");
		Test3("60672");
		Test3("60673");
		Test3("60674");
		Test3("60675");
		Test3("60677");
		Test3("60678");
		Test3("60679");
		Test3("60680");
		Test3("60681");
		Test3("60683");
		Test3("60684");
		Test3("60685");
		Test3("60687");
		Test3("60690");
		Test3("60691");
		Test3("60692");
		Test3("60693");
		Test3("60694");
		Test3("60697");
		Test3("60699");
		Test3("60701");
	    break;
	case 4:
	    Test4("ZipCode");
	    break;
	}

	c.close();
    }

    private void run()
    {
	 Test1();
    }

    /* Case 1 */
    private void Test1()
    {
	System.out.println("\nTest1:\n");
	String sql = "SELECT R.name, Z.zip, Z.latitude, Z.longitude FROM Restaurant_Locations R, ZipCode Z WHERE R.zipcode = Z.zip";
    try
	{
	    Statement cs = c.createStatement();
	    ResultSet eq = cs.executeQuery(sql);
	    while (eq.next())
		{
            String name = eq.getString("name");
		    String zip = eq.getString("zip");
		    String latitude = eq.getString("latitude");
		    String longitude = eq.getString("longitude");
		    System.out.println(name + "   " + zip + "   " + latitude  + "   " + longitude);
		}
	}
    catch (SQLException ex)
	{
	    System.err.println("Select failure " + ex.getMessage());
	}
}
    /* Case 2 */
    private void Test2()
    {
	System.out.println("\nTest2:\n");
	String sql = "SELECT * FROM ZipCode";
    try
	{
	    Statement cs = c.createStatement();
	    ResultSet eq = cs.executeQuery(sql);
	    while (eq.next())
		{
            String zip = eq.getString("zip");
            String city = eq.getString("city");
            String state = eq.getString("state");
		    String latitude = eq.getString("latitude");
		    String longitude = eq.getString("longitude");
            String timezone = eq.getString("timezone");
            String dst = eq.getString("dst");
		    System.out.println(zip + "   " + city + "   " + state + "   " + latitude  + "   " + longitude + "   " + timezone + "   " + dst);
		}
	}
    catch (SQLException ex)
	{
	    System.err.println("Fail " + ex.getMessage());
	}
}
    
    /* Case 3*/
	private void Test3(String name)
    {
    	System.out.print("\nTest3:\n");

    	String str =
	    "INSERT INTO ZipCode values(?,?,?,?,?,?,?)";    

	try
	{
        BufferedReader br = new BufferedReader(new FileReader
        		("/Users/liuximan/Desktop/CSC453/HW4/ChIzipcode.csv"));
        String s = ""; 
        while ((s = br.readLine()) != null) {
            try {
                if (s != null) 
                {
                    String[] array = s.split("\\s+");
                    for(String result:array)
                    {	
                    	System.out.println(result);
                        
           //Create preparedStatement here and set them and execute them            
                PreparedStatement Statement = c.prepareStatement(str);
                Statement.setInt(1, 60064);
                Statement.setString(2, "North Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 42.326072);
                Statement.setDouble(5, -87.85202);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60086);
                Statement.setString(2, "North Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 42.43335);
                Statement.setDouble(5, -87.776595);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60185);
                Statement.setString(2, "West Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.891978);
                Statement.setDouble(5, -88.20502);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60186);
                Statement.setString(2, "West Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.839679);
                Statement.setDouble(5, -88.088716);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60411);
                Statement.setString(2, "Chicago Heights");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.511307);
                Statement.setDouble(5, -87.6101);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60412);
                Statement.setString(2, "Chicago Heights");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60415);
                Statement.setString(2, "Chicago Ridge");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.702482);
                Statement.setDouble(5, -87.77869);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60601);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.886456);
                Statement.setDouble(5, -87.62325);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60602);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.882937);
                Statement.setDouble(5, -87.62874);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60603);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.880446);
                Statement.setDouble(5, -87.63014);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60604);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.877589);
                Statement.setDouble(5, -87.62818);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60605);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.860019);
                Statement.setDouble(5, -87.6187);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60606);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.882582);
                Statement.setDouble(5, -87.6376);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60607);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.875882);
                Statement.setDouble(5, -87.65114);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60608);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.850532);
                Statement.setDouble(5, -87.6699);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60609);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.814283);
                Statement.setDouble(5, -87.65282);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60610);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.898582);
                Statement.setDouble(5, -87.6371);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60611);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.904667);
                Statement.setDouble(5, -87.62504);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60612);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.880682);
                Statement.setDouble(5, -87.6877);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60613);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.953256);
                Statement.setDouble(5, -87.6629);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60614);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.922682);
                Statement.setDouble(5, -87.65432);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60615);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.801525);
                Statement.setDouble(5, -87.60215);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60616);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.8474);
                Statement.setDouble(5, -87.63126);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60617);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.719973);
                Statement.setDouble(5, -87.5557);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60618);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.945681);
                Statement.setDouble(5, -87.7048);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60619);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.744834);
                Statement.setDouble(5, -87.60444);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60620);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.740483);
                Statement.setDouble(5, -87.65282);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60621);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.776983);
                Statement.setDouble(5, -87.6404);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60622);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.900332);
                Statement.setDouble(5, -87.66927);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60623);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.850232);
                Statement.setDouble(5, -87.718);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60624);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.879365);
                Statement.setDouble(5, -87.72199);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
               
                
                Statement.setInt(1, 60625);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.971614);
                Statement.setDouble(5, -87.70256);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60626);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 42.009731);
                Statement.setDouble(5, -87.66938);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60628);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.695434);
                Statement.setDouble(5, -87.62255);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60629);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.777482);
                Statement.setDouble(5, -87.71155);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60630);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.971044);
                Statement.setDouble(5, -87.75869);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60631);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.99623);
                Statement.setDouble(5, -87.81091);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60632);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.809299);
                Statement.setDouble(5, -87.7105);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60633);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.655423);
                Statement.setDouble(5, -87.55365);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60634);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.944454);
                Statement.setDouble(5, -87.79654);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60636);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.776633);
                Statement.setDouble(5, -87.66854);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60637);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.779384);
                Statement.setDouble(5, -87.60544);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60638);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.787982);
                Statement.setDouble(5, -87.7738);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60639);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.921431);
                Statement.setDouble(5, -87.75415);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60640);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.973181);
                Statement.setDouble(5, -87.6665);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60641);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.946431);
                Statement.setDouble(5, -87.74576);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60643);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.696433);
                Statement.setDouble(5, -87.65993);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60644);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.881331);
                Statement.setDouble(5, -87.75671);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60645);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 42.008956);
                Statement.setDouble(5, -87.69634);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60646);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.995331);
                Statement.setDouble(5, -87.7601);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60647);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.921126);
                Statement.setDouble(5, -87.70085);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60649);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.761734);
                Statement.setDouble(5, -87.57072);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60650);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.818682);
                Statement.setDouble(5, -87.743454);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60651);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.901485);
                Statement.setDouble(5, -87.74055);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60652);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.7446);
                Statement.setDouble(5, -87.71188);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60653);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.819833);
                Statement.setDouble(5, -87.61269);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60654);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.888627);
                Statement.setDouble(5, -87.63538);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60655);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.696283);
                Statement.setDouble(5, -87.69912);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60656);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.97508);
                Statement.setDouble(5, -87.8163);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60657);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.940832);
                Statement.setDouble(5, -87.65852);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60659);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.991381);
                Statement.setDouble(5, -87.70378);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60660);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.990631);
                Statement.setDouble(5, -87.6667);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60661);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.882082);
                Statement.setDouble(5, -87.64461);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60663);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60664);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60665);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60667);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60668);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60669);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60670);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60671);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60672);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60673);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60674);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60675);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60677);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60678);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60679);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60680);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60681);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60683);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.setInt(1, 60684);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60685);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60687);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60690);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60691);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60692);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.867532);
                Statement.setDouble(5, -87.672553);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60693);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 42.096428);
                Statement.setDouble(5, -87.71791);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60694);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60697);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60699);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();
                
                Statement.setInt(1, 60701);
                Statement.setString(2, "Chicago");
                Statement.setString(3, "IL");
                Statement.setDouble(4, 41.811929);
                Statement.setDouble(5, -87.68732);
                Statement.setInt(6, -6);
                Statement.setInt(7, 1);
                Statement.addBatch();

                Statement.executeBatch();
                Statement.close();
                              
                    }
                } 
            }
            finally
            {
               if (br == null) 
                {
                    br.close();
                }
            }
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException ex) {
		System.err.println("Insert failure " + ex.getMessage());
	}
}

	/* Case 4*/
    private void Test4(String t)
    {
	System.out.print("\nTest4 using " + t + ":");

    try
	{
	    Statement cs = c.createStatement();

	    cs.executeUpdate("DELETE FROM " + t
	    		+ " WHERE zip IS NOT NULL");
	}
    catch (SQLException ex)
	{
	    System.err.println("Failure " + ex.getMessage());
	}
    }
}

