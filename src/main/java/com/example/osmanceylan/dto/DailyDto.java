package com.example.osmanceylan.dto;

import com.example.osmanceylan.entity.Daily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DailyDto implements Serializable {
    // Random Uid for serialization
    private final static long serialVersionUID = 1L;

    private long id;
    @NotEmpty(message = "{daily.name.validation.constraints.NotNull.message}")
    private String name;
    @NotEmpty(message = "{daily.description.validation.constraints.NotNull.message}")
    private String description;
    private Date systemCreatedDate;
}
