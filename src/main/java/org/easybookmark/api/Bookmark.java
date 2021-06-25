package org.easybookmark.api;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "bookmark")
public class Bookmark extends PanacheEntity{
    
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "address_id")
    public Set<Address> addresses;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    public String description;

    @NotEmpty
    public String title;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    public Date date;


    public String taskId;

}