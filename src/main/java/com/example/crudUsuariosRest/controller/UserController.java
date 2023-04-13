package com.example.crudUsuariosRest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudUsuariosRest.dto.UserDto;
import com.example.crudUsuariosRest.entity.Usuarios;
import com.example.crudUsuariosRest.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;

	@GetMapping
	public String test() {
		return "test full";
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll() {
		List<Usuarios> usList = userServices.getAll();
		if (!usList.isEmpty()) {
			return ResponseEntity.ok(usList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no found");
	}

	@PostMapping("/add")
	public ResponseEntity<Object> add(@ModelAttribute Usuarios usuario) {
		Usuarios usuariosNew = userServices.add(usuario);
		if (usuariosNew != null) {
			return ResponseEntity.ok(usuariosNew);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error");
		}
	}
	
	
	@PostMapping("/edit")
	public ResponseEntity<Object> edit(@ModelAttribute Usuarios usuario) {
		Usuarios usuariosNew = userServices.edit(usuario);
		if (usuariosNew != null) {
			return ResponseEntity.ok(usuariosNew);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error");
		}
	}


	@PostMapping("/findId")
	public ResponseEntity<Object> findId(@RequestParam(name = "identificacion") Integer identificacion) {
		Usuarios usuariosFind = userServices.findId(identificacion);
		if (usuariosFind != null) {
			return ResponseEntity.ok(usuariosFind);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no content");
		}
	}
	
	
	

}
