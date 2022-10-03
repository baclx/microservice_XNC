package com.example.immigration_info_service.repository;

import com.example.immigration_info_service.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose,Long> {
}
