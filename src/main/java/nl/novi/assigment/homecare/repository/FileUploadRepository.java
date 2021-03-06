package nl.novi.assigment.homecare.repository;

import nl.novi.assigment.homecare.model.entity.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileUploadRepository extends JpaRepository<FileUploadResponse, String> {
    Optional<FileUploadResponse> findByFileName(String fileName);
}