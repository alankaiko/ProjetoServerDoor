$(document).ready(function(){	
	initTree();
	initFancyBox();
	initTab();	
	countImages();
	
});//ready

function initFancyBox()
{
	$('.fancybox-images')
	.attr('rel', 'image-gallery')
	.fancybox({
		prevEffect : 'elastic',
		nextEffect : 'elastic',
		closeEffect : 'elastic',
		closeClick : true,
		closeBtn  : true,
		arrows    : true,
		nextClick : false,			
		width: 520,
		height: 900,
		autoWidth: true,
		autoHeight: true,
		autoResize: true,
		autoCenter: true,
		scrolling: 'no',
		scrollOutside: false,
		
		iframe: {
			scrolling : 'auto',
			preload   : true
		},

		helpers : {
			thumbs : {
				width  : 70,
				height : 50
			}
		}
	});
}

function initTab(){
	$( "#tabs" ).tabs();
}

function initTree(){
	//$('#jstree').jstree();
	
	$('#jstree').jstree({
		  "core" : {
			  	'plugins': ["wholerow"],
    			'themes': {
    				'name': 'proton',
    				'responsive': true
    			}
		  }
		});
}

function buildPatient(patient){
	
	return  "<table class='table table-striped  table-condensed fixed-header'>" +
			"<caption>Patient</caption>" +
			"<tbody>" +
			"<tr><td>Patient Name</td><td>" + (patient.patientname==null?'':patient.patientname) + "</td></tr>" +
			"<tr><td>Patient ID</td><td>" + (patient.patientid==null?'':patient.patientid) + "</td></tr>" +
			"<tr><td>Patient Sex</td><td>" + (patient.patientsex==null?'':patient.patientsex) + "</td></tr>" +
			"<tr><td>Patient Age</td><td>" + (patient.patientage==null?'':patient.patientage) + "</td></tr>" +
			"</tbody>" +
			"</table>";
}

function buildStudy(study){
	
	return "<table class='table table-striped  table-condensed fixed-header'>" +
			"<caption>Study</caption>" +
			"<tbody>" +
			"<tr><td>Study Description</td><td>" + (study.studydescription==null?'':study.studydescription) + "</td></tr>" +	  						
			"<tr><td>Accession Number</td><td>" + (study.accessionnumber==null?'':study.accessionnumber) + "</td></tr>" +
			"<tr><td>Study Instance UID</td><td>" + (study.studyinstanceuid==null?'':study.studyinstanceuid) + "</td></tr>" +
			"<tr><td>Study ID</td><td>" + (study.studyid==null?'':study.studyid) + "</td></tr>" +
			"<tr><td>Study Date Time</td><td>" + (study.studydatetime==null?'':new Date(study.studydatetime * 1000)) + "</td></tr>" +
			"<tr><td>Study Priority ID</td><td>" + (study.studypriorityid==null?'':study.studypriorityid) + "</td></tr>" +
			"<tr><td>Study Status ID</td><td>" + (study.studystatusid==null?'':study.studystatusid) + "</td></tr>" +
			"<tr><td>Referring Physician Name</td><td>" + (study.referringphysicianname==null?'':study.referringphysicianname) + "</td></tr>" +
			"<tr><td>Additional Patient History</td><td>" + (study.additionalpatienthistory==null?'':study.additionalpatienthistory) + "</td></tr>" +
			"<tr><td>Admitting Diagnoses Description</td><td>" + (study.admittingdiagnosesdescription==null?'':study.admittingdiagnosesdescription) + "</td></tr>" +	  						
			"</tbody>" +
			"</table>";
}

function buildSeries(series){
	
	return "<table class='table table-striped  table-condensed fixed-header'>" +
			"<caption>Series</caption>" +
			"<tbody>" +
			"<tr><td>Series Description</td><td>" + (series.seriesdescription==null?'':series.seriesdescription) + "</td></tr>" +	  						
			"<tr><td>Body Part Examined</td><td>" + (series.bodypartexamined==null?'':series.bodypartexamined) + "</td></tr>" +
			"<tr><td>Series Number</td><td>" + (series.seriesnumber==null?'':series.seriesnumber) + "</td></tr>" +
			"<tr><td>Series Instance UID</td><td>" + (series.seriesinstanceuid==null?'':series.seriesinstanceuid) + "</td></tr>" +	  						
			"<tr><td>Series Date Time</td><td>" + (series.seriesdatetime==null?'':series.seriesdatetime) + "</td></tr>" +
			"<tr><td>Operators Name</td><td>" + (series.operatorsname==null?'':series.operatorsname) + "</td></tr>" +
			"<tr><td>Protocol Name</td><td>" + (series.protocolname==null?'':series.protocolname) + "</td></tr>" +
			"<tr><td>Laterality</td><td>" + (series.laterality==null?'':series.laterality) + "</td></tr>" +
			"<tr><td>Patient Position</td><td>" + (series.patientposition==null?'':series.patientposition) + "</td></tr>" +	  							  						
			"</tbody>" +
			"</table>";
}

function buildEquipment(series){
	
	return "<table class='table table-striped  table-condensed fixed-header'>" +
			"<caption>dispositive</caption>" +
			"<tbody>" +
			"<tr><td>Institution Name</td><td>" + (series.dispositive.institutionname==null?'':series.dispositive.institutionname) + "</td></tr>" +
			"<tr><td>Institutional Department Name</td>" + (series.dispositive.institutionaldepartmentname==null?'':series.dispositive.institutionaldepartmentname)  + "<td></td></tr>" +
			"<tr><td>Institution Address</td><td>" + (series.dispositive.institutionaladdress==null?'':series.dispositive.institutionaladdress) + "</td></tr>" +
			"<tr><td>Manufacturer</td><td>" + (series.dispositive.manufacturer==null?'':series.dispositive.manufacturer) + "</td></tr>" +
			"<tr><td>Manufacturer Model Name</td><td>" + (series.dispositive.manufacturermodelname==null?'':series.dispositive.manufacturermodelname) + "</td></tr>" +
			"<tr><td>Modality</td><td>" + (series.dispositive.modality==null?'':series.dispositive.modality) + "</td></tr>" +
			"<tr><td>Software Version</td><td>" + (series.dispositive.softwareversion==null?'':series.dispositive.softwareversion) + "</td></tr>" +
			"<tr><td>Station Name</td><td>" + (series.dispositive.stationname==null?'':series.dispositive.stationname) + "</td></tr>" +
			"<tr><td>Device Serial Number</td><td>" + (series.dispositive.deviceserialnumber==null?'':series.dispositive.deviceserialnumber) + "</td></tr>" +
			"<tr><td>Conversion Type</td><td>" + (series.dispositive.conversiontype==null?'':series.dispositive.conversiontype) + "</td></tr>" +
			"</tbody>" +
			"</table>";
}

function buildInstance(instance){
	
	return "<table class='table table-striped  table-condensed fixed-header'>" +
			"<caption>Instance</caption>" +
			"<tbody>" +
			"<tr><td>Instance Number</td><td>" + (instance.instancenumber==null?'':instance.instancenumber) + "</td></tr>" +	  						
			"<tr><td>SOP Instance UID</td><td>" + (instance.sopinstanceuid==null?'':instance.sopinstanceuid) + "</td></tr>" +
			"<tr><td>Media Storage SOP Instance UID</td><td>" + (instance.mediastoragesopinstanceuid==null?'':instance.mediastoragesopinstanceuid) + "</td></tr>" +
			"<tr><td>SOP Class UID</td><td>" + (instance.sopclassuid==null?'':instance.sopclassuid) + "</td></tr>" +	  						
			"<tr><td>KVP</td><td>" + (instance.kvp==null?'':instance.kvp) + "</td></tr>" +
			"<tr><td>Exposure Time</td><td>" + (instance.exposuretime==null?'':instance.exposuretime) + "</td></tr>" +
			"<tr><td>Image Orientation</td><td>" + (instance.imageorientation==null?'':instance.imageorientation) + "</td></tr>" +
			"<tr><td>Image Type</td><td>" + (instance.imagetype==null?'':instance.imagetype) + "</td></tr>" +
			"<tr><td>Image Position</td><td>" + (instance.imageposition==null?'':instance.imageposition) + "</td></tr>" +
			
			"<tr><td>Content Date Time</td><td>" + (instance.contentdatetime==null?'': new Date(instance.contentdatetime * 1000)) + "</td></tr>" +
			"<tr><td>Acquisition Date Time</td><td>" + (instance.acquisitiondatetime==null?'': new Date(instance.acquisitiondatetime * 1000)) + "</td></tr>" +
			"<tr><td>Patient Orientation</td><td>" + (instance.patientorientation==null?'':instance.patientorientation) + "</td></tr>" +
			"<tr><td>Pixel Spacing</td><td>" + (instance.pixelspacing==null?'':instance.pixelspacing) + "</td></tr>" +
			"<tr><td>Slice Location</td><td>" + (instance.slicelocation==null?'':instance.slicelocation) + "</td></tr>" +
			"<tr><td>Slice Thickness</td><td>" + (instance.slicethickness==null?'':instance.slicethickness) + "</td></tr>" +
			"<tr><td>Transfer Syntax UID</td><td>" + (instance.transfersyntaxuid==null?'':instance.transfersyntaxuid)+ "</td></tr>" +
			"<tr><td>Window Center</td><td>" + (instance.windowcenter==null?'':instance.windowcenter) + "</td></tr>" +
			"<tr><td>Window Width</td><td>" + (instance.windowwidth==null?'':instance.windowwidth)+ "</td></tr>" +
			"<tr><td>Xray Tube Current</td><td>" + (instance.xraytubecurrent==null?'':instance.xraytubecurrent) + "</td></tr>" +	  						
			"</tbody>" +
			"</table>";
}



function getStudy(idstudy){	
		
	var info = encodeURI("idstudy="+idstudy);
	var uri = encodeURI(contextPath+"study");
	
	$("#divStudy").html("<img src='img/ajax-loader.gif' />");
	
	  $.ajax({
	  		type: "GET",
	  		url: uri,
	  		data: info,  		
	  		success: function(data){
				
	  			if(data.success){	  				
	  				$("#divStudy").html(buildStudy(data.study));//fill study
	  				getPatient(data.study.patient.idpatient);//get the parent patient
	  			}
	  		}
		});  
}

function getSeries(idseries){	
		
	var info = encodeURI("idseries="+idseries);
	var uri = encodeURI(contextPath+"series");
	
	$("#divSeries").html("<img src='img/ajax-loader.gif' />");
	
	  $.ajax({
	  		type: "GET",
	  		url: uri,
	  		data: info,  		
	  		success: function(data){
				
	  			if(data.success){	  				
	  				$("#divSeries").html(buildSeries(data.series));//fill Series	  				
	  				$("#divEquipment").html(buildEquipment(data.series));//fill the equipment	  				
	  				getStudy(data.series.study.idstudy);//get the parent study
	  				getPatient(data.series.study.patient.idpatient);//get the parent of parent patient
	  			}
	  		}
		});  
}

function getInstance(idinstance){
		
	var info = encodeURI("idinstance="+idinstance);
	var uri = encodeURI(contextPath+"instance");
	
	$("#divInstance").html("<img src='img/ajax-loader.gif' />");
	
	  $.ajax({
	  		type: "GET",
	  		url: uri,
	  		data: info,  		
	  		success: function(data){
				
	  			if(data.success){	  				
	  				$("#divInstance").html(buildInstance(data.instance));//fill instance	  				
	  				getSeries(data.instance.series.idseries);//get parent series
	  				getStudy(data.instance.series.study.idstudy);//get the parent of parent study
	  			}
	  		}
	  });
}

function getPatient(idpatient){
	
	var info = encodeURI("idpatient="+idpatient);
	var uri = encodeURI(contextPath+"patient");
	
	$("#divPatient").html("<img src='img/ajax-loader.gif' />");
	
	$.ajax({
	  		type: "GET",
	  		url: uri,
	  		data: info,  		
	  		success: function(data){
				
	  			if(data.success){	  				
	  				$("#divPatient").html(buildPatient(data.patient));//fill patient
	  			}
	  		}
	  });	
}

//get total num of images for this patient
function countImages(){
	
	var idpatient = purl().param('idpatient');
	var info = encodeURI("idpatient="+idpatient);
	var uri = encodeURI(contextPath+"patient");
		
	$.ajax({
	  		type: "GET",
	  		url: uri,
	  		data: info,  		
	  		success: function(data){
				
	  			if(data.success){	  					  				
	  				var numOfImages = 0;	  				
	  				$.each( data.patient.study, function(indexOfStudy, study){//iterate each study	
	  					$.each(study.series, function(indexOfSeries, series){//iterate each series				
	  						$.each(series.instance, function(indexOfInstance, instance){//iterate each instance
	  							numOfImages++;
	  						});
	  					});
	  				});
	  				
	  				$("#divImageCount").html("<h3 class='panel-title'>Entities (" + numOfImages + " images)</h3>" );
	  			}
	  		}
	  });
	
}