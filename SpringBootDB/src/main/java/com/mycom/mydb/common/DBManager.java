package com.mycom.mydb.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    public static void releaseConnection(PreparedStatement pstmt, Connection con) {
        try {
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close(); // overriding 되어 있어서 객체를 종료하지 않고, 반납!
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if( rs != null ) rs.close();
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void releaseConnection(AutoCloseable... params) {
        for (AutoCloseable ac : params) {
            if( ac != null ) {
                try {
                    ac.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
