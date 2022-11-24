package com.example.osmanceylan.service.impl;

import com.example.osmanceylan.bean.ModelMapperBean;
import com.example.osmanceylan.dto.DailyDto;
import com.example.osmanceylan.entity.Daily;
import com.example.osmanceylan.exception.DailyNotFoundException;
import com.example.osmanceylan.exception.ExceptionMessages;
import com.example.osmanceylan.repository.IDailyRepository;
import com.example.osmanceylan.service.IDailyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//lombok
@RequiredArgsConstructor
@Log4j2

@Service
public class DailyService implements IDailyService {
    //injection
    private final IDailyRepository repository;
    private final ModelMapperBean modelMapperBean;
    // Model Mapping
    @Override
    public DailyDto entity2Dto(Daily entity) {
        return modelMapperBean.modelMapperMethod().map(entity, DailyDto.class);
    }

    @Override
    public Daily dto2Entity(DailyDto dto) {
        return modelMapperBean.modelMapperMethod().map(dto, Daily.class);
    }

    // Create
    @Override
    public DailyDto create(DailyDto dto) {
        Daily entity = dto2Entity(dto);
        repository.save(entity);
        return dto;
    }

    // List
    @Override
    public List<DailyDto> list() {
        List<Daily> entityList = repository.findAll();
        List<DailyDto> dtoList = new ArrayList<>();

        entityList.forEach(tmp -> dtoList.add(entity2Dto(tmp)));

        return dtoList;
    }

    //Find
    @Override
    public DailyDto find(Long id) {
        Daily entity = repository.findById(id).orElseThrow(() -> new DailyNotFoundException(ExceptionMessages.dailyNotFoundMessage));
        return entity2Dto(entity);
    }

    // Update
    @Override
    public DailyDto update(Long id, DailyDto dailyDto) {
        Daily entity = repository.findById(id).orElseThrow(() -> new DailyNotFoundException(ExceptionMessages.dailyNotFoundMessage));
        entity.setName(dailyDto.getName());
        entity.setDescription(dailyDto.getDescription());
        repository.save(entity);
        return dailyDto;
    }

    // Delete
    @Override
    public Map<String, Boolean> delete(Long id) {
        Daily entity = repository.findById(id).orElseThrow(() -> new DailyNotFoundException(ExceptionMessages.dailyNotFoundMessage));
        repository.delete(entity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return response;
    }
}
