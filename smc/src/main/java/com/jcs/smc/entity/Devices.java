package com.jcs.smc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="devices")
public class Devices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String information;
	@Lob
	@Column(name="image", columnDefinition="blob")
	private byte[] image;
	@Column(name="isinactive", columnDefinition = "TINYINT")
	private Boolean isinactive;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	private Rooms room;
	
	@ManyToOne
	@JoinColumn(name = "serviceid")
	private DevicesServices deviceService;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private DevicesTypes deviceType;
	
	@ManyToOne
	@JoinColumn(name = "statusid")
	private DevicesStatus deviceStatus;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "device")
    private Set<Users> user = new HashSet<Users>();

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

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Boolean getIsinactive() {
		return isinactive;
	}

	public void setIsinactive(Boolean isinactive) {
		this.isinactive = isinactive;
	}

	public int getId() {
		return id;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public DevicesServices getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DevicesServices deviceService) {
		this.deviceService = deviceService;
	}

	public DevicesTypes getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DevicesTypes deviceType) {
		this.deviceType = deviceType;
	}

	public DevicesStatus getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DevicesStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}
	
	

}
