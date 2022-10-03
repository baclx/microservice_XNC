package com.example.immigration_info_service.repository;

import com.example.immigration_info_service.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction,Long> {
}
