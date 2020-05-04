package br.com.otima.cadastro.strategy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.service.ICadastroService;

@Component
public class ImportJSON implements Strategy {

	@Autowired
	ICadastroService cadastroService;

	@Override
	public void importar(MultipartFile file) {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		try {
			List<CadastroEntity> registros = objectMapper.readValue(new InputStreamReader(file.getInputStream()),
					new TypeReference<List<CadastroEntity>>() {
					});
			for (CadastroEntity cadastroEntity : registros) {
				cadastroService.criar(cadastroEntity);
			}

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StrategyName getStrategyName() {
		return StrategyName.ImportJSON;
	}

}
