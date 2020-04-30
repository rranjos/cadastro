package br.com.otima.cadastro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.otima.cadastro.entidade.CadastroEntity;


@Repository
public interface CadastroRepository extends PagingAndSortingRepository<CadastroEntity,Long> {
	
	@Query("select c from CadastroEntity c where c.nome like %:nome% or c.cnpj = :cnpj")
	Page<CadastroEntity> filtrarEmpresasPorNomeCNPJ(@Param("nome") String nome, @Param("cnpj") String cnpj, Pageable p);

	@Query("select case when (c.tipo = 2)  then true else false end from CadastroEntity c where c.id = :id")
	boolean consultaTipoEmpresa(@Param("id") Long id);


}


