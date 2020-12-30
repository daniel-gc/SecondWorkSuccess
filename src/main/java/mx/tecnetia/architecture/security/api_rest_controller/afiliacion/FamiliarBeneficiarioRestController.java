package mx.tecnetia.architecture.security.api_rest_controller.afiliacion;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mx.tecnetia.architecture.security.aplicacion.dto.afiliacion.FamiliarBeneficiarioDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/afiliacion/familiarbeneficiario")
@RequiredArgsConstructor
@Log4j2
public class FamiliarBeneficiarioRestController {
	
	@PostMapping("registro")
	public ResponseEntity<Boolean> nuevo(@RequestBody @Valid FamiliarBeneficiarioDTO familiarBeneficiarioDTO) {

		HttpStatus status = HttpStatus.OK;

		boolean ret = afiliacionService.nuevoFamiliar(nuevoFamiliarDTO);

		return ret ? new ResponseEntity<>(true, status) : new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
