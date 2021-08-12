package com.syl.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Department {
    private String name;
    private String[] empName;
    private List<Employees> employeesList;
    private Set<Employees> empSet;

    public Map<String, Employees> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<String, Employees> empMap) {
        this.empMap = empMap;
    }

    private Map<String,Employees> empMap;


    public Set<Employees> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Employees> empSet) {
        this.empSet = empSet;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEmpName() {
        return empName;
    }

    public void setEmpName(String[] empName) {
        this.empName = empName;
    }
}
