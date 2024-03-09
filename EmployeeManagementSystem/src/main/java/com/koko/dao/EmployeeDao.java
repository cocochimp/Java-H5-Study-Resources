package com.koko.dao;

import com.koko.pojo.Department;
import com.koko.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
//员工Dao
public class EmployeeDao {
    //模拟数据中的信息
    private static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        //创建一个员工表
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "2921625927@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "4534545434@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "7767546755@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "7654788797@qq.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "4343546768@qq.com", 1, new Department(105, "后勤部")));
    }

    //主键自增加
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询全部的员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //通过ID删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}
