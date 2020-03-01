package com.starkindustries.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
public class Staff  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private String id;

	private String code;

	@NotNull
	private String name;
	
	@NotNull
	private String position;

	@NotNull
	private String imageName;
	
	@Transient
	private byte[] image;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
