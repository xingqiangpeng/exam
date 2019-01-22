package com.four.exam.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stutestscore2 {
    private int stsid;
    private String information;
    private Integer tpid;
    private double stsscore;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "stsid")
    public int getStsid() {
        return stsid;
    }

    public void setStsid(int stsid) {
        this.stsid = stsid;
    }

    @Basic
    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
    @Column(name = "stsscore")
    public double getStsscore() {
        return stsscore;
    }

    public void setStsscore(double stsscore) {
        this.stsscore = stsscore;
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
        Stutestscore2 that = (Stutestscore2) o;
        return stsid == that.stsid &&
                Double.compare(that.stsscore, stsscore) == 0 &&
                Objects.equals(information, that.information) &&
                Objects.equals(tpid, that.tpid) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stsid, information, tpid, stsscore, b1, b2, b3);
    }
}
