// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class Bin {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private int capacity;
//     private boolean active = true;

//     public Bin() {}

//     public Long getId() { return id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public int getCapacity() { return capacity; }
//     public void setCapacity(int capacity) { this.capacity = capacity; }
//     public boolean isActive() { return active; }
//     public void setActive(boolean active) { this.active = active; }
// }
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    public Bin() {}

    public Bin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
