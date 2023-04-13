package com.example.crudUsuariosRest.entity;


import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
	
	@Id
    private Integer identificacion;
    private String nombre;
    private String grupo;
    
    
	public Integer getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


  

}
