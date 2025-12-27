// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class Zone {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String zoneName;

//     private String description;

//     private Boolean active = true;

//     // Required by JPA
//     public Zone() {
//     }

//     public Zone(Long id, String zoneName, String description, Boolean active) {
//         this.id = id;
//         this.zoneName = zoneName;
//         this.description = description;
//         this.active = active;
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public String getZoneName() {
//         return zoneName;
//     }

//     public void setZoneName(String zoneName) {
//         this.zoneName = zoneName;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;   

    private boolean active;    // ✅ added

    // getters
    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public boolean isActive() {
        return active;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
