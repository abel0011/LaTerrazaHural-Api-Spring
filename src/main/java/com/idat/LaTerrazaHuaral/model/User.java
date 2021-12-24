package com.idat.LaTerrazaHuaral.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 100, name = "_password")
    private String password;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 1)
    private String active;

    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    @OneToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false)
    private Role role;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_person", nullable = false, unique = true,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_person) references person(id_person)"))
    @JsonBackReference
    private Person person;


}
