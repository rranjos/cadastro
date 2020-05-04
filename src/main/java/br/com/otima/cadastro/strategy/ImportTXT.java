package br.com.otima.cadastro.strategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.service.ICadastroService;

@Component
public class ImportTXT implements Strategy {

	@Autowired
	ICadastroService cadastroService;

	@Override
	public StrategyName getStrategyName() {
		return StrategyName.ImportTXT;
	}

	@Override
	public void importar(MultipartFile file) {
		System.out.println("importando TXT");

		try {

			Scanner input = new Scanner(new InputStreamReader(file.getInputStream()));
			input.useDelimiter(";");
			input.nextLine();
			while (input.hasNextLine()) {
				String nome = input.next().replaceAll("\"", "");
				String cnpj = input.next().replaceAll("\"", "");
				String tipo = input.next().replaceAll("\"", "");
				String razaoSocial = input.next().replaceAll("\"", "");
				String telefone = input.next().replaceAll("\"", "");
				String email = input.next().replaceAll("\"", "");
				String cep = input.next().replaceAll("\"", "");
				String estado = input.next().replaceAll("\"", "");
				String bairro = input.next().replaceAll("\"", "");
				String cidade = input.next().replaceAll("\"", "");
				String logradouro = input.next().replaceAll("\"", "");

				CadastroEntity cadastroEntity = new CadastroEntity(nome, cnpj, tipo, razaoSocial, telefone, email, cep,
						estado, bairro, cidade, logradouro);
				cadastroService.criar(cadastroEntity);
				input.nextLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
