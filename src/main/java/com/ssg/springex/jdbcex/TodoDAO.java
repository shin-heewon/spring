package com.ssg.springex.jdbcex;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    String now = null;
    public String getTime(){



        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            ResultSet rs = pstmt.executeQuery();
        ){
            rs.next();

            now = rs.getString(1);


        }catch (Exception e){
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception{

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        now = rs.getString(1);
        return now;
    }


}
