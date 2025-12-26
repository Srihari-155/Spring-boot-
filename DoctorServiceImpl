package com.appointment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.dto.DoctorDTO;
import com.appointment.entity.Doctor;
import com.appointment.exception.NotFoundException;
import com.appointment.repo.DoctorRepository;
import com.appointment.service.DoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    private DoctorDTO convertToDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    private Doctor convertToEntity(DoctorDTO doctorDTO) {
        return modelMapper.map(doctorDTO, Doctor.class);
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = convertToEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDTO(savedDoctor);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));

        doctor.setName(doctorDTO.getName());
        doctor.setHospitalName(doctorDTO.getHospitalName());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        doctor.setDailyTime(doctorDTO.getDailyTime());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return convertToDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));
        doctorRepository.deleteById(doctor.getId());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));
        return convertToDTO(doctor);
    }

    @Override
    public Page<DoctorDTO> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAllByOrderByNameAsc(pageable)
                .map(this::convertToDTO);
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpecialityOrderByNameAsc(speciality)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
