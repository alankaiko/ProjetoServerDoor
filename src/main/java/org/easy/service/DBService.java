package org.easy.service;

import org.easy.domain.Dispositive;
import org.easy.domain.Instance;
import org.easy.domain.Patient;
import org.easy.domain.Series;
import org.easy.domain.Study;
import org.easy.server.DicomReader;


public interface DBService {

	public void buildEntities(DicomReader reader);
	Patient buildPatient(DicomReader reader);
	Study buildStudy(DicomReader reader,Patient patient);
	Series buildSeries(DicomReader reader, Study study);
	Dispositive buildEquipment(DicomReader reader, Series series);
	Instance buildInstance(DicomReader reader, Series series);
}
