package com.starkindustries.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.starkindustries.business.dto.Avenger;



@Entity
@Table(name = "avengers")
public class Avengers {


private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "code")
	private String code;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "position")
	private String position;

	@Column(name = "image_name",nullable = true)
	private String imageName;
	
	@Column(name = "missions",nullable = true)
	private ArrayList<String> missions;
	
	
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
		avengers.code=avenger.getCode();
		avengers.name=avenger.getName();
		avengers.position=avenger.getPosition();
		avengers.missions=(ArrayList<String>) avenger.getMissions();
		if(avenger.getImageName()!= null && !avenger.getImageName().isEmpty()) {
			avengers.imageName=avenger.getImageName();
		}

		return avengers;
	}

	public Avengers( String code, @NotNull String name, @NotNull String position, @NotNull String imageName,
			ArrayList<String> missions) {
		super();
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