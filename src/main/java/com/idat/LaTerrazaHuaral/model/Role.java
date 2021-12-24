package com.idat.LaTerrazaHuaral.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRole;

    @Column(length = 100)
    private String description;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    // @OneToOne(cascade = {CascadeType.ALL})
    // @JoinColumn(name = "id_users", nullable = false, unique = true,
    // foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_users) references user(id_users)"))
    // @JsonBackReference
    // private User user;
    // @OneToMany(mappedBy = "role")
    // private Collection<User> user  = new ArrayList<User>();
    // @ManyToMany(mappedBy = "role", cascade = {CascadeType.ALL})
    // private List<Permission> permissions;

   	// @ManyToOne
	// @JoinColumn(name = "id_user",nullable = false,
    // foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_user) references user(id_user)"))
	// @JsonBackReference // cortar recursividad infinita!!
    // private User user; 




}
