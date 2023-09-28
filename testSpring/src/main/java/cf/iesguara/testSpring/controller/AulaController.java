package cf.iesguara.testSpring.controller;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> ce8e639 (uploading local changes)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.testSpring.model.Aula;
import cf.iesguara.testSpring.service.AulaService;

@RestController
@RequestMapping("/aulas")

public class AulaController {
	private AulaService aulaService;
	
	
	public AulaController(AulaService aulaService) {
		super();
		this.aulaService = aulaService;
	}
	
	// GET /aulas/23  <-- 23 sería un ejemplo de id
	@GetMapping("{id}")
	public ResponseEntity<Aula> mostrarAula(@PathVariable("id") long idCliente){
<<<<<<< HEAD
		return new ResponseEntity<Aula>(aulaService.mostrarAulaId(idCliente), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Aula> guardarAula(@RequestBody Aula aula){
		//No le paso directamente el aula que me llega en el cuerpo de la petición
		//si no que con ese aula llamo al servicio, que llamará al repositorio
		//y luego devolverá el objeto recién guardado
		return new ResponseEntity<Aula>(aulaService.guardarAula(aula), HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<Aula>> mostrarAulas(){
		return new ResponseEntity<List<Aula>>(aulaService.mostrarAulas(),HttpStatus.OK);
=======
		Aula a = new Aula();
		a.getNombre();
		return new ResponseEntity<Aula>(aulaService.mostrarAulaId(idCliente), HttpStatus.OK);
>>>>>>> ce8e639 (uploading local changes)
	}
	
	@PostMapping("add")
	public ResponseEntity<Aula> guardarAula(@RequestBody Aula a){
		return new ResponseEntity<Aula>(aulaService.guardarAula(a), HttpStatus.CREATED);
	}
}
