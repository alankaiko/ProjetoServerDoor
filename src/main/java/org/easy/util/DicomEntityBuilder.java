package org.easy.util;

import java.util.Date;

import org.easy.domain.Dispositive;
import org.easy.domain.Instance;
import org.easy.domain.Patient;
import org.easy.domain.Series;
import org.easy.domain.Study;




public class DicomEntityBuilder {
	
	public static Patient newPatient(String patientAge, Date patientBirthday, String patientID, String patientName, String patientSex){
		
		Patient patient = new Patient();
		patient.setPatientage(patientAge);
		patient.setBirthday(patientBirthday);
		patient.setPatientid(patientID);
		patient.setPatientname(patientName);
		patient.setPatientsex(patientSex);
		
		return patient;
	}
	
	public static Study newStudy(String accessionNumber, String additionalPatientHistory, String admittingDiagnosesDescription, 
			String referringPhysicianName, Date studyDateTime, String studyID, String studyDescription, String studyInstanceUID,	String studyPriorityID, 
			String studyStatusID){
		
		Study study = new Study();
		study.setAccessionnumber(accessionNumber);
		study.setAdditionalpatienthistory(additionalPatientHistory);
		study.setAdmittingdiagnosesdescription(admittingDiagnosesDescription);		
		study.setReferringphysicianname(referringPhysicianName);
		study.setStudydatetime(studyDateTime);
		study.setStudyid(studyID);
		study.setStudydescription(studyDescription);
		study.setStudyinstanceuid(studyInstanceUID);
		study.setStudypriorityid(studyPriorityID);
		study.setStudystatusid(studyStatusID);
		
		return study;
	}
	
	public static Series newSeries(String bodyPartExamined, String laterality, String operatorsName, String patientPosition, String protocolName, 
			Date seriesDateTime, String seriesDescription, String seriesInstanceUID, Integer seriesNumber){
		
		Series series = new Series();
		series.setBodypartexamined(bodyPartExamined);		
		series.setLaterality(laterality);
		series.setOperatorsname(operatorsName);
		series.setPatientposition(patientPosition);
		series.setProtocolname(protocolName);
		series.setSeriesdatetime(seriesDateTime);
		series.setSeriesdescription(seriesDescription);
		series.setSeriesinstanceuid(seriesInstanceUID);
		series.setSeriesnumber(seriesNumber);
		
		return series;
	}
	
	public static Dispositive newEquipment(String conversionType, String deviceSerialNumber, String institutionAddress, String institutionName, 
			String institutionalDepartmentName, String manufacturer, String manufacturerModelName, String modality, String softwareVersion, 
			String stationName){
		
		Dispositive equipment = new Dispositive();
		equipment.setConversiontype(conversionType);
		equipment.setDeviceserialnumber(deviceSerialNumber);
		equipment.setInstitutionaddress(institutionAddress);
		equipment.setInstitutionname(institutionName);
		equipment.setInstitutionaldepartmentname(institutionalDepartmentName);
		equipment.setManufacturer(manufacturer);
		equipment.setManufacturermodelname(manufacturerModelName);
		equipment.setModality(modality);
		equipment.setSoftwareversion(softwareVersion);
		equipment.setStationname(stationName);
		
		return equipment;
	}
	
	public static Instance newInstance(Date acquisitionDateTime, Date contentDateTime, Integer exposureTime, String imageOrientation, String imagePosition,
			String imageType, Integer instanceNumber, String kvp, String mediaStorageSopInstanceUID, String patientOrientation, Float pixelSpacing,
			Float sliceLocation, Float sliceThickness, String sopClassUID, String sopInstanceUID, String transferSyntaxUID, String windowCenter, 
			String windowWidth, Integer xrayTubeCurrent){
		
		Instance instance = new Instance();
		instance.setAcquisitiondatetime(acquisitionDateTime);
		instance.setContentdatetime(contentDateTime);
		instance.setExposuretime(exposureTime);
		instance.setImageorientation(imageOrientation);
		instance.setImageposition(imagePosition);
		instance.setImagetype(imageType);
		instance.setInstancenumber(instanceNumber);
		instance.setKvp(kvp);
		instance.setMediastoragesopinstanceuid(mediaStorageSopInstanceUID);
		instance.setPatientorientation(patientOrientation);
		instance.setPixelspacing(pixelSpacing);
		instance.setSlicelocation(sliceLocation);
		instance.setSlicethickness(sliceThickness);
		instance.setSopclassuid(sopClassUID);
		instance.setSopinstanceuid(sopInstanceUID);
		instance.setTransfersyntaxuid(transferSyntaxUID);
		instance.setWindowcenter(windowCenter);
		instance.setWindowwidth(windowWidth);
		instance.setXraytubecurrent(xrayTubeCurrent);
		
		return instance;
	}
	
	
}
