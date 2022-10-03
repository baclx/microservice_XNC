package com.example.immigration_info_service.mapper;

import com.example.immigration_info_service.dto.ImmigrationInformationDto;
import com.example.immigration_info_service.model.ImmigrationInformation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ImmigrationInformationMapper {
    ImmigrationInformation dtoToModel(ImmigrationInformationDto immigrationInformationDto);
    ImmigrationInformationDto modelToDto(ImmigrationInformation immigrationInformation);
}
