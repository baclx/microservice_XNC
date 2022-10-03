package com.example.identity_card_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ban {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "effect_from")
    private Date effectFrom;
    @Basic
    @Column(name = "expire_date")
    private Date expireDate;
    @ManyToOne
    @JoinColumn(name = "identirycard_id", referencedColumnName = "id")
    private Identitycard identitycardById;
}
