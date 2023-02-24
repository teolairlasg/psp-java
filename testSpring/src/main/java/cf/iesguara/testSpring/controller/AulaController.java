package cf.iesguara.testSpring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ResponseEntity<Aula>(aulaService.mostrarAulaId(idCliente), HttpStatus.OK);
	}
}
