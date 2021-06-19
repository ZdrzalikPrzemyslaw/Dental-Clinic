package pl.lodz.p.it.ssbd2021.ssbd01.mow.dto;

import pl.lodz.p.it.ssbd2021.ssbd01.common.I18n;
import pl.lodz.p.it.ssbd2021.ssbd01.security.SignableEntity;
import pl.lodz.p.it.ssbd2021.ssbd01.validation.Login;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AppointmentEditRequestDto implements SignableEntity {

    @NotNull(message = I18n.APPOINTMENT_ID_NULL)
    private Long id;

    @Login
    @NotNull(message = I18n.PATIENT_ID_NULL)
    private String patientLogin;

    @Future
    private LocalDateTime appointmentDate;

    @NotNull(message = I18n.VERSION_NULL)
    private Long version;

    public String getPatientLogin() {
        return patientLogin;
    }

    public void setPatientLogin(String patientLogin) {
        this.patientLogin = patientLogin;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Map<String, String> getPayload() {
        Map<String, String> map = new HashMap<>();
        map.put("version", String.valueOf(version));
        return map;
    }
}
