package com.dev.spring.dao;

import com.dev.spring.entity.Address;

public class AddressDAO extends GenericDAO<Address> {

    public AddressDAO(){
        super(Address.class);
    }
}
