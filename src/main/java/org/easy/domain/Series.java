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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idseries")
public class Series implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idseries;
	private String seriesinstanceuid;
	private String seriesdescription;
	private Integer seriesnumber;
	private String patientposition;
	private String bodypartexamined;
	private String laterality;
	private String operatorsname;
	private String protocolname;
	private Date seriesdatetime;
	private Date datecreate;
	private Date datemodify;
	private Study study;
	private Collection<Instance> instance;
	private Dispositive dispotive;

	public Series() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdseries() {
		return idseries;
	}

	public void setIdseries(Long idseries) {
		this.idseries = idseries;
	}

	@Column(length = 100)
	public String getSeriesinstanceuid() {
		return seriesinstanceuid;
	}

	public void setSeriesinstanceuid(String seriesinstanceuid) {
		this.seriesinstanceuid = seriesinstanceuid;
	}

	@Column(length = 100)
	public String getSeriesdescription() {
		return seriesdescription;
	}

	public void setSeriesdescription(String seriesdescription) {
		this.seriesdescription = seriesdescription;
	}

	public Integer getSeriesnumber() {
		return seriesnumber;
	}

	public void setSeriesnumber(Integer seriesnumber) {
		this.seriesnumber = seriesnumber;
	}

	@Column(length = 30)
	public String getPatientposition() {
		return patientposition;
	}

	public void setPatientposition(String patientposition) {
		this.patientposition = patientposition;
	}

	@Column(length = 100)
	public String getBodypartexamined() {
		return bodypartexamined;
	}

	public void setBodypartexamined(String bodypartexamined) {
		this.bodypartexamined = bodypartexamined;
	}

	@Column(length = 40)
	public String getLaterality() {
		return laterality;
	}

	public void setLaterality(String laterality) {
		this.laterality = laterality;
	}

	@Column(length = 50)
	public String getOperatorsname() {
		return operatorsname;
	}

	public void setOperatorsname(String operatorsname) {
		this.operatorsname = operatorsname;
	}

	@Column(length = 100)
	public String getProtocolname() {
		return protocolname;
	}

	public void setProtocolname(String protocolname) {
		this.protocolname = protocolname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getSeriesdatetime() {
		return seriesdatetime;
	}

	public void setSeriesdatetime(Date seriesdatetime) {
		this.seriesdatetime = seriesdatetime;
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
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	@OneToMany(mappedBy = "series")
	public Collection<Instance> getInstance() {
		return instance;
	}

	public void setInstance(Collection<Instance> instance) {
		this.instance = instance;
	}

	@OneToOne(mappedBy = "series")
	public Dispositive getDispotive() {
		return dispotive;
	}

	public void setDispotive(Dispositive dispotive) {
		this.dispotive = dispotive;
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
			"Series[idseries=%d, seriesinstanceuid=%s, seriesdescription=%d, seriesnumber=%s, patientposition=%s, "
			+ "bodypartexamined=%s, laterality=%s, operatorsname=%s, protocolname=%s, seriesdatetime=%s, "
			+ "datecreate=%s, datemodify=%s]",
			
			this.idseries, this.seriesinstanceuid, this.seriesdescription, this.seriesnumber, this.patientposition, 
			this.bodypartexamined, this.laterality, this.operatorsname, this.protocolname, this.seriesdatetime, 
			this.datecreate, this.datemodify
		);
	}
	

}
