package mx.tecnetia.architecture.security.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import mx.tecnetia.architecture.security.dto.JwtDTO;
import mx.tecnetia.architecture.security.dto.LoginUsuarioDTO;
import mx.tecnetia.architecture.security.dto.NuevoUsuarioArquitecturaDTO;
import mx.tecnetia.architecture.security.model.jwt.JwtProvider;
import mx.tecnetia.architecture.security.persistence.hibernate.repository.UsuarioEntityRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UsuarioEntityRepository usuarioEntityRepository;
	@Autowired
	JwtProvider jwtProvider;

	@Override
	public void crearNuevoUsuario(NuevoUsuarioArquitecturaDTO nuevoUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public JwtDTO login(LoginUsuarioDTO loginUsuario) {

		var usuarioEntity = this.usuarioEntityRepository.findByNick(loginUsuario.getNick());

		if (usuarioEntity != null && usuarioEntity.getActivo()) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginUsuario.getNick(), loginUsuario.getPassw()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtProvider.generateToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());

			return jwtDTO;
		}

		return null;
	}

}
