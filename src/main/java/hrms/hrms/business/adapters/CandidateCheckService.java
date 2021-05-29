package hrms.hrms.business.adapters;


import hrms.hrms.entities.concretes.Candidate;


public interface CandidateCheckService {
	boolean checkIfRealPerson(Candidate candidate);

}
