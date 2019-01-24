package com.four.exam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private int sid;
    private String sname;
    private String snumber;
    private String spassword;
    private String sdep;
    private String ssex;
    private String screatdate;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
    @Column(name = "snumber")
    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    @Basic
    @Column(name = "spassword")
    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Basic
    @Column(name = "sdep")
    public String getSdep() {
        return sdep;
    }

    public void setSdep(String sdep) {
        this.sdep = sdep;
    }

    @Basic
    @Column(name = "ssex")
    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    @Basic
    @Column(name = "screatdate")
    public String getScreatdate() {
        return screatdate;
    }

    public void setScreatdate(String screatdate) {
        this.screatdate = screatdate;
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
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", snumber='" + snumber + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sdep='" + sdep + '\'' +
                ", ssex='" + ssex + '\'' +
                ", screatdate='" + screatdate + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        return sid == student.sid &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(snumber, student.snumber) &&
                Objects.equals(spassword, student.spassword) &&
                Objects.equals(sdep, student.sdep) &&
                Objects.equals(ssex, student.ssex) &&
                Objects.equals(screatdate, student.screatdate) &&
                Objects.equals(b1, student.b1) &&
                Objects.equals(b2, student.b2) &&
                Objects.equals(b3, student.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, snumber, spassword, sdep, ssex, screatdate, b1, b2, b3);
    }

}
