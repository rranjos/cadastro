package br.com.otima.cadastro.erros;

public class ObjectError {

	private static final long serialVersionUID = 1L;

	private String message;
	private String field;
	private Object parameter;

	public ObjectError(String message, String field, Object parameter) {
		this.message = message;
		this.field = field;
		this.parameter = parameter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
