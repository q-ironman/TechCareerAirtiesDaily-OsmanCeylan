package com.example.osmanceylan.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Entity
@Entity
@Table(name = "airties_daily")
public class Daily extends BaseEntity implements Serializable {

    //Random uid for serialization
    private static final long serialVersionUID = 1L;
    @NotNull
    private String name;
    @NotNull
    private String description;

}
