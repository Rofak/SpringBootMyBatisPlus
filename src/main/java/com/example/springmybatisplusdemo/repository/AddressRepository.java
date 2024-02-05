package com.example.springmybatisplusdemo.repository;

import com.example.springmybatisplusdemo.entities.Address;
import com.example.springmybatisplusdemo.repository.provider.AddressProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository {

    @SelectProvider(value = AddressProvider.class,method = "selectAddress")
    Address selectAddress();
}
