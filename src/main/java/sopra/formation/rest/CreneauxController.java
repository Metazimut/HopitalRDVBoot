package sopra.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Creneaux;
import sopra.formation.model.Views;
import sopra.formation.repository.ICreneauxRepository;

@RestController
@RequestMapping("/creneaux")
@CrossOrigin("*")
public class CreneauxController {

	@Autowired
	private ICreneauxRepository creneauxRepo;
	
	
	@GetMapping("")
	@JsonView(Views.ViewCreneaux.class)
	public List<Creneaux> findAll() {
		return creneauxRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCreneaux.class)
	public Creneaux find(@PathVariable Long id) {

		Optional<Creneaux> optCreneaux = creneauxRepo.findById(id);

		if (optCreneaux.isPresent()) {
			return optCreneaux.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCreneaux.class)
	public Creneaux create(@RequestBody Creneaux creneaux) {
		creneaux = creneauxRepo.save(creneaux);

		return creneaux;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreneaux.class)
	public Creneaux update(@RequestBody Creneaux creneaux, @PathVariable Long id) {
		if (!creneauxRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creneaux = creneauxRepo.save(creneaux);

		return creneaux;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauxRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creneauxRepo.deleteById(id);
	}
}
