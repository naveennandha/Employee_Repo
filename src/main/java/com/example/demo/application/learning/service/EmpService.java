package com.example.demo.application.learning.service;

import com.example.demo.application.learning.dao.EmpRepository;
import com.example.demo.application.learning.entity.EmpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public EmpData createEmp(EmpData Emp){
        return empRepository.save(Emp);
    }

    public List<EmpData> getAllEmpDetails(){
        return empRepository.findAll();
    }

    public EmpData getEmpById(int id){
        return  empRepository.findById(id).orElse(new EmpData());
    }

    public EmpData updateEmpDetails(EmpData newEmpData){
        EmpData oldEmpData = null;
        Optional<EmpData> optionalEmpDetails = empRepository.findById(newEmpData.getId());
        if(optionalEmpDetails.isPresent()){
            oldEmpData = optionalEmpDetails.get();
            oldEmpData.setEmpName(newEmpData.getEmpName());
            oldEmpData.setEmpAddress(newEmpData.getEmpAddress());
            empRepository.save(oldEmpData);
        }
        else {
            return(new EmpData()); // have to handle error for this scenario //
        }
        return oldEmpData;
    }

    public String deleteEmp(int id){
        empRepository.deleteById(id);
        return "Employee Details are deleted successfully";
    }
}
