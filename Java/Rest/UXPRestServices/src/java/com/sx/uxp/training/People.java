/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Koshman
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id")
    , @NamedQuery(name = "People.findByInn", query = "SELECT p FROM People p WHERE p.inn = :inn")
    , @NamedQuery(name = "People.findByFirstname", query = "SELECT p FROM People p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "People.findBySurname", query = "SELECT p FROM People p WHERE p.surname = :surname")
    , @NamedQuery(name = "People.findByPatronymic", query = "SELECT p FROM People p WHERE p.patronymic = :patronymic")
    , @NamedQuery(name = "People.findByBirthdate", query = "SELECT p FROM People p WHERE p.birthdate = :birthdate")
    , @NamedQuery(name = "People.findByPassportSer", query = "SELECT p FROM People p WHERE p.passportSer = :passportSer")
    , @NamedQuery(name = "People.findByPassportNum", query = "SELECT p FROM People p WHERE p.passportNum = :passportNum")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "inn")
    private String inn;
    @Size(max = 64)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 64)
    @Column(name = "surname")
    private String surname;
    @Size(max = 64)
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 5)
    @Column(name = "passport_ser")
    private String passportSer;
    @Size(max = 10)
    @Column(name = "passport_num")
    private String passportNum;

    public People() {
    }

    public People(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassportSer() {
        return passportSer;
    }

    public void setPassportSer(String passportSer) {
        this.passportSer = passportSer;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sx.uxp.training.People[ id=" + id + " ]";
    }
    
}
