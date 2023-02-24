package cf.iesguara.testSpring.service.impl;

import java.util.Optional;

import cf.iesguara.testSpring.exception.ResourceNotFoundException;
import cf.iesguara.testSpring.model.Aula;
import cf.iesguara.testSpring.repository.AulaRepository;
import cf.iesguara.testSpring.service.AulaService;

public class AulaServiceImpl implements AulaService {

	private AulaRepository aulaRepo;
	
	public AulaServiceImpl(AulaRepository aulaRepo) {
		super();
		this.aulaRepo = aulaRepo;
	}

	@Override
	public Aula mostrarAulaId(long idAula) {
		Optional<Aula> aulaOpt = aulaRepo.findById(idAula);
		if(aulaOpt.isPresent()) {
			return aulaOpt.get();
		}else {
			throw new ResourceNotFoundException("Aula", "id", idAula);
		}
	}

}
