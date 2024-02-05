package com.example.springmybatisplusdemo.repository.provider;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String selectUser(){
        return new SQL(){{
            SELECT("*");
            FROM("user");
        }}.toString();
    }

    public String selectAddressById(){
        return new SQL(){{
            SELECT("*");
            FROM("address");
            WHERE("id=#{address_id}");
        }}.toString();
    }

    public String selectPostByUserId(){
        return new SQL(){{
            SELECT("*");
            FROM("post");
            WHERE("user_id=#{userId}");
        }}.toString();
    }
}
