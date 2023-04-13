package com.example.crudUsuariosRest.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudUsuariosRest.entity.Usuarios;
import com.example.crudUsuariosRest.repository.UserRepository;
import com.example.crudUsuariosRest.services.UserServices;

@Service
public class UserImpl implements UserServices {
	
@Autowired
UserRepository userRepository;

@Override
public Usuarios add(Usuarios usuario) {
	return userRepository.save(usuario);	
}

@Override
public Usuarios edit(Usuarios usuario) {
	Optional<Usuarios> us = userRepository.findById(usuario.getIdentificacion());
	if (us.isPresent()) {
		us.get().setGrupo(usuario.getGrupo());
	    us.get().setNombre(usuario.getNombre());
		return userRepository.save(us.get());}
	return null;	
}

@Override
public List<Usuarios> getAll() {
	return userRepository.findAll();	
}

@Override
public Usuarios findId(Integer identificacion) {	
	Optional<Usuarios> us =  userRepository.findById(identificacion);
    if (us.isPresent()) 
		return us.get();
	return  null;
}

@Override
public Boolean remove(Integer identificacion) {	
	Optional<Usuarios> us =  userRepository.findById(identificacion);
    if (us.isPresent()) {
    	userRepository.delete(us.get());
		return true;
    }
	return false;
}


}
