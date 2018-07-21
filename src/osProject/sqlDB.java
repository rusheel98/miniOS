package osProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;

public class sqlDB {
	private Connection con;
	private Statement stmt;
	public static String result[][];
	private ResultSet rs;
	
	public sqlDB()   
	{
		con = null;
		stmt = null;		
	}
	
	
	public Connection initconnection(String connectiontype) {
		String driver,url,host,pwd;
		driver = url = host = pwd = null;
		if(connectiontype.equalsIgnoreCase("Mysql"))
		{
			driver  = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost/osProject";
			host = "root";
			pwd = "rushi123";
		}
		connectDB(0,driver,url,host,pwd);
		return con;
	}
	
	
	public void connectDB(int place,String driver, String url, String host, String pwd) {
		String errorstmt = null;
		try {
			Properties properties = new Properties();
			properties.setProperty("user", host);
			properties.setProperty("password", pwd);
			properties.setProperty("useSSL", "false");		
			properties.setProperty("autoReconnect", "true");		
			
 
			con = DriverManager.getConnection(url,properties);
			if(con==null)
			{
				errorstmt = "No Connection";
			}
			stmt = con.createStatement();
			if(stmt==null)
			{
				errorstmt = "Statement null";
			}			
			
		} catch (SQLException e) {
			System.out.println(errorstmt+" "+e.getMessage());
			e.printStackTrace();
		}  
	}
	
	public String[][] executestmt(String sql)
	{
		ArrayList<String[]> al = new ArrayList<>(); 
		try
		{
			rs = stmt.executeQuery(sql);
			int k = rs.getMetaData().getColumnCount();
			while(rs.next())
			{
				String a[] = new String[k]; 
				for(int i=0;i<k;i++)
				{
					a[i] = rs.getString(i+1);
			    }
				al.add(a);
			}
			result = new String[al.size()][k];
			al.toArray(result);
		}
		catch (Exception e)
		{
			rs=null;
		    e.getMessage();
		}
		return result;
	}
	
	public void updatestmt(String sql)
	{
		try
		{
			 stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	public void closeall( )
	{
		try {
			if(con!=null)
			{
			con.close();
			con=null;
			}
			if(stmt!=null)
			{
			stmt.close();
			stmt=null;
			}
			if(rs!=null)
			{
			rs.close();
			rs=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
   /* Used to test DB class
    * 
	public static void main(String[] args) {
		String sql1 = "select * from login;";
		sqlDB dbc = new sqlDB();
		String connectiontype = "Mysql";
		db.initconnection("Mysql");
		db.executestmt(sql1);
		for(int i=0;i<db.result.length;i++)
		{
			for(int j=0;j<db.result[i].length;j++)
			{
				System.out.print(db.result[i][j]+"----");
			}
			System.out.println();
		}
		db.closeall();
	}
   }
  } */
