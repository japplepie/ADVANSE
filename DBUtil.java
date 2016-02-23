
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.util.*;

public class DBUtil{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/LBDB";
	private static final String USER = "root";
	private static final String PASS = "p@ssword";
	private Connection conn = null;
	private Statement stmt = null;

	public DBUtil(){
		try{
			System.out.println("Trying...");
			Class.forName("com.mysql.jdbc.Driver");
			this.conn =(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
			
			this.stmt = (Statement) this.conn.createStatement();}
		catch(SQLException se){
			System.out.println("Wrong DB url, user, pass");}
		catch(Exception e){
			System.out.println("JDBC Driver not properly set.");}}

	public Statement getStatement(){
		return this.stmt;}
	
	public Connection getConnection(){
		if(conn != null) System.out.println("connection established.");
		return this.conn;
		}
	}