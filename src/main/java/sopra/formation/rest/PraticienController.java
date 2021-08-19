package sopra.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Praticien;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;

@Controller
public class PraticienController {

	@Autowired
	private ICompteRepository praticienRepo;

	@GetMapping("/praticien") // ETAPE 1
	@JsonView(Views.ViewPraticien.class)
	public String list(Model model) {
		// ETAPE 2
		List<Praticien> praticiens = this.praticienRepo.findAllPraticien();

		// ETAPE 3
		model.addAttribute("mesPraticiens", praticiens);

		// ETAPE 4
		return "praticien/list";
	}

	@GetMapping("/praticien/add")
	@JsonView(Views.ViewPraticien.class)
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "praticien/form";
	}

	@GetMapping("/praticien/edit")
	@JsonView(Views.ViewPraticien.class)
	public String edit(@RequestParam("id") Long idPraticien, Model model) {
		// ETAPE 2
		Praticien praticien = praticienRepo.findPraticienById(idPraticien);

		// ETAPE 3
		model.addAttribute("prat", praticien);

		// ETAPE 4
		return "praticien/form";
	}
	
	@PostMapping("/praticien/save")
	@JsonView(Views.ViewPraticien.class)
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String mdp, @RequestParam String lieu) {
		Praticien praticien = new Praticien(id,version, nom, prenom, email, mdp, lieu);
		praticien.setVersion(version);
		
		praticienRepo.save(praticien);
		
		return "redirect:/praticien";
	}

	@GetMapping("/praticien/delete")
	public String delete(@RequestParam Long id) {
		praticienRepo.deleteById(id);
		
		return "redirect:/praticien";
	}
	
	@GetMapping("/praticien/cancel")
	public String cancel() {
		return "forward:/praticien";
	}
}
