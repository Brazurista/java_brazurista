package com.itb.brazurista.turismo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/pesquisa")
	public String pesquisa() {
		
		return "pesquisa";
	}
	
	@GetMapping("/ponto-Rj")
	public String pontoRj() {
		
		return "ponto-Rj";
	}
	
	@GetMapping("/crud")
	public String crud() {
		
		return "crud";
	}
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/fale-conosco")
	public String faleConosco() {
		
		return "faleConosco";
	}
	
	@GetMapping("/controleadm")
	public String contolerUser(Model model) {
		 List<Usuario> listaDeUser = usuarioRepository.findAll();
		 model.addAttribute("listaDeUser", listaDeUser);
		 return "crud";
	}
	// Cadastrar o usuário
	
	@PostMapping("/add-usuario")
	public String addNovoUsuario(Usuario usuario, Model model) {
		usuario.setCodStatusUsuario(true);
		usuarioRepository.save(usuario);
		
		return "redirect:/brazurista/cadastro";
	}
	
	
	@PutMapping("/desativar-usuario/{id}")
	public ResponseEntity<String> desativarUsuario(@PathVariable Long id) {
	    usuarioRepository.findById(id).ifPresent(usuario -> {
	        usuario.setCodStatusUsuario(false);
	        usuarioRepository.save(usuario);
	    });

	    return ResponseEntity.ok("Usuário desativado com sucesso");
	}
	
	@PutMapping("/ativar-usuario/{id}")
	public ResponseEntity<String> ativarUsuario(@PathVariable Long id) {
	    usuarioRepository.findById(id).ifPresent(usuario -> {
	        usuario.setCodStatusUsuario(true);
	        usuarioRepository.save(usuario);
	    });

	    return ResponseEntity.ok("Usuário ativado com sucesso");
	}


	 
	@GetMapping("/cadastro/sucesso")
	public String showPageSucessoCadastro() {
		
		return "index";
	}
	
	// Abrir formulário de edição (perfil)
}
