package mx.tecnetia.architecture.security.api_rest_controller.afiliacion;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;
import mx.tecnetia.architecture.security.aplicacion.negocio.service.afiliacion.FamiliarBeneficiarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/afiliacion/familiarbeneficiario")
@RequiredArgsConstructor
@Log4j2
public class FamiliarBeneficiarioRestController {

	private FamiliarBeneficiarioService familiarBeneficiarioService;

	@PostMapping("registro")
	public ResponseEntity<Boolean> nuevo(@RequestBody @Valid FamiliarBeneficiarioDTO familiarBeneficiarioDTO) {
		HttpStatus status = HttpStatus.OK;
		Long ret = familiarBeneficiarioService.saveFamiliarBeneficiario(familiarBeneficiarioDTO);

		return ret != null ? new ResponseEntity<>(true, status)
				: new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("modificar")
	public ResponseEntity<Boolean> modificar(@RequestBody @Valid FamiliarBeneficiarioDTO familiarBeneficiarioDTO)
			throws NotFoundException {
		HttpStatus status = HttpStatus.OK;
		Boolean b = familiarBeneficiarioService.updateFamiliar(familiarBeneficiarioDTO);
		return b != null ? new ResponseEntity<>(true, status)
				: new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("eliminar")
	public ResponseEntity<Boolean> eliminar(@NonNull Integer id) throws NotFoundException {
		HttpStatus status = HttpStatus.OK;
		Boolean b = familiarBeneficiarioService.deleteFamiliar(id);
		return b != null ? new ResponseEntity<>(true, status)
				: new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
