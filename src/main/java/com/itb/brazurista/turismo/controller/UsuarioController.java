package com.itb.brazurista.turismo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.brazurista.turismo.model.Usuario;
import com.itb.brazurista.turismo.repository.UsuarioRepository;

@Controller
@RequestMapping("/brazurista")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/cadastro")
	public String novoProduto(Usuario usuario, Model model) {
		
		model.addAttribute("usuario", usuario);
		return "cadastro";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	List<Usuario> listaDeUser = new ArrayList<Usuario>();
	
	@GetMapping("/controleradm")
	public String contolerUser(Model model) {
		 model.addAttribute("listaDeUser", listaDeUser);
		 return "crud";
	}
	// Cadastrar o usuário
	
	@PostMapping("/add-usuario")
	public String addNovoUsuario(Usuario usuario, Model model) {
		usuario.setCodStatusUsuario(true);
		usuarioRepository.save(usuario);
		listaDeUser.add(usuario);
		
		return "redirect:/brazurista/cadastro";
	}
	
	// Abrir formulário de Login
	@GetMapping("/cadastro/sucesso")
	public String showPageSucessoCadastro() {
		
		return "index";
	}
	
	// Abrir formulário de edição (perfil)
}
