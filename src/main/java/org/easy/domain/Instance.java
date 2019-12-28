package org.easy.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Instance implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idinstance;
	private Integer instancenumber;
	private String patientorientation;
	private String mediastoragesopinstanceuid;
	private String sopinstanceuid;
	private String sopclassuid;
	private String transfersyntaxuid;
	private Date acquisitiondatetime;
	private String imagetype;
	private Float pixelspacing;
	private String imageorientation;
	private Integer xraytubecurrent;
	private Integer exposuretime;
	private String kvp;
	private Float slicelocation;
	private Float slicethickness;
	private String imageposition;
	private String windowcenter;
	private String windowwidth;
	private Date contentdatetime;
	private Date datecreate;
	private Date datemodify;
	private Series series;

	public Instance() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdinstance() {
		return idinstance;
	}

	public void setIdinstance(Long idinstance) {
		this.idinstance = idinstance;
	}

	public Integer getInstancenumber() {
		return instancenumber;
	}

	public void setInstancenumber(Integer instancenumber) {
		this.instancenumber = instancenumber;
	}

	@Column(length = 50)
	public String getPatientorientation() {
		return patientorientation;
	}

	public void setPatientorientation(String patientorientation) {
		this.patientorientation = patientorientation;
	}

	@Column(length = 110)
	public String getMediastoragesopinstanceuid() {
		return mediastoragesopinstanceuid;
	}

	public void setMediastoragesopinstanceuid(String mediastoragesopinstanceuid) {
		this.mediastoragesopinstanceuid = mediastoragesopinstanceuid;
	}

	@Column(length = 110)
	public String getSopinstanceuid() {
		return sopinstanceuid;
	}

	public void setSopinstanceuid(String sopinstanceuid) {
		this.sopinstanceuid = sopinstanceuid;
	}

	@Column(length = 110)
	public String getSopclassuid() {
		return sopclassuid;
	}

	public void setSopclassuid(String sopclassuid) {
		this.sopclassuid = sopclassuid;
	}

	@Column(length = 110)
	public String getTransfersyntaxuid() {
		return transfersyntaxuid;
	}

	public void setTransfersyntaxuid(String transfersyntaxuid) {
		this.transfersyntaxuid = transfersyntaxuid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getAcquisitiondatetime() {
		return acquisitiondatetime;
	}

	public void setAcquisitiondatetime(Date acquisitiondatetime) {
		this.acquisitiondatetime = acquisitiondatetime;
	}

	@Column(length = 60)
	public String getImagetype() {
		return imagetype;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public Float getPixelspacing() {
		return pixelspacing;
	}

	public void setPixelspacing(Float pixelspacing) {
		this.pixelspacing = pixelspacing;
	}

	@Column(length = 60)
	public String getImageorientation() {
		return imageorientation;
	}

	public void setImageorientation(String imageorientation) {
		this.imageorientation = imageorientation;
	}

	public Integer getXraytubecurrent() {
		return xraytubecurrent;
	}

	public void setXraytubecurrent(Integer xraytubecurrent) {
		this.xraytubecurrent = xraytubecurrent;
	}

	public Integer getExposuretime() {
		return exposuretime;
	}

	public void setExposuretime(Integer exposuretime) {
		this.exposuretime = exposuretime;
	}

	@Column(length = 60)
	public String getKvp() {
		return kvp;
	}

	public void setKvp(String kvp) {
		this.kvp = kvp;
	}

	public Float getSlicelocation() {
		return slicelocation;
	}

	public void setSlicelocation(Float slicelocation) {
		this.slicelocation = slicelocation;
	}

	public Float getSlicethickness() {
		return slicethickness;
	}

	public void setSlicethickness(Float slicethickness) {
		this.slicethickness = slicethickness;
	}

	@Column(length = 100)
	public String getImageposition() {
		return imageposition;
	}

	public void setImageposition(String imageposition) {
		this.imageposition = imageposition;
	}

	@Column(length = 70)
	public String getWindowcenter() {
		return windowcenter;
	}

	public void setWindowcenter(String windowcenter) {
		this.windowcenter = windowcenter;
	}

	@Column(length = 70)
	public String getWindowwidth() {
		return windowwidth;
	}

	public void setWindowwidth(String windowwidth) {
		this.windowwidth = windowwidth;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getContentdatetime() {
		return contentdatetime;
	}

	public void setContentdatetime(Date contentdatetime) {
		this.contentdatetime = contentdatetime;
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
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series param) {
		this.series = param;
	}

	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		datemodify = new Date();

		if (datecreate == null)
			datecreate = new Date();
	}

}
