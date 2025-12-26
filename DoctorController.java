@GetMapping
public ResponseEntity<Page<DoctorDTO>> getAllDoctors(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    Pageable pageable = PageRequest.of(page, size);
    return new ResponseEntity<>(doctorService.getAllDoctors(pageable), HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
    return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
}

@PostMapping
public ResponseEntity<DoctorDTO> createDoctor(@Validated @RequestBody DoctorDTO doctorDTO) {
    return new ResponseEntity<>(doctorService.createDoctor(doctorDTO), HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<DoctorDTO> updateDoctor(
        @PathVariable Long id,
        @Validated @RequestBody DoctorDTO doctorDTO) {

    return new ResponseEntity<>(doctorService.updateDoctor(id, doctorDTO), HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
    doctorService.deleteDoctor(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/speciality/{speciality}")
public ResponseEntity<List<DoctorDTO>> getDoctorsBySpeciality(
        @PathVariable String speciality) {

    return new ResponseEntity<>(doctorService.getDoctorsBySpeciality(speciality), HttpStatus.OK);
}
