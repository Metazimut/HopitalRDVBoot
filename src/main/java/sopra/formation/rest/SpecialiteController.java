package sopra.formation.rest;

import java.util.List;
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
import sopra.formation.model.Specialite;
import sopra.formation.model.Praticien;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/specialite")
@CrossOrigin("*")
public class SpecialiteController {

	@Autowired
	private ISpecialiteRepository specialiteRepo;
	
	@Autowired
	private ICompteRepository praticienRepo;

	@GetMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public List<Specialite> findAll() {
		
		return specialiteRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite find(@PathVariable Long id) {

		Specialite optSpecialite = specialiteRepo.findById(id).get();

		if (optSpecialite!=null) {
			return optSpecialite;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/praticiens")
	@JsonView(Views.ViewPraticienSpecialite.class)
	public List<Praticien> findAllPraticienBySpecialite(@PathVariable Long id) {

		List<Praticien> praticiens = praticienRepo.findAllBySpecialite(id); 
		
		return praticiens;
	}

	@PostMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite create(@RequestBody Specialite specialite) {
		specialite = specialiteRepo.save(specialite);

		return specialite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite update(@RequestBody Specialite specialite, @PathVariable Long id) {
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		specialite = specialiteRepo.save(specialite);

		return specialite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		specialiteRepo.deleteById(id);
	}
}
