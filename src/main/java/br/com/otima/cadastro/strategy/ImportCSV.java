package br.com.otima.cadastro.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.service.ICadastroService;

@Component
public class ImportCSV implements Strategy {

	@Autowired
	ICadastroService cadastroService;

	@Override
	public StrategyName getStrategyName() {
		return StrategyName.ImportCSV;
	}

	@Override
	public void importar(MultipartFile file) {

		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			CsvToBean<CadastroEntity> csvToBean = new CsvToBeanBuilder(reader).withType(CadastroEntity.class)
					.withIgnoreLeadingWhiteSpace(true).withSeparator(',').build();

			List<CadastroEntity> cadastros = csvToBean.parse();

			for (CadastroEntity cadastroEntity : cadastros) {
				cadastroService.criar(cadastroEntity);
			}

		} catch (IOException ex) {

			throw new IllegalArgumentException("Erro ao converter arquivo");

		}
	}

}
