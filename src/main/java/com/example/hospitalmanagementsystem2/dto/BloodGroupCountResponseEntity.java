package com.example.hospitalmanagementsystem2.dto;

import com.example.hospitalmanagementsystem2.entity.type.BloodGroudType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {

    private BloodGroudType bloodGroudType;
    private Long count;
}
