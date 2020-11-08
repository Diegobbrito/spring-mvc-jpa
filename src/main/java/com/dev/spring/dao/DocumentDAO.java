package com.dev.spring.dao;

import com.dev.spring.entity.Document;

public class DocumentDAO extends GenericDAO<Document> {

    public DocumentDAO(){
        super(Document.class);
    }

}
