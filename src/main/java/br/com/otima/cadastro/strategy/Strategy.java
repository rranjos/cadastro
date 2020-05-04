package br.com.otima.cadastro.strategy;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface Strategy {

	 void importar(MultipartFile file);

	StrategyName getStrategyName();

}

