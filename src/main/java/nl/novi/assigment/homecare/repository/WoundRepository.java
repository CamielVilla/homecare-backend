package nl.novi.assigment.homecare.repository;

import nl.novi.assigment.homecare.domain.entity.Wound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WoundRepository extends JpaRepository <Wound, Long>{
}
