package com.appointment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Hospital name should not be blank")
    private String hospitalName;

    @NotBlank(message = "Speciality should not be blank")
    private String speciality;

    @NotNull(message = "Daily time should not be null")
    private String dailyTime;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String hospitalName, String speciality, String dailyTime) {
        this.id = id;
        this.name = name;
        this.hospitalName = hospitalName;
        this.speciality = speciality;
        this.dailyTime = dailyTime;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public String getDailyTime() { return dailyTime; }
    public void setDailyTime(String dailyTime) { this.dailyTime = dailyTime; }
}
