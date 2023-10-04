package com.itb.brazurista.turismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.brazurista.turismo.model.Usuario;
import com.itb.brazurista.turismo.repository.UsuarioRepository;

@Controller
@RequestMapping("/brazurista/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/cadastro")
	public String novoProduto(Usuario usuario, Model model) {
		
		model.addAttribute("usuario", usuario);
		return "cadastro";
	}
	
	// Cadastrar o usuário
	
	@PostMapping("/add-usuario")
	public String addNovoUsuario(Usuario usuario, Model model) {
		
		usuario.setCodStatusUsuario(true);
		usuarioRepository.save(usuario);
		
		return "redirect:/brazurista/usuario/cadastro";
	}
	
	// Abrir formulário de Login
	@GetMapping("/cadastro/sucesso")
	public String showPageSucessoCadastro() {
		
		return "sucesso-usuario";
	}
	
	// Abrir formulário de edição (perfil)
}
