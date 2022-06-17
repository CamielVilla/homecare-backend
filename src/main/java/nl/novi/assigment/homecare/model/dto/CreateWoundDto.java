package nl.novi.assigment.homecare.model.dto;

import nl.novi.assigment.homecare.model.entity.Patient;
import nl.novi.assigment.homecare.model.entity.WoundExamination;

import java.util.List;


public class CreateWoundDto {

    private String treatmentPlan;
    private String woundName;
    private String woundLocation;
    private Patient patient;
//    private Long patientId
    private List<WoundExamination> woundExaminations;

    public List<WoundExamination> getWoundPhotos() {
        return woundExaminations;
    }

    public void setWoundPhotos(List<WoundExamination> woundExaminations) {
        this.woundExaminations = woundExaminations;
    }

//    public Long getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Long patientId) {
//        this.patientId = patientId;
//    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getWoundName() {
        return woundName;
    }

    public void setWoundName(String woundName) {
        this.woundName = woundName;
    }

    public String getWoundLocation() {
        return woundLocation;
    }

    public void setWoundLocation(String woundLocation) {
        this.woundLocation = woundLocation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
