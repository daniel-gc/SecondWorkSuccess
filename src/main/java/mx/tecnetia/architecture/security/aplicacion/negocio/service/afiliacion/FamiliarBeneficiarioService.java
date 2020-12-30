package mx.tecnetia.architecture.security.aplicacion.negocio.service.afiliacion;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;

public interface FamiliarBeneficiarioService {
	
	List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idUsuarioArq);
	
	Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO familiarBeneficiarioDTO);
	
	/**
	 * @author Daniel
	 * @descripciòn: Método para actualizar un familiar beneficiario
	 * @param FamiliarBeneficiarioDTO
	 * @return Boolean
	 * */
	public Boolean updateFamiliar(FamiliarBeneficiarioDTO familiarBeneficiarioDTO) throws NotFoundException;
	
	
	/**
	 * @author Daniel
	 * @descripciòn: Método para borrar beneficiario
	 * @param Integer
	 * @return Boolean
	 * */
	public Boolean deleteFamiliar(Integer id) throws NotFoundException;
	
	
	FamiliarBeneficiarioDTO getFamiliarBneficiarioPorIdArqUser(Integer idUsuarioArq);
	
	FamiliarBeneficiarioDTO getAfiliadoPorIdFamiliar(Integer idFamiliar);

}
