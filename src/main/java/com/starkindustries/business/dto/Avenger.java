package com.starkindustries.business.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.starkindustries.data.Avengers;

public class Avenger implements Serializable{
	private Long id;
	private String code;
	private String name;
	private String position;
	private byte[] image;
	private String imageName;
	private List<String> missions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public List<String> getMissions() {
		return missions;
	}
	public void setMissions(List<String> missions) {
		this.missions = missions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((missions == null) ? 0 : missions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Avengers [id=" + id + ", code=" + code + ", name=" + name + ", position=" + position + ", image="
				+ Arrays.toString(image) + ", imageName=" + imageName + ", missions=" + missions + "]";
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avenger other = (Avenger) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (missions == null) {
			if (other.missions != null)
				return false;
		} else if (!missions.equals(other.missions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	public static Avenger getAvenger(Avengers avengers) {
		Avenger avenger=new Avenger();
		avenger.id=avengers.getId();
		avenger.name=avengers.getName();
		avenger.position=avengers.getPosition();
		avenger.code=avengers.getCode();
		avenger.imageName=avengers.getImageName();
		avenger.missions=avengers.getMissions();
		return avenger;
		
	}
	public Avenger(Long id, String code, String name, String position, byte[] image, String imageName,
			List<String> missions) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.position = position;
		this.image = image;
		this.imageName = imageName;
		this.missions = missions;
	}
	public Avenger() {
		super();
	}
	
	

}
