package org.easybookmark.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name = "address")
@Table(name = "address")
public class Address extends PanacheEntity{
        
    public String url;

}