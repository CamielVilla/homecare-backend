package nl.novi.assigment.homecare.service;

import nl.novi.assigment.homecare.model.dto.*;
import nl.novi.assigment.homecare.model.entity.*;
import nl.novi.assigment.homecare.repository.AdminRepository;
import nl.novi.assigment.homecare.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminService {
 private final AdminRepository adminRepository;
 private final PatientService patientService;
 private final WoundService woundService;
 private final NurseService nurseService;
 private final PasswordEncoder passwordEncoder;
 private final UserRepository userRepository;

    public AdminService(AdminRepository adminRepository, PatientService patientService, WoundService woundService, NurseService nurseService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.patientService = patientService;
        this.woundService = woundService;
        this.nurseService = nurseService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public AdminDto createAdmin(CreateAdminDto createAdminDto) {
        Admin admin = new Admin();
        admin.setName(createAdminDto.getName());
        admin.setEmail(createAdminDto.getEmail());
        admin.setPassword(createAdminDto.getPassword());
        admin.setRole("ADMIN");
        admin.setEnabled(1);
        adminRepository.save(admin);
        return toAdminDto(admin);
    }

    private AdminDto toAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setName(admin.getName());
        adminDto.setEmail(admin.getEmail());
        adminDto.setPassword(admin.getPassword());
        adminDto.setEnabled(admin.getEnabled());
        adminDto.setRole(admin.getRole());
        return adminDto;
    }
    public PatientDto addPatient(CreatePatientDto createPatientDto) {
        Optional<User> optionalUser = userRepository.findUserByEmail(createPatientDto.getEmail());
        if (!optionalUser.isPresent()){
            Patient patient = new Patient();
            patient.setName(createPatientDto.getName());
            patient.setDateOfBirth(createPatientDto.getDateOfBirth());
            patient.setPassword(passwordEncoder.encode(createPatientDto.getPassword()));
            patient.setEmail(createPatientDto.getEmail());
            patient.setRole("PATIENT");
            patient.setEnabled(1);
            Patient savedPatient = patientService.savePatient(patient);
            return patientService.toPatientDto(savedPatient);
        }else{
            throw new RuntimeException();
        }
    }



    public PatientDto addWoundToPatient(Long patientId, CreateWoundDto createWoundDto){
        PatientDto patientDto = patientService.getPatientById(patientId);
        Set<Wound> wounds = patientDto.getWounds();
        Wound wound = new Wound();
        wound.setWoundName(createWoundDto.getWoundName());
        wound.setWoundLocation(createWoundDto.getWoundLocation());
        wound.setTreatmentPlan(createWoundDto.getTreatmentPlan());
        wound.setPatient(patientService.toPatient(patientDto));
        woundService.saveWound(wound);
        wounds.add(wound);
        patientService.savePatient(patientService.toPatient(patientDto));
        return patientDto;
    }

    public NurseDto addNurse (CreateNurseDto createNurseDto){
        Optional<User> optionalUser = userRepository.findUserByEmail(createNurseDto.getEmail());
        if (!optionalUser.isPresent()){
            Nurse nurse = new Nurse();
            nurse.setName(createNurseDto.getName());
            nurse.setBigNumber(createNurseDto.getBigNumber());
            nurse.setEmail(createNurseDto.getEmail());
            nurse.setPassword(passwordEncoder.encode(createNurseDto.getPassword()));
            nurse.setEnabled(1);
            nurse.setRole("NURSE");
            Nurse savedNurse = nurseService.saveNurse(nurse);
            return nurseService.toNurseDto(savedNurse);
        }else{
            throw new RuntimeException();
        }

    }

    public List<NurseDto> getAllNurses(){
        return nurseService.getAllNurses();
    }

    public List<PatientDto> getAllPatients(){
        return patientService.getAllPatients();
    }

    public List<AdminDto> getAllAdmins(){
        List<AdminDto> adminDtos = new ArrayList<>();
        List <Admin> admins = adminRepository.findAll();
        for(Admin a : admins){
            adminDtos.add(toAdminDto(a));
        }
        return adminDtos;
    }


}
