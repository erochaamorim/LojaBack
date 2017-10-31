package br.edu.devmedia.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content implements Serializable {

	private static final long serialVersionUID = 3581301361067115944L;

	
	private List<String> regIds;
	private Map<String, String> data;
	
	public void addRegId(String regId) {
		
		if(regIds == null) {
			
			regIds = new ArrayList<String>(); 
			
		}
		regIds.add(regId);
		
	}
	
	public void addData(String chave, String valor) {
		
		if(data == null) {
			
			data = new HashMap<String, String>();
			
		}
		data.put(chave, valor);
		
	}

	public List<String> getRegIds() {
		return regIds;
	}

	public void setRegIds(List<String> regIds) {
		this.regIds = regIds;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	
	
}
