package sopra.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Motif;
import sopra.formation.repository.IMotifRepository;


@Controller
public class MotifController {

	@Autowired
	private IMotifRepository motifRepo;
	
	@GetMapping("/motif")
	public String list(Model model) {

		List<Motif> motifs = this.motifRepo.findAll();

		model.addAttribute("mesMotifs", motifs);

		return "motif/list";
	}

	@GetMapping("/motif/add")
	public String add() {

		return "motif/form";
	}

	@GetMapping("/motif/edit")
	public String edit(@RequestParam("id") Long idMotif, Model model) {
		Motif motif = motifRepo.findById(idMotif).get();

		model.addAttribute("motif", motif);

		return "motif/form";
	}

	@PostMapping("/motif/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam String libelle, @RequestParam Integer duree) {
		Motif motif = new Motif(id, libelle, duree);

		motif.setVersion(version);
		
		motifRepo.save(motif);
		
		return "redirect:/motif";
	}

	@GetMapping("/motif/delete")
	public String delete(@RequestParam Long id) {
		
		motifRepo.deleteById(id);

		return "redirect:/motif";
	}

	@GetMapping("/motif/cancel")
	public String cancel() {
		return "forward:/motif";
	}


}
