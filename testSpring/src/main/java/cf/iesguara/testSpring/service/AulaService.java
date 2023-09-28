package cf.iesguara.testSpring.service;

<<<<<<< HEAD
import java.util.List;

import cf.iesguara.testSpring.model.Aula;
=======
import org.springframework.stereotype.Service;
>>>>>>> ce8e639 (uploading local changes)

import cf.iesguara.testSpring.model.Aula;
@Service
public interface AulaService {
	public Aula mostrarAulaId(long idAula);
<<<<<<< HEAD
	public Aula guardarAula(Aula aula);
	public List<Aula> mostrarAulas();
=======
	public Aula guardarAula(Aula a);
>>>>>>> ce8e639 (uploading local changes)
}
