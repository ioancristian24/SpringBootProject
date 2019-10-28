package com.sda.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

   /* @ManyToOne
    @JoinColumns({@JoinColumn(name = "department_to_which_they_belong", referencedColumnName = "name")})
    private Department department;*/

    public Employee(String name, String position, Integer age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public Employee() {
    }

   /* public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
