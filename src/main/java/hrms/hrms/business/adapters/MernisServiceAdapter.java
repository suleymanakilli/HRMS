package hrms.hrms.business.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import hrms.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), 
					candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")),
					candidate.getBirthYear());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
