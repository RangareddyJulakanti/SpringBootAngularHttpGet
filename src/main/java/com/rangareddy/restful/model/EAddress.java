package com.rangareddy.restful.model;

import javax.persistence.*;

/**
 * Created by RANGAREJ on 5/6/2018.
 */
@Entity
@Table(name = "ADDRESS")
public class EAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer aid;
    private String address;





    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
