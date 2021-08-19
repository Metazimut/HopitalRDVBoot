package sopra.formation.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Patient;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;


@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

	@Autowired
	private ICompteRepository patientRepo;

	@GetMapping("")
	@JsonView(Views.ViewPatient.class)
	public List<Patient> findAll() {
		return patientRepo.findAllPatient();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient find(@PathVariable Long id) {

		Optional<Patient> optPatient = patientRepo.findPatientById(id);

		if (optPatient.isPresent()) {
			return optPatient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPatient.class)
	public Patient create( @RequestBody Patient patient){
		
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
	@JsonView(Views.ViewPatient.class)
	public Patient partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Patient patientFind = patientRepo.findPatientById(id).get();

		if (updates.containsKey("nom")) {
			patientFind.setNom((String) updates.get("nom"));
		}
		if (updates.containsKey("prenom")) {
			patientFind.setPrenom((String) updates.get("prenom"));
		}
		

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
