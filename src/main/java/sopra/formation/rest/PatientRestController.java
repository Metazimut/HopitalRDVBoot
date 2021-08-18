package sopra.formation.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Compte;
import sopra.formation.model.Patient;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientRestController {

	@Autowired
	private ICompteRepository patientRepo;

	@GetMapping("")
	@JsonView(Views.ViewPatient.class)
	public List<Compte> findAll() {
		return patientRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient find(@PathVariable Long id) {

		Optional<Compte> optPatient = patientRepo.findById(id);

		if (optPatient.isPresent()) {
			return (Patient) optPatient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPatient.class)
	public Patient create(@Valid @RequestBody Patient patient, BindingResult result) {
//		if(result.hasErrors()) {
//			throw new PatientValidationException();
//		}
		
		patient = patientRepo.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient update(@RequestBody Patient patient, @PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		patient = patientRepo.save(patient);

		return patient;
	}

	@PatchMapping("/{id}")
	public Patient partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
//		if (!patientRepo.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}

		Patient patientFind = (Patient) patientRepo.findById(id).get();

//		if (updates.containsKey("comportemental")) {
//			patientFind.setComportemental((Integer) updates.get("comportemental"));
//		}
//		if (updates.containsKey("technique")) {
//			patientFind.setTechnique((Integer) updates.get("technique"));
//		}
//		if (updates.containsKey("commentaires")) {
//			patientFind.setCommentaires((String) updates.get("commentaires"));
//		}

		patientFind = patientRepo.save(patientFind);

		return patientFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		patientRepo.deleteById(id);
	}
}
