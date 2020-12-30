package mx.tecnetia.architecture.security.aplicacion.negocio.service.afiliacion;

import java.util.List;

import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;

public interface FamiliarBeneficiarioService {
	
	List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idUsuarioArq);
	
	Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO familiarBeneficiarioDTO);
	
	Boolean updateFamiliar(Integer idFamiliar);
	
	FamiliarBeneficiarioDTO getFamiliarBneficiarioPorIdArqUser(Integer idUsuarioArq);
	
	FamiliarBeneficiarioDTO getAfiliadoPorIdFamiliar(Integer idFamiliar);

}
