package com.example.immigration_info_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImmigrationInformationDto {
    private Long id;
    private String destination;
    private Date returnDate;
    private Date startDate;
    private Long directionId;
    private Long purposeId;
}
