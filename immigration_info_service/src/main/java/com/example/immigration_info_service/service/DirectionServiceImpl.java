package com.example.immigration_info_service.service;

import com.example.immigration_info_service.model.Direction;
import com.example.immigration_info_service.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    DirectionRepository directionRepository;
    @Override
    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Override
    public void save(Direction direction) {
        directionRepository.save(direction);
    }

    @Override
    public Optional<Direction> findById(Long id) {
        return directionRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        directionRepository.deleteById(id);
    }
}
