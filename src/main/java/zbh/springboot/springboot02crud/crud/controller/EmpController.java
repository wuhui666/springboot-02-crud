package zbh.springboot.springboot02crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zbh.springboot.springboot02crud.crud.dao.DepartmentDao;
import zbh.springboot.springboot02crud.crud.dao.EmployeeDao;
import zbh.springboot.springboot02crud.crud.entities.Department;
import zbh.springboot.springboot02crud.crud.entities.Employee;

import java.util.Collection;

/**
 * @author: wuhui
 * @time: 2019/6/22 15:15
 * @desc:
 */
@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String getAll(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String add(Employee e){
        employeeDao.save(e);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toAdd(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/edit";
    }
    @PutMapping("/emp")
    public String edit(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
