package com.four.exam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Loginstutestpaper {
    private int lstpid;
    private String snumber;
    private Integer tpid;
    private int tqnum;
    private String lstpanswer;
    private double lstpgetscore;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lstpid")
    public int getLstpid() {
        return lstpid;
    }

    public void setLstpid(int lstpid) {
        this.lstpid = lstpid;
    }

    @Basic
    @Column(name = "snumber")
    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
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
    @Column(name = "lstpanswer")
    public String getLstpanswer() {
        return lstpanswer;
    }

    public void setLstpanswer(String lstpanswer) {
        this.lstpanswer = lstpanswer;
    }

    @Basic
    @Column(name = "lstpgetscore")
    public double getLstpgetscore() {
        return lstpgetscore;
    }

    public void setLstpgetscore(double lstpgetscore) {
        this.lstpgetscore = lstpgetscore;
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
        Loginstutestpaper that = (Loginstutestpaper) o;
        return lstpid == that.lstpid &&
                tqnum == that.tqnum &&
                Double.compare(that.lstpgetscore, lstpgetscore) == 0 &&
                Objects.equals(snumber, that.snumber) &&
                Objects.equals(tpid, that.tpid) &&
                Objects.equals(lstpanswer, that.lstpanswer) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public String toString() {
        return "Loginstutestpaper{" +
                "lstpid=" + lstpid +
                ", snumber='" + snumber + '\'' +
                ", tpid=" + tpid +
                ", tqnum=" + tqnum +
                ", lstpanswer='" + lstpanswer + '\'' +
                ", lstpgetscore=" + lstpgetscore +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstpid, snumber, tpid, tqnum, lstpanswer, lstpgetscore, b1, b2, b3);
    }
}
