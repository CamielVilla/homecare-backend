package nl.novi.assigment.homecare.domain.dto;

import nl.novi.assigment.homecare.domain.entity.Wound;

import java.util.List;

public class PatientDto {

    private Long id;
    private String name;
    private String dateOfBirth;
    private String email;
    private String password;
    private List<Wound> wounds;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Wound> getWounds() {
        return wounds;
    }

    public void setWounds(List<Wound> wounds) {
        this.wounds = wounds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
