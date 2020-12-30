package mx.tecnetia.architecture.security.aplicacion.dto.afiliacion;

import java.util.Date;
import lombok.Data;

@Data
public class FamiliarBeneficiarioDTO {
	
	private String nombres;
	private String apPaterno;
	private String apMaterno;
    private RelacionFamiliarDTO idEstatusCredito;
	private Date fechaNaciomiento;
	private SexoDTO sexo;
	private String curp;
	private Integer telefono;
	private String email;
	private Integer arqIdUsuario;

}
