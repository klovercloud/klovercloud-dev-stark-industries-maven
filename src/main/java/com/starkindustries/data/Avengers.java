package com.starkindustries.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.lang.Nullable;

import com.starkindustries.business.dto.Avenger;
import com.starkindustries.business.dto.Mission;


@Entity
public class Avengers  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private String id;

	private String code;

	@NotNull
	private String name;
	
	@NotNull
	private String position;

	@Column(nullable = true)
	private String imageName;
	
	@Column(nullable = true)
	private ArrayList<String> missions;
	
	
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
	public ArrayList<String> getMissions() {
		return missions;
	}

	public void setMissions(ArrayList<String> missions) {
		this.missions = missions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Avengers getAvengers(Avenger avenger) {
		Avengers avengers=new Avengers();
		avengers.id=avenger.getId();
		avengers.code=avenger.getCode();
		avengers.name=avenger.getName();
		avengers.position=avenger.getPosition();
		try {
		List<String> missions=new ArrayList<>();
		avenger.getMissions().stream().forEach(mission->{
			missions.add(mission.getName());
		});
		}catch(Exception e) {}
		if(avenger.getImageName()!= null && !avenger.getImageName().isEmpty()) {
			avengers.imageName=avenger.getImageName();
		}

		return avengers;
	}

	public Avengers(String id, String code, @NotNull String name, @NotNull String position, @NotNull String imageName,
			ArrayList<String> missions) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.position = position;
		this.imageName = imageName;
		this.missions = missions;
	}

	public Avengers() {
		super();
	}
	
	

}