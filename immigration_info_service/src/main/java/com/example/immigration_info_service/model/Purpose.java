package com.example.immigration_info_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "purpose")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    @NotBlank(message = "name is mandatory")
    @Size(max = 50, message = "name should not be longer than 50 characters")
    private String name;

    @Basic
    @Column(name = "description")
    @NotBlank(message = "description is mandatory")
    @Size(max = 200, message = "description should not be longer than 200 characters")
    private String description;

    @OneToMany(mappedBy = "purposeById")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationById;
}
