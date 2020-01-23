package com.mysql.data;

import java.util.Properties;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

/** This class connects with another class(MysqlData) which fetches the data from Mysql database
 *  and dump into a CSV file 
 */
public class DataDumper {
	Properties p = null;
	ResultSet  r = null;
	static int count;
	
	public  DataDumper (String database, String table) throws Exception {
		
		MysqlData msd = new MysqlData();
		
		//Call configure() function which takes the configurations of database from configuration file
		p = msd.configure();
		
		//call fetch() function which fetches the data from Mysql database
		r = msd.fetch(p, database, table);
		
		//call csvLoad() which will load CSV file with Mysql data
		csvLoad(r, p);
	}
	
	//This function takes Mysql data and configuration object as input and dumps data to CSV file
	public void csvLoad (ResultSet rs, Properties prop) throws Exception {
		
		count++;
        String fileSeparator = System.getProperty("file.separator");
        String loc = "C:\\Users\\"+prop.getProperty("systemUser")+"\\eclipse-workspace\\JavaCLI\\mysql.csv";
        
        //absolute file name with path
        String absoluteFilePath = fileSeparator+"Users"+fileSeparator+prop.getProperty("systemUser")+fileSeparator+"mysqlData"+count+".csv";
        
        FileWriter fw = new FileWriter(loc);
        int cols = rs.getMetaData().getColumnCount();
        
        //Load column names to CSV file
        for(int i = 1; i <= cols; i ++){
          fw.append(rs.getMetaData().getColumnLabel(i));
          if(i < cols) fw.append(',');
            else fw.append('\n');
        }

        //Write data row by row to CSV file  
        while (rs.next()) {
          for(int i = 1; i <= cols; i ++){
            fw.append(rs.getString(i));
            if(i < cols) fw.append(',');
          }
          fw.append('\n');
        }
        fw.flush();
        fw.close();
        
        //Move the file to system's user location
        Files.move 
        (Paths.get(loc), 
         Paths.get(absoluteFilePath));
        
        System.out.println("MySQL data successfully dumped into file at location: "+absoluteFilePath); 
	}
}
