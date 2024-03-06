package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	
	Connection con;
	/**
	 * This method is used to connect to Database
	 * @Prashanthi
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBurl, IpathConstants.un, IpathConstants.pwd);
			
	}
	/**
	 * This method is used to execute a select query
	 * @param query
	 * @param colIndex
	 * @param exp_result
	 * @throws SQLException
	 */
	public void executeQuery(String query, int colIndex,String exp_result) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String act_result = result.getString(colIndex);
			if(act_result.equalsIgnoreCase(exp_result))
			{
				flag=true;
				break;
			}
			if(flag)
			{
				System.out.println("----Data is present----");
			}
			else
			{
				System.out.println("----Data is not present----");
			}
		}
	
		
	}
	/**
	 * This method is used to execute non select query
	 * @param query
	 * @throws SQLException
	 */
	public void updateQuery(String query) throws SQLException
	{
	Statement state = con.createStatement();
	state.executeUpdate(query);
	}
	/**
	 * This method is used to close DB connection
	 * @throws SQLException
	 */
	public void disConnectDB() throws SQLException
	{
		con.close();
	}

}
