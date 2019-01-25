package com.four.exam.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stutestscore {
    private int stsid;
    private Integer sid;
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
    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
        Stutestscore that = (Stutestscore) o;
        return stsid == that.stsid &&
                Double.compare(that.stsscore, stsscore) == 0 &&
                Objects.equals(sid, that.sid) &&
                Objects.equals(tpid, that.tpid) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public String toString() {
        return "Stutestscore{" +
                "stsid=" + stsid +
                ", sid=" + sid +
                ", tpid=" + tpid +
                ", stsscore=" + stsscore +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(stsid, sid, tpid, stsscore, b1, b2, b3);
    }
}
