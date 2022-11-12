package com.example.osmanceylan.web.api.impl;

import com.example.osmanceylan.dto.DailyDto;
import com.example.osmanceylan.service.IDailyService;
import com.example.osmanceylan.web.api.IDailyApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Lombok
@RequiredArgsConstructor
@Log4j2

// Api
@RestController
@RequestMapping("api/daily/v1")
@CrossOrigin
public class DailyApi implements IDailyApi {
    // Injection
    private final IDailyService service;
    //Create
    //http://localhost:7070/api/daily/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<DailyDto> create(@Valid @RequestBody DailyDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    //List
    //http://localhost:7070/api/daily/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<DailyDto>> list() {return ResponseEntity.ok(service.list()); }

    //Find
    //http://localhost:7070/api/daily/v1/find/1
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<DailyDto> find(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    //Update
    //http://localhost:7070/api/daily/v1/update/1
    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<DailyDto> update(@PathVariable(name = "id") Long id, @Valid @RequestBody DailyDto dailyDto) {
        service.update(id,dailyDto);
        return ResponseEntity.ok(dailyDto);
    }

    //Delete
    //http://localhost:7070/api/daily/v1/delete/1
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
