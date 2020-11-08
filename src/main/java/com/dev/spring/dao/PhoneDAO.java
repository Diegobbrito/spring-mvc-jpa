package com.dev.spring.dao;

import com.dev.spring.entity.Phone;

public class PhoneDAO extends GenericDAO<Phone>{
    public PhoneDAO(){
        super(Phone.class);
    }
}
