package com.four.exam.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Testquestions {
    private int tqid;
    private Integer tpid;
    private String tqbigtitle;
    private int tqnum;
    private Integer qbid;
    private double tqscore;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "tqid")
    public int getTqid() {
        return tqid;
    }

    public void setTqid(int tqid) {
        this.tqid = tqid;
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
    @Column(name = "tqbigtitle")
    public String getTqbigtitle() {
        return tqbigtitle;
    }

    public void setTqbigtitle(String tqbigtitle) {
        this.tqbigtitle = tqbigtitle;
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
    @Column(name = "qbid")
    public Integer getQbid() {
        return qbid;
    }

    public void setQbid(Integer qbid) {
        this.qbid = qbid;
    }

    @Basic
    @Column(name = "tqscore")
    public double getTqscore() {
        return tqscore;
    }

    public void setTqscore(double tqscore) {
        this.tqscore = tqscore;
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
        Testquestions that = (Testquestions) o;
        return tqid == that.tqid &&
                tqnum == that.tqnum &&
                Double.compare(that.tqscore, tqscore) == 0 &&
                Objects.equals(tpid, that.tpid) &&
                Objects.equals(tqbigtitle, that.tqbigtitle) &&
                Objects.equals(qbid, that.qbid) &&
                Objects.equals(b1, that.b1) &&
                Objects.equals(b2, that.b2) &&
                Objects.equals(b3, that.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tqid, tpid, tqbigtitle, tqnum, qbid, tqscore, b1, b2, b3);
    }
}
