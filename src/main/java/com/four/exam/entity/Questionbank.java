package com.four.exam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Questionbank {
    private int qbid;
    private String qboutline;
    private String qbtype;
    private String qbtext;
    private String qboptions;
    private String qbanswer;
    private String qbdifficulty;
    private String qbcreatetime;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qbid")
    public int getQbid() {
        return qbid;
    }

    public void setQbid(int qbid) {
        this.qbid = qbid;
    }

    @Basic
    @Column(name = "qboutline")
    public String getQboutline() {
        return qboutline;
    }

    public void setQboutline(String qboutline) {
        this.qboutline = qboutline;
    }

    @Basic
    @Column(name = "qbtype")
    public String getQbtype() {
        return qbtype;
    }

    public void setQbtype(String qbtype) {
        this.qbtype = qbtype;
    }

    @Basic
    @Column(name = "qbtext")
    public String getQbtext() {
        return qbtext;
    }

    public void setQbtext(String qbtext) {
        this.qbtext = qbtext;
    }

    @Basic
    @Column(name = "qboptions")
    public String getQboptions() {
        return qboptions;
    }

    public void setQboptions(String qboptions) {
        this.qboptions = qboptions;
    }

    @Basic
    @Column(name = "qbanswer")
    public String getQbanswer() {
        return qbanswer;
    }

    public void setQbanswer(String qbanswer) {
        this.qbanswer = qbanswer;
    }

    @Basic
    @Column(name = "qbdifficulty")
    public String getQbdifficulty() {
        return qbdifficulty;
    }

    public void setQbdifficulty(String qbdifficulty) {
        this.qbdifficulty = qbdifficulty;
    }

    @Basic
    @Column(name = "qbcreatetime")
    public String getQbcreatetime() {
        return qbcreatetime;
    }

    public void setQbcreatetime(String qbcreatetime) {
        this.qbcreatetime = qbcreatetime;
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
        Questionbank that = (Questionbank) o;
        return qbid == that.qbid &&
                Objects.equals(qboutline, that.qboutline) &&
                Objects.equals(qbtype, that.qbtype) &&
                Objects.equals(qbtext, that.qbtext) &&
                Objects.equals(qboptions, that.qboptions) &&
                Objects.equals(qbanswer, that.qbanswer) &&
                Objects.equals(qbdifficulty, that.qbdifficulty) &&
                Objects.equals(qbcreatetime, that.qbcreatetime) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qbid, qboutline, qbtype, qbtext, qboptions, qbanswer, qbdifficulty, qbcreatetime, b1, b2, b3);
    }

    @Override
    public String toString() {
        return "Questionbank{" +
                "qbid=" + qbid +
                ", qboutline='" + qboutline + '\'' +
                ", qbtype='" + qbtype + '\'' +
                ", qbtext='" + qbtext + '\'' +
                ", qboptions='" + qboptions + '\'' +
                ", qbanswer='" + qbanswer + '\'' +
                ", qbdifficulty='" + qbdifficulty + '\'' +
                ", qbcreatetime='" + qbcreatetime + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }
}
