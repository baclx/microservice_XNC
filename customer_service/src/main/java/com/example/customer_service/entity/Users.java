package com.example.customer_service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "fullname")
    private String fullname;

    @Basic
    @Column(name = "gender")
    private Integer gender;

    @Basic
    @Column(name = "nationality")
    private String nationality;

    @Basic
    @Column(name = "dateofbirth")
    private Date dateOfBirth;

//    @OneToMany(mappedBy = "customerByCustomerId")
//    @JsonIgnore
//    private Collection<ImmigrationInformation> immigrationInformationsById;

//    @OneToMany(mappedBy = "customerByCustomerId")
//    @JsonIgnore
//    private Collection<Identitycard> identitycardsById;

//    @OneToMany(mappedBy = "customerByCustomerId")
//    @JsonIgnore
//    private Collection<License> licensesById;

}