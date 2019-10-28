package com.sda.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    /*@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employeeList = new ArrayList<>();
*/
    /*@OneToOne(mappedBy = "department", fetch = FetchType.EAGER)
    private Manager manager;*/

    public Department() {
    }

    public Department(String name) {
        this.name = name;
        /*this.manager = manager;*/
    }

    /*public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }*/

    /*public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
                /*Objects.equals(employeeList, that.employeeList) &&*/
                /*Objects.equals(manager, that.manager)*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
