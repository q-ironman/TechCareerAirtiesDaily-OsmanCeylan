package com.example.osmanceylan.repository;

import com.example.osmanceylan.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDailyRepository extends JpaRepository<Daily,Long> {
}
