package br.com.project;

import br.com.project.model.DadoSerie;
import br.com.project.service.ConsumoAPI;
import br.com.project.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumo = new ConsumoAPI();
		var json = consumo.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadoSerie dadoSerie = conversor.obterDados(json, DadoSerie.class);
		System.out.println(dadoSerie);
	}
}
