package com.stackroute.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Tracks" )
@Data
public class Track {

    @Id
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="column")
    String comment;

    public Track(){}


    public Track(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }
}
