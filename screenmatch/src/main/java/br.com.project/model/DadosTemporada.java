package br.com.project.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode")List<DadosEpisodio> episodios
        ) {
}
