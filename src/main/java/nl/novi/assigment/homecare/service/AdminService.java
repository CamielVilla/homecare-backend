package nl.novi.assigment.homecare.service;

import nl.novi.assigment.homecare.domain.dto.AdminDto;
import nl.novi.assigment.homecare.domain.dto.CreateAdminDto;
import nl.novi.assigment.homecare.domain.entity.Admin;
import nl.novi.assigment.homecare.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminDto createAdmin(CreateAdminDto createAdminDto) {
        Admin admin = new Admin();
        admin.setName(createAdminDto.getName());
        admin.setEmail(createAdminDto.getEmail());
        admin.setPassword(createAdminDto.getPassword());
        adminRepository.save(admin);
        return toAdminDto(admin);
    }

    private AdminDto toAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setName(admin.getName());
        adminDto.setEmail(admin.getEmail());
        adminDto.setPassword(admin.getPassword());
        return adminDto;
    }

}