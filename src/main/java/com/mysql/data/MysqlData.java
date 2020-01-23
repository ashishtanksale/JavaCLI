package com.mysql.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;

/**This class connects with database 
 * and fetches data from Mysql table */
public class MysqlData {
	
       //This function takes necessary configurations from .properties file 	
	   public Properties configure() {
		  // TODO Auto-generated method stub
		   Properties prop = new Properties();
	       try {

		        File jarPath=new File(MysqlData.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
		        prop.load(new FileInputStream(propertiesPath+"/config.properties"));
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }  
		    return prop;

	    }

	    //This function connects with database and fetches data from a table
     	public ResultSet fetch( Properties prop, String database, String table) throws Exception {
            Class.forName(prop.getProperty("driver")).newInstance();
            Connection conn;
            ResultSet rs = null;
			try {
				conn = DriverManager.getConnection(prop.getProperty("url") + database, prop.getProperty("user"), prop.getProperty("pass"));
	            String query = "select * from " + table;
	            Statement stmt = conn.createStatement();       
	            rs = stmt.executeQuery(query);    
	            return rs; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Please ensure correct database name or table name entered..");
				System.out.println("Thank you! Try again later");
				System.exit(0);
	            return rs;
			}  
     	}
}

