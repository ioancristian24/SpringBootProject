package com.sda.implementationDAO.implementation;

import com.sda.entities.Employee;
import com.sda.implementationDAO.EmployeeDAO;
import com.sda.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDAO {


    @Override
    public Employee addEmployee(Employee employee) {
        Employee employee1 = null;
        System.out.println("Am ajuns in clasa EmployeeDaoImpl.");
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee was creates with id: " + id);
            session.getTransaction().commit();
            if (id != null) {
                employee1 = session.get(Employee.class, id);
            } else {
                System.out.println("Employee was not created! ");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employee1;
    }

    @Override
    public Employee displayEmployeeById(Integer id) {
        return null;
    }

    public List<Employee> displayAllEmployees() {
        System.out.println("Am ajuns in clasa EmployeeDaoImpl");
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String HQL = "FROM Employee";
            Query query = session.createQuery(HQL);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee updateEmployeeById(Integer id, String position) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Integer id) {

    }

    public List<Employee> displayEmployeeByName(String name) {
        System.out.println("Am ajuns in clasa EmployeeDaoImpl");
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE name LIKE :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        System.out.println("Am ajuns in clasa EmployeeDaoImpl");
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE name LIKE :name AND position LIKE : position";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            query.setParameter("position", position);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean deleteEmployeeByName(String name) {
        boolean isDeleted = false;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            /*String HQL = "FROM Employee WHERE name=:name";
            Query query = session.createQuery(HQL);
            query.setParameter("name", name);
            List<Employee> employeeList = query.list();*/
            String countHQL = "SELECT COUNT (*) FROM Employee WHERE name =: name";//numara intrarile in BD
            Query countQuery = session.createQuery(countHQL);// cream interogarea
            countQuery.setParameter("name", name);
            Long countResult = (Long) countQuery.uniqueResult(); //returneaza numarul de intrari in BD
            System.out.println("Numar rezultate" + countResult);
            if (countResult != 1) { // daca avem doar o singura intrare in baza de date
                isDeleted = false;
            } else { // avem o singura intrare in baza de date
                String deleteHQL = "DELETE FROM Employee WHERE name =: name"; // sterge intrarea din baza de date cu numele trimis ca parametru
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("name", name);
                int result = deleteQuery.executeUpdate(); // se executa query-ul // in result retinem numarul de linii sterse
                if (result != 0) {//s-a sters intrarea in baza de date
                    isDeleted = true;
                } else { // nu s-a sters nici o intrare in baza de date
                    isDeleted = false;
                }
            }
            /*if (employeeList.size() > 1 || employeeList.size() == 0){
                isDeleted = false;
            }else {
                session.delete(employeeList.get(0));
                isDeleted = true;
            }*/
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String countHQL = "SELECT COUNT (*) FROM Employee WHERE name =: name AND position =: position";
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("name", name);
            countQuery.setParameter("position", position);
            Long countResult = (Long) countQuery.uniqueResult();
            if (countResult != 1) {
                isDeleted = false;
            } else {
                String deleteHQL = "DELETE FROM Employee WHERE name =: name AND position =:position";
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("name", name);
                deleteQuery.setParameter("position", position);
                int deleteResult = deleteQuery.executeUpdate();
                if (deleteResult != 0) {
                    isDeleted = true;
                } else {
                    isDeleted = false;
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }


    public Employee updateEmployee(String name, Employee employee) {
        Employee employeeUpdated = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String countHQL = "SELECT COUNT(*) FROM Employee WHERE name =: name";
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("name", name);
            Long countResult = (Long) countQuery.uniqueResult();
            if (countResult != 1) {
                return null;
            } else {
                String updateHQL = "UPDATE Employee SET position =: position, age =: age WHERE name =: name";
                Query updateQuery = session.createQuery(updateHQL);
                updateQuery.setParameter("position", employee.getPosition());
                updateQuery.setParameter("age", employee.getAge());
                updateQuery.setParameter("name", name);
                int updateResult = updateQuery.executeUpdate();
                if (updateResult == 0) {
                    return null;
                } else {
                    employeeUpdated = new Employee();
                    String HQL = "FROM Employee WHERE name =:name";
                    Query selectQuery = session.createQuery(HQL);
                    selectQuery.setParameter("name", name);
                    List<Employee> employeeList = selectQuery.list();
                    employeeUpdated = employeeList.get(0);
                }
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return employeeUpdated;
    }
}