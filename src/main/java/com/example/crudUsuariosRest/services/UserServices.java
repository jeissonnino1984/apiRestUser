package com.example.crudUsuariosRest.services;

import java.util.List;

import com.example.crudUsuariosRest.entity.Usuarios;

public interface UserServices {

	public Usuarios add(Usuarios usuario);

	public Usuarios edit(Usuarios usuario);

	public List<Usuarios> getAll();

	public Boolean remove(Integer identificacion);

	public Usuarios findIdentificacion(Integer identificacion);

}
