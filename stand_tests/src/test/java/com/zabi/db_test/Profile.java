package com.zabi.db_test;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Profile {

	@Id
	private long employee_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private Date birth_date;
	private String email;
	@Column(name = "im")
	private String skype;
	private String phone;
	@ManyToOne
	@JoinColumn(name = "location_fk")
	private Location location_fk;
	private boolean active;
	private Integer reputation;
	private Date hire_date;
	private Date dismissal_date;
	@Column(length = 65535, columnDefinition = "Text")
	private String rm_comment;
	private String workstation;
	private Date probation_till_date;
	private Boolean probation_approved;
	@ManyToOne
	@JoinColumn(name = "unit_fk")
	private Unit unit_fk;
	@ManyToOne
	@JoinColumn(name = "specialization_fk")
	private Specialization specialization_fk;

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Location getLocation_fk() {
		return location_fk;
	}

	public void setLocation_fk(Location location_fk) {
		this.location_fk = location_fk;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Date getDismissal_date() {
		return dismissal_date;
	}

	public void setDismissal_date(Date dismissal_date) {
		this.dismissal_date = dismissal_date;
	}

	public String getRm_comment() {
		return rm_comment;
	}

	public void setRm_comment(String rm_comment) {
		this.rm_comment = rm_comment;
	}

	public String getWorkstation() {
		return workstation;
	}

	public void setWorkstation(String workstation) {
		this.workstation = workstation;
	}

	public Date getProbation_till_date() {
		return probation_till_date;
	}

	public void setProbation_till_date(Date probation_till_date) {
		this.probation_till_date = probation_till_date;
	}

	public Boolean getProbation_approved() {
		return probation_approved;
	}

	public void setProbation_approved(Boolean probation_approved) {
		this.probation_approved = probation_approved;
	}

	public Unit getUnit_fk() {
		return unit_fk;
	}

	public void setUnit_fk(Unit unit_fk) {
		this.unit_fk = unit_fk;
	}

	public Specialization getSpecialization_fk() {
		return specialization_fk;
	}

	public void setSpecialization_fk(Specialization specialization_fk) {
		this.specialization_fk = specialization_fk;
	}

}
