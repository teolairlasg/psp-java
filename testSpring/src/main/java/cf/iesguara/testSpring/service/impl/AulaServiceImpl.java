package cf.iesguara.testSpring.service.impl;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> ce8e639 (uploading local changes)

import cf.iesguara.testSpring.exception.ResourceNotFoundException;
import cf.iesguara.testSpring.model.Aula;
import cf.iesguara.testSpring.repository.AulaRepository;
import cf.iesguara.testSpring.service.AulaService;

<<<<<<< HEAD
@Service
=======
>>>>>>> ce8e639 (uploading local changes)
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
<<<<<<< HEAD
		if(aulaOpt.isPresent()) {
			System.out.println(aulaOpt.get());
=======
		if (!aulaOpt.isEmpty()) {
>>>>>>> ce8e639 (uploading local changes)
			return aulaOpt.get();
		} else {
			throw new ResourceNotFoundException("Aula", "id", idAula);
		}
	}

	@Override
<<<<<<< HEAD
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
	
	

=======
	public Aula guardarAula(Aula a) {

		return aulaRepo.save(a);
	}
>>>>>>> ce8e639 (uploading local changes)
}
