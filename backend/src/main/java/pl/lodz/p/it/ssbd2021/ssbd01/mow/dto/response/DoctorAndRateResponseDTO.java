package pl.lodz.p.it.ssbd2021.ssbd01.mow.dto.response;

/**
 * Typ DoctorAndRateResponseDTO - klasa DTO reprezentująca informację o lekarzu i jego ocenie.
 */
public class DoctorAndRateResponseDTO {
    
    private String login;
    private String firstName;
    private String lastName;
    private double avgRate;

    /**
     * Tworzy nową instancję klasy DoctorAndRateResponseDTO.
     *
     * @param login     login lekarza
     * @param firstName imię lekarza
     * @param lastName  nazwisko lekarza
     * @param avgRate   średnia ocena
     */
    public DoctorAndRateResponseDTO(String login, String firstName, String lastName, double avgRate) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgRate = avgRate;
    }

    /**
     * Pobiera pole firstName.
     *
     * @return imię
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Pobiera pole lastName.
     *
     * @return nazwisko
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Pobiera pole avgRate.
     *
     * @return średnia ocen
     */
    public double getAvgRate() {
        return avgRate;
    }

    /**
     * Pobiera pole login.
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }
}