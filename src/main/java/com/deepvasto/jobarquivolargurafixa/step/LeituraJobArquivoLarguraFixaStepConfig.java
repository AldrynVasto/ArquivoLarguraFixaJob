package com.deepvasto.jobarquivolargurafixa.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deepvasto.jobarquivolargurafixa.dominio.Cliente;

@Configuration
public class LeituraJobArquivoLarguraFixaStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step leituraJobArquivoLarguraFixaStep (ItemReader<Cliente> leituraJobArquivoLarguraFixaReader,
			ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
		return stepBuilderFactory
				.get("leituraJobArquivoLarguraFixaStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraJobArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
