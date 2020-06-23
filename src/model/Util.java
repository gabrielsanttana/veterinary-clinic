package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
	
	
	
	public static String DateToStringSQL(Date strDate) {
		String ts = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Timestamp timestamp = new Timestamp(strDate.getTime());
		    ts = sdf.format(timestamp);
		} catch (Exception e) {
            Logger.getLogger(Treatment.class.getName()).log(Level.SEVERE, null, e);
		}
	    return ts;
	}
	
	public static Date StringToDate(String strDate){
		Date date = new Date(); 
		try {
			date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date;
		    
	}  

	public static Date StringToOnlyDate(String strDate) 
	{
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return null;
	}
	

}
