package com.example.roadcamera.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 123456789L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String carNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp")
    private Date timestamp;

  public Car () {}

    public Car ( String carNumber, Date timestamp ){
        this.carNumber = carNumber;
        this.timestamp = timestamp;
    }

    public Integer getId (){
        return id;
    }

    public void setId ( Integer id ){
        this.id = id;
    }

    public String getCarNumber (){
        return carNumber;
    }

    public void setCarNumber ( String carNumber ){
        this.carNumber = carNumber;
    }

    public Date getTimestamp (){
        return timestamp;
    }

    public void setTimestamp ( Date timestamp ){
        this.timestamp = timestamp;
    }
}
