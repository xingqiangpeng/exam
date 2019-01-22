package com.four.exam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Stutestpaper {
    private int stpid;
    private String sname;
    private String tpwritemessage;
    private Integer tpid;
    private int tqnum;
    private String stpanswer;
    private double stpscore;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "stpid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStpid() {
        return stpid;
    }

    public void setStpid(int stpid) {
        this.stpid = stpid;
    }

    @Basic
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "tpwritemessage")
    public String getTpwritemessage() {
        return tpwritemessage;
    }

    public void setTpwritemessage(String tpwritemessage) {
        this.tpwritemessage = tpwritemessage;
    }

    @Basic
    @Column(name = "tpid")
    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    @Basic
    @Column(name = "tqnum")
    public int getTqnum() {
        return tqnum;
    }

    public void setTqnum(int tqnum) {
        this.tqnum = tqnum;
    }

    @Basic
    @Column(name = "stpanswer")
    public String getStpanswer() {
        return stpanswer;
    }

    public void setStpanswer(String stpanswer) {
        this.stpanswer = stpanswer;
    }

    @Basic
    @Column(name = "stpscore")
    public double getStpscore() {
        return stpscore;
    }

    public void setStpscore(double stpscore) {
        this.stpscore = stpscore;
    }

    @Basic
    @Column(name = "b1")
    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    @Basic
    @Column(name = "b2")
    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    @Basic
    @Column(name = "b3")
    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stutestpaper that = (Stutestpaper) o;
        return stpid == that.stpid &&
                tqnum == that.tqnum &&
                Double.compare(that.stpscore, stpscore) == 0 &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(tpwritemessage, that.tpwritemessage) &&
                Objects.equals(tpid, that.tpid) &&
                Objects.equals(stpanswer, that.stpanswer) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stpid, sname, tpwritemessage, tpid, tqnum, stpanswer, stpscore, b1, b2, b3);
    }

    @Override
    public String toString() {
        return "Stutestpaper{" +
                "stpid=" + stpid +
                ", sname='" + sname + '\'' +
                ", tpwritemessage='" + tpwritemessage + '\'' +
                ", tpid=" + tpid +
                ", tqnum=" + tqnum +
                ", stpanswer='" + stpanswer + '\'' +
                ", stpscore=" + stpscore +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }
}
