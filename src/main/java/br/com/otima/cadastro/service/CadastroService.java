package br.com.otima.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.repository.CadastroRepository;

@Service
public class CadastroService implements ICadastroService {
	
	@Autowired
	CadastroRepository cadastroRepository;

	@Override
	public Page<CadastroEntity> listarEmpresas(Pageable p) {
		return cadastroRepository.findAll(p);
	}

	@Override
	public CadastroEntity recuperar(Long i) {
		return cadastroRepository.findById(i.longValue()).get();
	}

	@Override
	public Page<CadastroEntity> filtrarEmpresasPorNomeCNPJ(String nome, String cnpj, Pageable p) {
		return cadastroRepository.filtrarEmpresasPorNomeCNPJ(nome, cnpj, p);
	}

	@Override
	public Page<CadastroEntity> criar(CadastroEntity cadastro) {
		 cadastroRepository.save(cadastro);
		 return null;
	}

	@Override
	public void alterar(CadastroEntity cadastro) {
		cadastroRepository.save(cadastro);
		
	}

	@Override
	public void excluir(Long id) {
		
		//verificando se a empresa pode ser excluida. Resolvi não consumir o tipo da empresa pelo parâmetro enviado pelo cliente por questões de segurança (pode ser manipuado na url)
		if(!ehFilial(id))
			throw new IllegalArgumentException("Empresa não poderá ser excluída por ser matriz");
		
		cadastroRepository.delete(new CadastroEntity(id));
		
	}
	
	public boolean ehFilial(Long id){
		boolean ehFilial = cadastroRepository.consultaTipoEmpresa(id);
		return ehFilial;
	}

}
