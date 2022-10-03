package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.Direction;

import java.util.List;
import java.util.Optional;

public interface DirectionService {
    List<Direction> findAll();

    void save(Direction Direction);

    Optional<Direction> findById(Long id);

    void deleteById(Long id);

}
