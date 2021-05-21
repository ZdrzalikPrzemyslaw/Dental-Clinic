package pl.lodz.p.it.ssbd2021.ssbd01.mok.ejb.managers;

import pl.lodz.p.it.ssbd2021.ssbd01.entities.AccessLevel;
import pl.lodz.p.it.ssbd2021.ssbd01.exceptions.AppBaseException;

import javax.ejb.Local;
import java.util.Set;

/**
 * Interfejs Access level manager.
 */
@Local
public interface AccessLevelManager {

    /**
     * Revoke access level - odebranie poziomu dostępu {@param level} kontowi o zadanym {@param id}.
     *
     * @param id    id uzytkownika, któremu zostanie odebrany poziom dostępu
     * @param level level odbierany poziom odstępu
     * @throws AppBaseException wyjątek typu AppBaseException
     */
    void revokeAccessLevel(Long id, String level) throws AppBaseException;

    /**
     * Revoke access level - odebranie poziomu dostępu {@param level} kontowi o zadanym {@param login}.
     *
     * @param login login uzytkownika, któremu zostanie odebrany poziom dostępu
     * @param level level odbierany poziom odstępu
     * @throws AppBaseException wyjątek typu AppBaseException
     */
    void revokeAccessLevel(String login, String level) throws AppBaseException;


    /**
     * Dodaje poziom dostępu {@param level} kontowi o loginie równym {@param login}.
     *
     * @param level nazwa poziomu dostępu konta
     * @param login login użytkownika, któremu zostanie dodany poziom dostępu
     * @throws AppBaseException wyjątek typu AppBaseException
     */
    void addAccessLevel(String login, String level) throws AppBaseException;
}
