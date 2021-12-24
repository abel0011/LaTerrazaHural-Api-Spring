package com.idat.LaTerrazaHuaral.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthName")
    private String birthName;

    @Column(name = "phone", length = 9, unique = true)
    private String phone;

    @Column(name = "dni", length = 8, unique = true)
    private String dni;

    @Column(name = "active")
    private String active;

    @Column(name = "id_role")
    private Integer role;

    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date  dateOfBirth;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

     @OneToOne(mappedBy = "person",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY) //mapea la taba donde no existe FK
    private User user;
    
}
