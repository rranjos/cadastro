package br.com.otima.cadastro.rest;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.service.ICadastroService;

@RestController
@RequestMapping({ "/empresa" })
@CrossOrigin(origins = "http://localhost:4200/*")
public class CadastroController {

	@Autowired
	ICadastroService cadastroService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar(@PageableDefault(page = 0, size = 20) Pageable p) {
		Page<CadastroEntity> page = cadastroService.listarEmpresas(p);
		return ResponseEntity.ok(page);
	}

	@RequestMapping(path = "/filtrar", method = RequestMethod.GET)
	public ResponseEntity<?> listarPorNome(@RequestParam(name = "nome") String nome,
			@RequestParam(name = "cnpj") String cnpj, Pageable p) {
		Page<CadastroEntity> page = cadastroService.filtrarEmpresasPorNomeCNPJ(nome, cnpj, p);
		return ResponseEntity.ok(page);
	}

	@PostMapping(path = "/criar")
	public ResponseEntity<Void> criar(@RequestBody @Valid CadastroEntity cadastro) {
		cadastroService.criar(cadastro);
		return new ResponseEntity(cadastro, HttpStatus.CREATED);
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<Void> alterar(@RequestBody CadastroEntity cadastro) {
		cadastroService.alterar(cadastro);
		return new ResponseEntity(cadastro, HttpStatus.OK);

	}

	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> excluir(@PathVariable(name = "id") Long id) {
		cadastroService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> recuperar(@PathVariable("id") Long id) {
		CadastroEntity cadastro = cadastroService.recuperar(id);
		return ResponseEntity.ok(cadastro);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uplaodImage(@RequestParam("arquivo") MultipartFile file) throws IOException {
		
		String tipo = Files.getFileExtension(file.getOriginalFilename());
		
		if(tipo.equals("csv")) {
			
		}else if(tipo.contentEquals("txt")) {
			
		}
		
		return ResponseEntity.ok().build();
		
	}

}
