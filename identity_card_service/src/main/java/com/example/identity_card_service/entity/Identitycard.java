package com.example.identity_card_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Identitycard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name="user_id")
    private Long userId;

    @Basic
    @Column(name = "number_of_identitycard")
    private String numberOfIdentitycard;

    @Basic
    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @Basic
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    @OneToMany(mappedBy = "identitycardById")
    @JsonIgnore
    private Collection<Ban> bansById;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeOfIdentitycard typeofIdentitycardById;
}
