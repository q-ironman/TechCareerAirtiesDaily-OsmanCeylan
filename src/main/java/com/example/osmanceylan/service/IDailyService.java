package com.example.osmanceylan.service;

import com.example.osmanceylan.dto.DailyDto;
import com.example.osmanceylan.entity.Daily;

import java.util.List;
import java.util.Map;

public interface IDailyService {
        // Mapping entity to dto
        DailyDto entity2Dto(Daily entity);
        // Mapping dto to entity
        Daily dto2Entity(DailyDto dto);
        // Create
        DailyDto create(DailyDto dto);
        // List
        List<DailyDto> list();
        // Find
        DailyDto find(Long id) ;
        // Update
        DailyDto update(Long id, DailyDto dailyDto) ;
        // Delete
        Map<String,Boolean> delete(Long id) ;
}
