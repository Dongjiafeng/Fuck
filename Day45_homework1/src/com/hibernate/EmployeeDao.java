package com.hibernate;

import com.bean.Employee;
import org.hibernate.Query;

import java.util.List;

public class EmployeeDao {
    public List<Employee> query(){
        List<Employee> handle = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from Employee");
            List<Employee> list = query.list();
            return list;
        });

        return handle;
    }

    public void add(Employee employee){
        HibernateUtil.handle(session -> {
           session.save(employee);
            return null;
        });

    }
    public void amend(Employee employee){
        HibernateUtil.handle(session -> {
            Employee employee1 = session.get(Employee.class, employee.getId());
            employee1.setAge(employee.getAge());
            employee1.setName(employee.getName());
            employee1.setEntrytime(employee.getEntrytime());
            employee1.setAdress(employee.getAdress());
            employee1.setPhone(employee.getPhone());
            employee1.setSection(employee.getSection());
            session.update(employee1);
            return null;
        });
    }
    public Employee findByid(String id){
        Employee handle = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from  Employee where id = ?");
            int i = Integer.valueOf(id);
            query.setParameter(0, i);
            List<Employee> list = query.list();
            Employee employee = null;
            if (list.size() != 0) {
                employee = list.get(0);
            }
            return employee;
        });
        return handle;
    }



    public Employee find(int id){
        Employee handle = HibernateUtil.handle(session -> {
            Employee employee = session.get(Employee.class, id);
            return employee;
        });
        return handle;
    }
}
