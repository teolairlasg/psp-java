package cf.iesguara.testSpring.service;

import java.util.List;

import cf.iesguara.testSpring.model.Aula;

public interface AulaService {
	public Aula mostrarAulaId(long idAula);
	public Aula guardarAula(Aula aula);
	public List<Aula> mostrarAulas();
}
