package com.example.identity_card_service.common.dto;

import com.example.identity_card_service.entity.TypeOfIdentitycard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentitycardDto {
    private long id;
    private Long userId;
    private String numberOfIdentitycard;
    private String placeOfIssue;
    private Date dateOfExpiry;
    private TypeOfIdentitycard typeofIdentitycardById;
}
