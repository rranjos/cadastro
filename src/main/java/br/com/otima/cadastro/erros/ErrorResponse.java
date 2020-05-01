package br.com.otima.cadastro.erros;

import java.util.List;

public class ErrorResponse {

    private String message;
    private int code;
    private String status;
    private List<ObjectError> errors;
    private String resume;
    
	public ErrorResponse(String message, int code, String status, List<ObjectError> errors) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
		this.errors = errors;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}
	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}
	public String getResume() {
		
		StringBuilder str = new StringBuilder();
		for (ObjectError objectError : errors) {
			str.append(objectError.getMessage());
		}
		return str.toString();
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
    
    
    
}