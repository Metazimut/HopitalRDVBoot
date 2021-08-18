package sopra.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Rdv;
import sopra.formation.repository.IRdvRepository;


@Controller
public class RdvController {

	@Autowired
	private IRdvRepository rdvRepo;

	@GetMapping("/rdv")
	public String list(Model model) {
		
		List<Rdv> rdvs = this.rdvRepo.findAll();

		model.addAttribute("mesRdvs", rdvs);

		return "rdv/list";
	}

	@GetMapping("/rdv/add")
	public String add() {

		return "rdv/form";
	}

	@GetMapping("/rdv/edit")
	public String edit(@RequestParam("id") Long idRdv, Model model) {

		Rdv rdv = rdvRepo.findById(idRdv).get();

		model.addAttribute("rdv", rdv);

		return "rdv/form";
	}
	
//	@PostMapping("/rdv/save")
//	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam String lieu, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dtRdv, @RequestParam Status status) {
//		Rdv rdv = new Rdv(id, lieu, dtRdv, status);
//		
//		rdv.setVersion(version);
//		
//		rdvRepo.save(rdv);
//		
//		return "redirect:/rdv";
//	}

	@GetMapping("/rdv/delete")
	public String delete(@RequestParam Long id) {
		rdvRepo.deleteById(id);
		
		return "redirect:/rdv";
	}
	
	@GetMapping("/rdv/cancel")
	public String cancel() {
		return "forward:/rdv";
	}
	
	
}
