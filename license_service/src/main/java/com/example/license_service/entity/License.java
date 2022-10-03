package com.example.license_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class License {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @NotEmpty
    @Column(name = "license_number")
    private String licenseNumber;

    @Basic
    @Column(name = "issued_on")
    private Date issuedOn;

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @ManyToOne
    private TypeOfLicense typeOfLicense;
}