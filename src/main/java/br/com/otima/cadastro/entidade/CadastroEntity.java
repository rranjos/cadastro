package br.com.otima.cadastro.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_empresa")
public class CadastroEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "nome", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "Nome é obrigatório")
    private String nome;
	
	@Column(name = "cnpj", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "O CNPJ é obrigatório")
	private String cnpj;
	
	@Column(name = "tipo", nullable = false, length = 255)
    @Size(max = 1)
	private String tipo;
	
	@Column(name = "razao_social", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "A Razão Social é obrigatório")
	private String razaoSocial;
	
	@Column(name = "telefone", nullable = false, length = 255)
    @Size(max = 10)
	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;
	
	@Column(name = "email", nullable = false, length = 255)
    @Size(max = 50)
	@NotBlank(message = "O e-mail é obrigatório")
	private String email;
	
	@Column(name = "cep", nullable = false, length = 255)
    @Size(max = 8)
	@NotBlank(message = "O CEP é obrigatório")
	private String cep;
	
	@Column(name = "estado", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "O Estado é obrigatório")
	private String estado;
	
	@Column(name = "bairro", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "O bairro é obrigatório")
	private String bairro;
	
	@Column(name = "cidade", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "A cidade é obrigatório")
	private String cidade;
	
	@Column(name = "logradouro", nullable = false, length = 255)
    @Size(max = 45)
	@NotBlank(message = "O logradouro é obrigatório")
	private String logradouro;
	
	@Column(name = "complemento", nullable = false, length = 255)
    @Size(max = 45)
	private String complemento;
	


	
	
	public CadastroEntity() {	
		super();
		// TODO Auto-generated constructor stub
	}

	public CadastroEntity(Long id){
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
