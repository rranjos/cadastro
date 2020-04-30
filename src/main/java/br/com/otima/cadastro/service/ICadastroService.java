package br.com.otima.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.otima.cadastro.entidade.CadastroEntity;

@Service
public interface ICadastroService {
	
	
	Page<CadastroEntity> listarEmpresas(Pageable p);
	
	CadastroEntity recuperar(Long id);

	Page<CadastroEntity> filtrarEmpresasPorNomeCNPJ(String nome, String cnpj, Pageable p);

	Page<CadastroEntity> criar(CadastroEntity cadastro);

	void alterar(CadastroEntity cadastro);

	void excluir(Long id);

}
