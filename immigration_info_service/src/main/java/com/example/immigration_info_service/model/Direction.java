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
@Table(name = "direction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    @NotBlank(message = "name is mandatory")
    @Size(max = 100, message = "name should not be longer than 100 characters")
    private String name;

    @OneToMany(mappedBy = "directionById")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationById;
}
