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
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}
	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}
	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	/**
	 * @return the idEstatusCredito
	 */
	public RelacionFamiliarDTO getIdEstatusCredito() {
		return idEstatusCredito;
	}
	/**
	 * @param idEstatusCredito the idEstatusCredito to set
	 */
	public void setIdEstatusCredito(RelacionFamiliarDTO idEstatusCredito) {
		this.idEstatusCredito = idEstatusCredito;
	}
	/**
	 * @return the fechaNaciomiento
	 */
	public Date getFechaNaciomiento() {
		return fechaNaciomiento;
	}
	/**
	 * @param fechaNaciomiento the fechaNaciomiento to set
	 */
	public void setFechaNaciomiento(Date fechaNaciomiento) {
		this.fechaNaciomiento = fechaNaciomiento;
	}
	/**
	 * @return the sexo
	 */
	public SexoDTO getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(SexoDTO sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return the telefono
	 */
	public Integer getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the arqIdUsuario
	 */
	public Integer getArqIdUsuario() {
		return arqIdUsuario;
	}
	/**
	 * @param arqIdUsuario the arqIdUsuario to set
	 */
	public void setArqIdUsuario(Integer arqIdUsuario) {
		this.arqIdUsuario = arqIdUsuario;
	}

	
}
