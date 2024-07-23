package br.com.project;

import br.com.project.model.DadoSerie;
import br.com.project.model.DadosEpisodio;
import br.com.project.model.DadosTemporada;
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

		ConverteDados conversor = new ConverteDados();
		var consumo = new ConsumoAPI();

		var dadosSerie = consumirJson("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c", consumo);
		System.out.println(dadosEspecificos(dadosSerie, conversor, DadoSerie.class));

		var dadosEpisodio = consumirJson("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=6585022c", consumo);
		System.out.println(dadosEspecificos(dadosEpisodio, conversor, DadosEpisodio.class));

	}

	public <T> String dadosEspecificos(String dados, ConverteDados conversor, Class<T> classe){
		T resultadoObjeto = conversor.obterDados(dados, classe);
		return resultadoObjeto.toString();
	}

	public String consumirJson(String json, ConsumoAPI consumo){
		return consumo.obterDados(json);
	}

}
