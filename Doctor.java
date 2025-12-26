package com.appointment.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "speciality", nullable = false)
    private String speciality;

    @Column(name = "daily_time", nullable = false)
    private String dailyTime;

    public Doctor() {
    }

    public Doctor(String name, String hospitalName, String speciality, String dailyTime) {
        this.name = name;
        this.hospitalName = hospitalName;
        this.speciality = speciality;
        this.dailyTime = dailyTime;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public String getDailyTime() { return dailyTime; }
    public void setDailyTime(String dailyTime) { this.dailyTime = dailyTime; }
}
