package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
	
	public static String DateToStringSQL(Date d) {
		String ts = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Timestamp timestamp = new Timestamp(d.getTime());
		    ts = sdf.format(timestamp);
		} catch (Exception e) {
            Logger.getLogger(Treatment.class.getName()).log(Level.SEVERE, null, e);
			// TODO: handle exception
		}
	    return ts;
	}
	
	public static Date StringToDate(String d){
		Date date = new Date(); 
		try {
			date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date;
		    
	}  


}
