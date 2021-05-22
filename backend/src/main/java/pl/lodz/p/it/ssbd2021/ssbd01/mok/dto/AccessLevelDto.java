package pl.lodz.p.it.ssbd2021.ssbd01.mok.dto;

import pl.lodz.p.it.ssbd2021.ssbd01.common.I18n;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccessLevelDto {
    @NotNull
    @Size(min = 7, max = 32)
    @Pattern(regexp = I18n.PATIENT + "|" + I18n.ADMIN + "|" + I18n.RECEPTIONIST + "|" + I18n.DOCTOR)
    private String level;
    @NotNull
    @Size(min = 1, max = 60)
    private String login;

    /**
     * Tworzy nową instancję klasy AccessLevelDto.
     */
    public AccessLevelDto() {
    }

    /**
     * Tworzy nową instancję klasy AccessLevelDto.
     *
     * @param level poziom dostępu
     * @param login login
     */
    public AccessLevelDto(String level, String login) {
        this.level = level;
        this.login = login;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}