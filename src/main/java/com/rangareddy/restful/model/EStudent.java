package com.rangareddy.restful.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RANGAREJ on 5/5/2018.
 */
@Entity
@Table(name = "STUDENT")
public class EStudent {
    @Id
    @Column(name = "SID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    @Column(name = "SNAME")
    private String sname;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EAddress> addressList;

    public List<EAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<EAddress> addressList) {
        this.addressList = addressList;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
