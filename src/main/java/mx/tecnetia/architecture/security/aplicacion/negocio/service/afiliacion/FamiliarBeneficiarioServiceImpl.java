package mx.tecnetia.architecture.security.aplicacion.negocio.service.afiliacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;
import mx.tecnetia.architecture.security.utils.CopyProperties;

public class FamiliarBeneficiarioServiceImpl implements FamiliarBeneficiarioService {

	@Autowired
	private CatalogosAfiliacionService catalogosAfiliacionService;

	private CopyProperties copyProperties;

	private RestTemplate restTemplate;

	@Override
	public List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idUsuarioArq) {
		String uriGetHistorialPago = catalogosAfiliacionService.getURLAfilicacionGetFamiliaresBeneficiarios();
		var builder = UriComponentsBuilder.fromUriString(uriGetHistorialPago).queryParam("arqIdUsuario", idUsuarioArq);
		var listaSuscripcionDTO = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<FamiliarBeneficiarioDTO>>() {
				});
		return listaSuscripcionDTO.getBody();
	}

	@Override
	public Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO familiarBeneficiarioDTO) {

		return null;
	}

	@Transactional
	@Override
	public Boolean updateFamiliar(FamiliarBeneficiarioDTO familiarBeneficiarioDTO) throws NotFoundException {
		// CONSULTAR FAMILIA BENEFICIARIO DE BD
		var dto = new FamiliarBeneficiarioDTO();
		Boolean sucessUpdate = false;
		dto = (FamiliarBeneficiarioDTO) copyProperties.copyProperties(familiarBeneficiarioDTO, dto);
		String uriUpdateBeneficiario = catalogosAfiliacionService.getURLAfiliacionUpdateFamiliarBeneficiario();
		sucessUpdate = restTemplate.postForObject(uriUpdateBeneficiario, dto, Boolean.class);
		return sucessUpdate;
	}

	@Override
	public Boolean deleteFamiliar(Integer id) throws NotFoundException {
		Boolean flag = false;
		try {
			String uriDeleteBeneficiario = catalogosAfiliacionService.getURLAfiliacionDeleteFamiliar()
					+ "/?idFamiliarBeneficiario=" + id;
			restTemplate.delete(uriDeleteBeneficiario);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
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
