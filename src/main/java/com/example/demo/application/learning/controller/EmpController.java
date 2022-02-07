package com.example.demo.application.learning.controller;

import com.example.demo.application.learning.entity.EmpData;
import com.example.demo.application.learning.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/addEmp")
    public EmpData saveEmp(@RequestBody EmpData emp){
        return  empService.createEmp(emp);
    }

    @GetMapping("/getAllEmp")
    public List<EmpData> getAllEmpData(){
        return empService.getAllEmpDetails();
    }

    @GetMapping("/getEmpById/{id}")
    public EmpData getEmpByID(@PathVariable int id){
        return empService.getEmpById(id);
    }

    @PutMapping("/updateEmp")
    public EmpData updateEmpDetails(@RequestBody EmpData newEmp){
        return empService.updateEmpDetails(newEmp);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
        return "Employee Data Has been deleted Successfully";
    }
}
