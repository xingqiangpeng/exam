package com.four.exam.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Component
public class Testpaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpid;
    @Column(nullable = false,unique = true)
    private String tpname;
    private String tpbeizhu;
    private String tptype;
    private String tpwritemessage;
    private int tpscore;
    private String tpstartdate;
    private String tpenddate;
    private int tpdatitime;
    private String tpfabu;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "tpid")
    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    @Basic
    @Column(name = "tpname")
    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    @Basic
    @Column(name = "tpbeizhu")
    public String getTpbeizhu() {
        return tpbeizhu;
    }

    public void setTpbeizhu(String tpbeizhu) {
        this.tpbeizhu = tpbeizhu;
    }

    @Basic
    @Column(name = "tptype")
    public String getTptype() {
        return tptype;
    }

    public void setTptype(String tptype) {
        this.tptype = tptype;
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
    @Column(name = "tpscore")
    public int getTpscore() {
        return tpscore;
    }

    public void setTpscore(int tpscore) {
        this.tpscore = tpscore;
    }

    @Basic
    @Column(name = "tpstartdate")
    public String getTpstartdate() {
        return tpstartdate;
    }

    public void setTpstartdate(String tpstartdate) {
        this.tpstartdate = tpstartdate;
    }

    @Basic
    @Column(name = "tpenddate")
    public String getTpenddate() {
        return tpenddate;
    }

    public void setTpenddate(String tpenddate) {
        this.tpenddate = tpenddate;
    }

    @Basic
    @Column(name = "tpdatitime")
    public int getTpdatitime() {
        return tpdatitime;
    }

    public void setTpdatitime(int tpdatitime) {
        this.tpdatitime = tpdatitime;
    }

    @Basic
    @Column(name = "tpfabu")
    public String getTpfabu() {
        return tpfabu;
    }

    public void setTpfabu(String tpfabu) {
        this.tpfabu = tpfabu;
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
        Testpaper testpaper = (Testpaper) o;
        return tpid == testpaper.tpid &&
                tpscore == testpaper.tpscore &&
                tpdatitime == testpaper.tpdatitime &&
                Objects.equals(tpname, testpaper.tpname) &&
                Objects.equals(tpbeizhu, testpaper.tpbeizhu) &&
                Objects.equals(tptype, testpaper.tptype) &&
                Objects.equals(tpwritemessage, testpaper.tpwritemessage) &&
                Objects.equals(tpstartdate, testpaper.tpstartdate) &&
                Objects.equals(tpenddate, testpaper.tpenddate) &&
                Objects.equals(tpfabu, testpaper.tpfabu) &&
                Objects.equals(b1, testpaper.b1) &&
                Objects.equals(b2, testpaper.b2) &&
                Objects.equals(b3, testpaper.b3);
    }

    @Override
    public String toString() {
        return "Testpaper{" +
                "tpid=" + tpid +
                ", tpname='" + tpname + '\'' +
                ", tpbeizhu='" + tpbeizhu + '\'' +
                ", tptype='" + tptype + '\'' +
                ", tpwritemessage='" + tpwritemessage + '\'' +
                ", tpscore=" + tpscore +
                ", tpstartdate='" + tpstartdate + '\'' +
                ", tpenddate='" + tpenddate + '\'' +
                ", tpdatitime=" + tpdatitime +
                ", tpfabu='" + tpfabu + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpid, tpname, tpbeizhu, tptype, tpwritemessage, tpscore, tpstartdate, tpenddate, tpdatitime, tpfabu, b1, b2, b3);
    }


}
