package com.koko.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//部门表
public class Department {
    private Integer id;
    private String departmentName;

}
