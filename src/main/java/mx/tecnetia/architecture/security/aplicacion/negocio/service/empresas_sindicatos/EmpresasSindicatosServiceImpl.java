package mx.tecnetia.architecture.security.aplicacion.negocio.service.empresas_sindicatos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.tecnetia.architecture.security.aplicacion.dto.empresas_sindicatos.LogImportacionDTO;
import mx.tecnetia.architecture.security.aplicacion.negocio.component.AplicacionVariablesComponent;
import mx.tecnetia.architecture.security.service.modulo.ModuloService;

@Service
public class EmpresasSindicatosServiceImpl implements EmpresasSindicatosService {
	@Autowired
	private AplicacionVariablesComponent aplicacionVariablesComponent;
	@Autowired
	private ModuloService moduloService;

	@Override
	@Transactional(readOnly = true)
	public String getURLEmailsDelegados() {
		String codigoModuloEmpresasSindicatos = aplicacionVariablesComponent.getCodigoModuloEmpresasSindicatos();
		String codigoEmpresasSindicatosEmailsDelegados = aplicacionVariablesComponent
				.getCodigoEmpresasSindicatosEmailsDelegados();
		String url = moduloService.getURL(codigoModuloEmpresasSindicatos, codigoEmpresasSindicatosEmailsDelegados);

		return url;
	}

	@Override
	@Transactional(readOnly = true)
	public String getURLImportaDatos() {
		String codigoModuloEmpresasSindicatos = aplicacionVariablesComponent.getCodigoModuloEmpresasSindicatos();
		String codigoEmpresasSindicatosImportaDatos = aplicacionVariablesComponent
				.getCodigoEmpresasSindicatosImportaDatos();
		String url = moduloService.getURL(codigoModuloEmpresasSindicatos, codigoEmpresasSindicatosImportaDatos);

		return url;
	}

	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<List<LogImportacionDTO>> importaDatos() {
		String uriParcial = getURLImportaDatos();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uriParcial);

		RestTemplate restTemplate = new RestTemplate();

		LogImportacionDTO[] logLista = restTemplate.getForObject(uriBuilder.toUriString(), LogImportacionDTO[].class);
		return new ResponseEntity<>(Arrays.asList(logLista), HttpStatus.OK);

	}

}
