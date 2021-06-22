package pl.lodz.p.it.ssbd2021.ssbd01.mod.ejb.managers;

import pl.lodz.p.it.ssbd2021.ssbd01.exceptions.AppBaseException;
import pl.lodz.p.it.ssbd2021.ssbd01.exceptions.EncryptionException;
import pl.lodz.p.it.ssbd2021.ssbd01.exceptions.mod.PrescriptionException;
import pl.lodz.p.it.ssbd2021.ssbd01.mod.dto.request.CreatePrescriptionRequestDTO;
import pl.lodz.p.it.ssbd2021.ssbd01.mod.dto.request.EditPrescriptionRequestDto;
import pl.lodz.p.it.ssbd2021.ssbd01.mod.dto.response.PrescriptionResponseDto;

import javax.ejb.Local;
import java.util.List;

/**
 * Interfejs Prescriptions manager.
 */
@Local
public interface PrescriptionsManager {
    /**
     * Utworzenie recepty.
     *
     * @param createPrescriptionRequestDTO odpowiednie DTO.
     * @throws AppBaseException w przypadku wystąpienia błędów.
     */
    void createPrescription(CreatePrescriptionRequestDTO createPrescriptionRequestDTO) throws AppBaseException;

    /**
     * Sprawdza czy ostatnia transakcja się powiodła.
     *
     * @return true jeśli ostatnia transakcja się nie powiodła, false w przeciwnym wypadku.
     */
    boolean isLastTransactionRollback();


    /**
     * Edycja recepty.
     *
     * @param editPrescriptionRequestDto dto z danymi do edycji recepty
     * @throws PrescriptionException wyjątek PrescriptionException
     * @throws EncryptionException wyjątek EncryptionException
     */
    void editPrescription(EditPrescriptionRequestDto editPrescriptionRequestDto) throws PrescriptionException, EncryptionException;

    List<PrescriptionResponseDto> getPrescriptions() throws AppBaseException;
    List<PrescriptionResponseDto> getPatientPrescriptions() throws AppBaseException;
    List<PrescriptionResponseDto> getDoctorPrescriptions() throws AppBaseException;

}
