package com.example.springmybatisplusdemo.repository.provider;

import com.example.springmybatisplusdemo.entities.Address;
import org.apache.ibatis.jdbc.SQL;

public class AddressProvider {
    public String selectAddress(){
        return new SQL(){{
            SELECT("*");
            FROM("address");
        }}.toString();
    }
}
