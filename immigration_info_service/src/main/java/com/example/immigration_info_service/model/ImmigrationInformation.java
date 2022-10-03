package com.example.immigration_info_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "immigration_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "destination")
    private String destination;

    @Basic
    @Column(name = "return_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date returnDate;

    @Basic
    @Column(name = "start_date")
//    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;

//    @Basic
//    @Column(name = "start_update_date")
//    @UpdateTimestamp
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private Date startUpdateDate;

    // nối với class dto
    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    // nối với class dto
    @Basic
    @Column(name = "direction_id", insertable = false, updatable = false)
    private Long directionId;
    @ManyToOne
    @JoinColumn(name = "direction_id", referencedColumnName = "id", nullable = false)
    private Direction directionById;

    // nối với class dto
    @Basic
    @Column(name = "purpose_id", insertable = false, updatable = false)
    private Long purposeId;
    @ManyToOne
    @JoinColumn(name = "purpose_id", referencedColumnName = "id", nullable = false)
    private Purpose purposeById;

    // nối với class dto
    @Basic
    @Column(name = "identityCard_id", insertable = false, updatable = false)
    private Long identityCardId;

    // nối với class dto
    @Basic
    @Column(name = "license_id", insertable = false, updatable = false)
    private Long licenseId;
}