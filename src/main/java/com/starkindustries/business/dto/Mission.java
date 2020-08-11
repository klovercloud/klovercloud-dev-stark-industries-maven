package com.starkindustries.business.dto;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mission extends Base implements Serializable{
	
	private String id;
	private String name;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	public static Mission getMission(String url) throws Exception {
		HttpHeaders header = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		try {
		CustomResponse<Mission> response = restTemplate.getForObject(url, CustomResponse.class);
		if (response.getStatus().equals("success")){
			try {
				byte [] json=mapper.writeValueAsBytes(response.getData());
			Mission mission=mapper.readValue(json, Mission.class);
			return  mission;
			}catch(Exception e) {
				throw e;
			}
		}else {
			throw new Exception("No record found!");
		}
		}catch(Exception e) {
			throw e;
		}
	}
	

}
