package pl.learningspring.carservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Issues")
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="Brand")
	private String brand;
	
	@Column(name="PlateNo")
	private String plateNo;
	
	@Column(name="PersonName")
	private String personName;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Approved")
	private Boolean approved;
	
	public Issue() {
		super();
		this.approved = Boolean.FALSE;
	}

	public Issue(Long id, String brand, String plateNo, String personName, String title,String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.plateNo = plateNo;
		this.personName = personName;
		this.description = description;
		this.title = title;
		this.approved = Boolean.FALSE;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String registerNo) {
		this.plateNo = registerNo;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	
}
