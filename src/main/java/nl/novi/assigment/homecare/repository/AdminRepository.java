package nl.novi.assigment.homecare.repository;

import nl.novi.assigment.homecare.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
