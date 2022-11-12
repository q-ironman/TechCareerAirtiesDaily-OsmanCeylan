package com.example.osmanceylan.web.api;

import com.example.osmanceylan.dto.DailyDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IDailyApi {
    // Create
    ResponseEntity<DailyDto> create(DailyDto dto);
    // List
    ResponseEntity<List<DailyDto>> list();
    // Find
    ResponseEntity<DailyDto> find(Long id) ;
    // Update
    ResponseEntity<DailyDto> update(Long id, DailyDto dailyDto) ;
    // Delete
    ResponseEntity<Map<String,Boolean>> delete(Long id) ;
}
