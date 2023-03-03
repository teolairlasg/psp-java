package cf.iesguara.testSpring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cf.iesguara.testSpring.exception.ResourceNotFoundException;
import cf.iesguara.testSpring.model.Aula;
import cf.iesguara.testSpring.repository.AulaRepository;
import cf.iesguara.testSpring.service.AulaService;

@Service
@Component
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
			System.out.println(aulaOpt.get());
			return aulaOpt.get();
		}else {
			throw new ResourceNotFoundException("Aula", "id", idAula);
		}
	}

	@Override
	public Aula guardarAula(Aula aula) {
		System.out.println("Test:"+ aula);
		//modifico el objeto antes de guardarlo
		aula.setCodigo(aula.getCodigo().toUpperCase());
		return aulaRepo.save(aula);
		
	}

	@Override
	public List<Aula> mostrarAulas() {
		
		return aulaRepo.findAll();
	}
	
	

}
