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

import jakarta.persistence.*;

@Entity
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;   // ✅ THIS WAS MISSING

    // getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public Zone getZone() { return zone; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setZone(Zone zone) { this.zone = zone; }
}
