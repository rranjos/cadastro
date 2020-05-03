package cadastro;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.otima.cadastro.Application;
import br.com.otima.cadastro.entidade.CadastroEntity;
import br.com.otima.cadastro.service.ICadastroService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class CadastroTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private ICadastroService service;
    
   
    @Test
    void listarEmpresas() throws Exception {
    	
    	MvcResult result = 	mockMvc.perform(get("/empresa")
    	        .contentType("application/json")
    	        .content(objectMapper.writeValueAsString(getPageable())))
    			.andExpect(jsonPath("$.content[0].nome",  notNullValue()))
    			.andExpect(status().isOk()).andReturn();
    	
    	
    }
    
    
    @Test
    void listarPorNome() throws Exception {
    	
    	
    	mockMvc.perform(MockMvcRequestBuilders.get("/empresa/filtrar/")
    	        .contentType("application/json")
    	        .param("nome", "TryTec")
    	        .param("cnpj", "68103003000194")
    	        .content(objectMapper.writeValueAsString(getPageable())))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.content[0].nome", is("TryTec")));

    }
    
    @Test
    void criar() throws Exception{
    	
    	MvcResult result = 	mockMvc.perform(post("/empresa/criar")
		      .content(objectMapper.writeValueAsString(new CadastroEntity(null, "TryTec", "68103003000194", "1", "TryTec", "996255252", "anjos.ricardo@gmail.com", "71909720", "Distrito Federal", "Águas Claras", "Brasília", "Rua 30 Norte", "")))
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isCreated())
    		      .andExpect(jsonPath("$.nome", is("TryTec")))
    		      .andReturn();
    	
    }
    
    @Test
    void alterar() throws Exception{
    	
    	MvcResult result = 	mockMvc.perform(put("/empresa/alterar")
  		      .content(objectMapper.writeValueAsString(new CadastroEntity(new Long(42),"Novo Nome", "68103003000194", "2", "TryTec", "996255252", "anjos.ricardo@gmail.com", "71909720", "Distrito Federal", "Águas Claras", "Brasília", "Rua 30 Norte", "")))
  		      .contentType("application/json"))
      		      .andExpect(status().isOk())
      		      .andExpect(jsonPath("$.nome", is("Novo Nome")))
      		      .andReturn();
    }
    
    @Test
    void excluir () throws Exception{
    	mockMvc.perform(delete("/empresa/excluir/{id}", "42"))
    	.andExpect(status().isOk());
    }
    
    @Test
    void recuperar() throws Exception {
    	
    	
    	mockMvc.perform(MockMvcRequestBuilders.get("/empresa/{id}", "49")
    	        .contentType("application/json"))
    	        .andExpect(status().isOk())
    			.andExpect(jsonPath("$.nome", is("TryTec")));

    }
    
    

	private Pageable getPageable() {
		Pageable p = new Pageable() {
			
			@Override
			public Pageable previousOrFirst() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Pageable next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getPageSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getPageNumber() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getOffset() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Pageable first() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return p;
	}
    
    

}
