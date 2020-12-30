package mx.tecnetia.architecture.security.api_rest_controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnetia.architecture.security.dto.JwtDTO;
import mx.tecnetia.architecture.security.dto.LoginUsuarioDTO;
import mx.tecnetia.architecture.security.dto.MensajeDTO;
import mx.tecnetia.architecture.security.dto.NuevoMiembroArquitecturaDTO;
import mx.tecnetia.architecture.security.dto.NuevoUsuarioArquitecturaDTO;
import mx.tecnetia.architecture.security.model.jwt.JwtProvider;
import mx.tecnetia.architecture.security.service.auth.AuthService;
import mx.tecnetia.architecture.security.service.rol.RolService;
import mx.tecnetia.architecture.security.service.usuario.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	private AuthService authService;

	@PostMapping("/nuevo")
	public ResponseEntity<MensajeDTO> nuevo(@RequestBody @Valid NuevoUsuarioArquitecturaDTO nuevoUsuario) {

		if (usuarioService.existePorEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity<>(new MensajeDTO("Ese email ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existePorNick(nuevoUsuario.getNick()))
			return new ResponseEntity<>(new MensajeDTO("Ese usuario ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existeCurp(nuevoUsuario.getCurp()))
			return new ResponseEntity<>(new MensajeDTO("Ese CURP ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existeRfc(nuevoUsuario.getRfc()))
			return new ResponseEntity<>(new MensajeDTO("Ese RFC ya está registrado"), HttpStatus.BAD_REQUEST);

		boolean ret = usuarioService.guardar(nuevoUsuario);
		if (ret)
			return new ResponseEntity<>(new MensajeDTO("Usuario guardado exitosamente"), HttpStatus.CREATED);

		return new ResponseEntity<>(new MensajeDTO("No se pudo guardar el usuario"), HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuarioDTO loginUsuario) {

		JwtDTO jwtDTO = authService.login(loginUsuario);

		return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/existeRfc")
	public ResponseEntity<Boolean> existeRfc(@RequestParam("rfc") String rfc) {
		return new ResponseEntity<>(usuarioService.existeRfc(rfc), HttpStatus.OK);
	}

	@GetMapping(value = "/existeCurp")
	public ResponseEntity<Boolean> existeCurp(@RequestParam("curp") String curp) {
		return new ResponseEntity<>(usuarioService.existeCurp(curp), HttpStatus.OK);
	}

//	@GetMapping("/sexos")
//	public ResponseEntity<?> getAllSexos() {
//		List<SexoDTO> sexosList = new ArrayList<>();
//		String transactionUrl = "http://localhost:8081/afiliacion/catalogos/sexos";
//		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(transactionUrl);
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<List<SexoDTO>> response;
//
//		try {
////			sexosList = restTemplate.getForObject(builder.toUriString(), List<SexoDTO.class>);
//			response = restTemplate.exchange(transactionUrl, HttpMethod.GET, null,
//					new ParameterizedTypeReference<List<SexoDTO>>() {
//					});
//			return response;
//
//		} catch (Exception e) {
//			MensajeDTO msg = new MensajeDTO(
//					"Ocurrió un error recuperando la información de los catálogos: " + e.getLocalizedMessage());
//			System.err.print(e.getLocalizedMessage());
//			return new ResponseEntity<MensajeDTO>(msg, HttpStatus.PRECONDITION_FAILED);
//		}
//
//	}
	
	@PostMapping("/nuevoMiembro")
	public ResponseEntity<MensajeDTO> nuevoMiembro(@RequestBody @Valid NuevoMiembroArquitecturaDTO nuevoMiembro) {

		if (usuarioService.existePorEmail(nuevoMiembro.getEmail()))
			return new ResponseEntity<>(new MensajeDTO("Ese email ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existePorNick(nuevoMiembro.getNick()))
			return new ResponseEntity<>(new MensajeDTO("Ese usuario ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existeCurp(nuevoMiembro.getCurp()))
			return new ResponseEntity<>(new MensajeDTO("Ese CURP ya está registrado"),
					HttpStatus.BAD_REQUEST);
		if (usuarioService.existeRfc(nuevoMiembro.getRfc()))
			return new ResponseEntity<>(new MensajeDTO("Ese RFC ya está registrado"), 
					HttpStatus.BAD_REQUEST);

		boolean ret = usuarioService.guardar(nuevoMiembro);
		if (ret)
			return new ResponseEntity<>(new MensajeDTO("Usuario guardado exitosamente"), HttpStatus.CREATED);

		return new ResponseEntity<>(new MensajeDTO("No se pudo guardar el usuario"), HttpStatus.CONFLICT);
	}
}