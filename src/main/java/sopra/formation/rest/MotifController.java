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

import sopra.formation.model.Motif;
import sopra.formation.model.Views;
import sopra.formation.repository.IMotifRepository;
import sopra.formation.rest.exception.MotifValidationException;

@RestController
@RequestMapping("/motif")
@CrossOrigin("*")
public class MotifController {

	@Autowired
	private IMotifRepository motifRepo;

	@GetMapping("")
	@JsonView(Views.ViewMotif.class)
	public List<Motif> findAll() {
		return motifRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif find(@PathVariable Long id) {

		Optional<Motif> optMotif = motifRepo.findById(id);

		if (optMotif.isPresent()) {
			return optMotif.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewMotif.class)
	public Motif create(@Valid @RequestBody Motif motif, BindingResult result) {
		if(result.hasErrors()) {
			throw new MotifValidationException();
		}
		
		motif = motifRepo.save(motif);

		return motif;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif update(@RequestBody Motif motif, @PathVariable Long id) {
		if (!motifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		motif = motifRepo.save(motif);

		return motif;
	}

	@PatchMapping("/{id}")
	public Motif partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!motifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
//
		Motif motifFind = motifRepo.findById(id).get();
//
//		if (updates.containsKey("comportemental")) {
//			motifFind.setComportemental((Integer) updates.get("comportemental"));
//		}
//		if (updates.containsKey("technique")) {
//			motifFind.setTechnique((Integer) updates.get("technique"));
//		}
//		if (updates.containsKey("commentaires")) {
//			motifFind.setCommentaires((String) updates.get("commentaires"));
//		}
//
//		motifFind = motifRepo.save(motifFind);

		return motifFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!motifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		motifRepo.deleteById(id);
	}
}
