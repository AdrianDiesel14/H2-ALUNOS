package br.edu.unoesc.exemplo_H2;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.exemplo_H2.model.Aluno;
import br.edu.unoesc.exemplo_H2.repository.AlunoRepository;

@SpringBootApplication
public class ExemploH2Application {

	public static void main(String[] args) {
		SpringApplication.run(ExemploH2Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AlunoRepository repositorio) {
		return args -> {
			Aluno a = new Aluno(null, "João", new BigDecimal("5000.00"),LocalDate.of(10, 05, 14)););
			a = repositorio.save(a);
			System.out.println(a);
			
			
			Optional<Aluno> p = repositorio.findById(1);
			if (p.isEmpty()) {
				System.out.println("Registro não encontrado!");
			} else {
				System.out.println(p.get());				
			}

			System.out.println(repositorio.findAll());
			
			for (var aluno: repositorio.findByNascimentoContainingIgnoreCase("2001-10-05")) {
				System.out.println(aluno);
			}
			
			for (var aluno: repositorio.porSalario(5000)) {
				System.out.println(aluno);
			}
			
			for (var aluno: repositorio.findByFiltro("João")) {
				System.out.println(aluno);
			}
		};
	}
}