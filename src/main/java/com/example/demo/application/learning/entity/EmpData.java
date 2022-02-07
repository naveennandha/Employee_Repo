package com.example.demo.application.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="EMP_DATA")
public class EmpData {
    @Id
    @GeneratedValue
    private  Integer id;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "EMP_ADDRESS")
    private String empAddress;
}
