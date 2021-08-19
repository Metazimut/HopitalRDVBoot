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

import sopra.formation.model.PraticienSpecialite;
import sopra.formation.model.Views;
import sopra.formation.repository.IPraticienSpecialiteRepository;

@RestController
@RequestMapping("/praticien_specialite")
@CrossOrigin("*")
public class PraticienSpecialiteController {

	@Autowired
	private IPraticienSpecialiteRepository praticienSpecialiteRepo;
	
	
	@GetMapping("")
	@JsonView(Views.ViewPraticienSpecialite.class)
	public List<PraticienSpecialite> findAll() {
		return praticienSpecialiteRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewPraticienSpecialite.class)
	public PraticienSpecialite find(@PathVariable Long id) {

		Optional<PraticienSpecialite> optPraticienSpecialite = praticienSpecialiteRepo.findById(id);

		if (optPraticienSpecialite.isPresent()) {
			return optPraticienSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewPraticienSpecialite.class)
	public PraticienSpecialite create(@RequestBody PraticienSpecialite praticienSpecialite) {
		praticienSpecialite = praticienSpecialiteRepo.save(praticienSpecialite);

		return praticienSpecialite;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewPraticien.class)
	public PraticienSpecialite update(@RequestBody PraticienSpecialite praticienSpecialite, @PathVariable Long id) {
		if (!praticienSpecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		praticienSpecialite = praticienSpecialiteRepo.save(praticienSpecialite);

		return praticienSpecialite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!praticienSpecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		praticienSpecialiteRepo.deleteById(id);
	}
	
	
}
