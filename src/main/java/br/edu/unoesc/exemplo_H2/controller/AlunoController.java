package br.edu.unoesc.exemplo_H2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.exemplo_H2.model.Aluno;
import br.edu.unoesc.exemplo_H2.repository.AlunoRepository;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository repositorio;
	
	@GetMapping("/find")
	List<Aluno> listarComFiltro(@RequestParam("filtro") String filtro) {
		return repositorio.findByNascimentoContainingIgnoreCase(filtro);
	}
	
	@GetMapping
	public Iterable<Aluno> listarTudo() {
		return repositorio.findAll();
	}
}
