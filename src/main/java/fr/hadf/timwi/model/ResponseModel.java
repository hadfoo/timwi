package fr.hadf.timwi.model;

import java.util.List;

import org.springframework.util.StringUtils;

public class ResponseModel<T> {
	
	private List<T> data;
	private String errorMessage;
	
	public ResponseModel() {}
	public ResponseModel(List<T> data) {
		this.data = data;
	}
	public ResponseModel(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean isSuccess() {
		return StringUtils.isEmpty(errorMessage);
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
