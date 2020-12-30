package mx.tecnetia.architecture.security.aplicacion.negocio.service.afiliacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;

public class FamiliarBeneficiarioServiceImpl implements FamiliarBeneficiarioService{

	@Autowired
	private CatalogosAfiliacionService catalogosAfiliacionService;
	
	@Override
	public List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idUsuarioArq) {

		RestTemplate restTemplate = new RestTemplate();
		
		String uriGetHistorialPago = catalogosAfiliacionService.getURLAfilicacionGetFamiliaresBeneficiarios();
		var builder = UriComponentsBuilder.fromUriString(uriGetHistorialPago)
				.queryParam("arqIdUsuario", idUsuarioArq);

		var listaSuscripcionDTO = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
			new ParameterizedTypeReference<List<SuscripcionDTO>>() {
		});
		
		return listaSuscripcionDTO;
	}

	@Override
	public Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO familiarBeneficiarioDTO) {

		return null;
	}

	@Override
	public Boolean updateFamiliar(Integer idFamiliar) {

		return null;
	}

	@Override
	public FamiliarBeneficiarioDTO getFamiliarBneficiarioPorIdArqUser(Integer idUsuarioArq) {

		return null;
	}

	@Override
	public FamiliarBeneficiarioDTO getAfiliadoPorIdFamiliar(Integer idFamiliar) {

		return null;
	}

}
