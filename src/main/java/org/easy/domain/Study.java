package org.easy.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idstudy")
public class Study implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idstudy;
	private String accessionnumber;
	private String studyid;
	private String studyinstanceuid;
	private String studydescription;
	private Date studydatetime;
	private String referringphysicianname;
	private String studypriorityid;
	private String studystatusid;
	private String additionalpatienthistory;
	private String admittingdiagnosesdescription;
	private Date datecreate;
	private Date datemodify;
	private Patient patient;
	private Collection<Series> series;

	public Study() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdstudy() {
		return idstudy;
	}

	public void setIdstudy(Long idstudy) {
		this.idstudy = idstudy;
	}

	@Column(length = 60)
	public String getStudyid() {
		return studyid;
	}

	public void setStudyid(String studyid) {
		this.studyid = studyid;
	}

	@Column(length = 350)
	public String getStudydescription() {
		return studydescription;
	}

	public void setStudydescription(String studydescription) {
		this.studydescription = studydescription;
	}

	@Column(length = 120)
	public String getStudyinstanceuid() {
		return studyinstanceuid;
	}

	public void setStudyinstanceuid(String studyinstanceuid) {
		this.studyinstanceuid = studyinstanceuid;
	}

	@Column(length = 50)
	public String getAccessionnumber() {
		return accessionnumber;
	}

	public void setAccessionnumber(String accessionnumber) {
		this.accessionnumber = accessionnumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getStudydatetime() {
		return studydatetime;
	}

	public void setStudydatetime(Date studydatetime) {
		this.studydatetime = studydatetime;
	}

	@Column(length = 120)
	public String getReferringphysicianname() {
		return referringphysicianname;
	}

	public void setReferringphysicianname(String referringphysicianname) {
		this.referringphysicianname = referringphysicianname;
	}

	@Column(length = 350)
	public String getAdditionalpatienthistory() {
		return additionalpatienthistory;
	}

	public void setAdditionalpatienthistory(String additionalpatienthistory) {
		this.additionalpatienthistory = additionalpatienthistory;
	}

	@Column(length = 250)
	public String getAdmittingdiagnosesdescription() {
		return admittingdiagnosesdescription;
	}

	public void setAdmittingdiagnosesdescription(String admittingdiagnosesdescription) {
		this.admittingdiagnosesdescription = admittingdiagnosesdescription;
	}

	@Column(length = 80)
	public String getStudystatusid() {
		return studystatusid;
	}

	public void setStudystatusid(String studystatusid) {
		this.studystatusid = studystatusid;
	}

	@Column(length = 80)
	public String getStudypriorityid() {
		return studypriorityid;
	}

	public void setStudypriorityid(String studypriorityid) {
		this.studypriorityid = studypriorityid;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient param) {
		this.patient = param;
	}

	@OneToMany(mappedBy = "study")
	public Collection<Series> getSeries() {
		return series;
	}

	public void setSeries(Collection<Series> param) {
		this.series = param;
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
			"Study[idstudy=%d, accessionnumber=%s, studyid=%s, studyinstanceuid=%s, studydescription=%s, studydatetime=%s, "
			+ "referringphysicianname=%s, studypriorityid=%s, studystatusid=%s, additionalpatienthistory=%s, "
			+ "admittingdiagnosesdescription=%s, datecreate=%s, datemodify=%s]",

			this.idstudy, this.accessionnumber, this.studyid, this.studyinstanceuid, this.studydescription,
			this.studydatetime, this.referringphysicianname, this.studypriorityid, this.studystatusid,
			this.additionalpatienthistory, this.admittingdiagnosesdescription, this.datecreate, this.datemodify
		);
	}

}
