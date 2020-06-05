package model;

import java.sql.*;

public abstract class DAO {
	
	private static Connection con;

    public static Connection getConnection() {
    	if (con != null) {
    		return con;
    	}
    	
        try {
        	Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db");

            System.out.println("Conexão realizada !!!!");
            
            con = connection;
            
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            s.executeQuery(query);
            rs = s.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }
}