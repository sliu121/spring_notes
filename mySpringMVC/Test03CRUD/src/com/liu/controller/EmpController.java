package com.liu.controller;

import com.liu.dao.DepartmentDao;
import com.liu.dao.EmployeeDao;
import com.liu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.server.RMIClassLoader;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     *  Show all employees info
     * @param map -> use map to get the info
     * @return
     */
    @RequestMapping(value = "/emps")
    public String getAllEmps(Map<String, Object> map){
        map.put("empList",employeeDao.getAll());

        return "list";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toAdd(Map<String,Object> map ){
        map.put("departments", departmentDao.getDepartments());
        return "add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("emp",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "edit";
    }
//      works good !
//    with  <form action="${pageContext.request.contextPath}/emp" method="post">
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String editEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**
     * I have no idea why we use /emp rather than /edit.
     * if we change the edit.jsp filr form to
     *
     *     ...
     *     <form action="edit" method="post">
     *      ...
     *
     *     and use this code:
     *     @RequestMapping(value = "/edit",method = RequestMethod.PUT)
     *          public String editEmployee(Employee employee){
     *          employeeDao.save(employee);
     *          return "redirect:/emps";
     *      }
     *
     *      after our edit operation and submit,
     *      there is an error 405
     *      and server error is:
     *      org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'PUT' not supported
     *      still have no idea.


     */
}
