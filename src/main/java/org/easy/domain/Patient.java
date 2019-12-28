package org.easy.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idpatient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idpatient;
	private String patientid;
	private String patientname;
	private Date birthday;
	private String patientage;
	private String patientsex;
	private Date datecreate;
	private Date datemodify;
	private Collection<Study> studyes;

	public Patient() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(Long idpatient) {
		this.idpatient = idpatient;
	}

	@Column(length = 100)
	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	@Column(length = 100)
	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	@Column(length = 10)
	public String getPatientsex() {
		return patientsex;
	}

	public void setPatientsex(String patientsex) {
		this.patientsex = patientsex;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(length = 10)
	public String getPatientage() {
		return patientage;
	}

	public void setPatientage(String patientage) {
		this.patientage = patientage;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatemodify() {
		return datemodify;
	}

	public void setDatemodify(Date datemodify) {
		this.datemodify = datemodify;
	}

	@OneToMany(mappedBy = "patient")
	public Collection<Study> getStudyes() {
		return studyes;
	}

	public void setStudyes(Collection<Study> studyes) {
		this.studyes = studyes;
	}

	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		datemodify = new Date();

		if (datecreate == null)
			datecreate = new Date();
	}

	@Override
	public String toString() {
		return String.format(
			"Patient[idpatient=%d, patientid=%s, patientname=%s, birthday=%s, "
			+ "patientage=%s, patientsex=%s, datecreate=%s, datemodify=%s]",

			this.idpatient, this.patientid, this.patientname, this.birthday, this.patientage, 
			this.patientsex, this.datecreate, this.datemodify
		);
	}

}
