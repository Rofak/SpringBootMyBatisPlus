package com.example.springmybatisplusdemo.service.Imp;

import com.example.springmybatisplusdemo.entities.Address;
import com.example.springmybatisplusdemo.mapper.AddressMapper;
import com.example.springmybatisplusdemo.repository.AddressRepository;
import com.example.springmybatisplusdemo.service.AddressService;
import com.github.yulichang.base.MPJBaseServiceImpl;

public class AddressServiceImpl extends MPJBaseServiceImpl<AddressMapper, Address> implements AddressService {
    private AddressRepository repository;
    public AddressServiceImpl(AddressRepository repository){
        this.repository=repository;
    }
}
