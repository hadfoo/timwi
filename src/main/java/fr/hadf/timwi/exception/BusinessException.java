package fr.hadf.timwi.exception;

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	
	private String code;
	
	public BusinessException(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

}
