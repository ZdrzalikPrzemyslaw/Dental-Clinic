package pl.lodz.p.it.ssbd2021.ssbd01.mod.dto.response;

import java.time.LocalDateTime;

public class PrescriptionResponseDto {

    private final Long prescriptionId;
    private final LocalDateTime expiration;
    private final String patientFirstname;
    private final String patientLastname;
    private final String doctorFirstname;
    private final String doctorLastname;
    private final LocalDateTime creationDateTime;
    private final String medications;

    public PrescriptionResponseDto(Long prescriptionId, LocalDateTime expiration, String patientFirstname, String patientLastname, String doctorFirstname, String doctorLastname, LocalDateTime creationDateTime, String medications) {
        this.prescriptionId = prescriptionId;
        this.expiration = expiration;
        this.patientFirstname = patientFirstname;
        this.patientLastname = patientLastname;
        this.doctorFirstname = doctorFirstname;
        this.doctorLastname = doctorLastname;
        this.creationDateTime = creationDateTime;
        this.medications = medications;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public String getDoctorFirstname() {
        return doctorFirstname;
    }

    public String getDoctorLastname() {
        return doctorLastname;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public String getMedications() {
        return medications;
    }
}
