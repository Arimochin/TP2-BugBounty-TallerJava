package edu.unicen.tallerjava.todo.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class User {
    @Id
    private Integer id;

    private String name;

    public User() {
        this("DEFAULT");
    }

    public User(String name) {
        this(name, 0);
    }

    public User(String name, Integer id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User user){
            return this.name.equals(user.getName());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
