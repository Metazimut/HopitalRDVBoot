package sopra.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Admin;
import sopra.formation.repository.ICompteRepository;

@Controller
public class AdminController {

	@Autowired
	private ICompteRepository adminRepo;

	@GetMapping("/admin") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<Admin> admins = this.adminRepo.findAllAdmin();

		// ETAPE 3
		model.addAttribute("mesAdmins", admins);

		// ETAPE 4
		return "admin/list";
	}

	@GetMapping("/admin/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "admin/form";
	}

	@GetMapping("/admin/edit")
	public String edit(@RequestParam("id") Long idAdmin, Model model) {
		// ETAPE 2
		Admin admin = adminRepo.findAdminById(idAdmin);

		// ETAPE 3
		model.addAttribute("prat", admin);

		// ETAPE 4
		return "admin/form";
	}
	
	@PostMapping("/admin/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String mdp) {
		Admin admin = new Admin(id,version, nom, prenom, email, mdp);
		admin.setVersion(version);
		
		adminRepo.save(admin);
		
		return "redirect:/admin";
	}

	@GetMapping("/admin/delete")
	public String delete(@RequestParam Long id) {
		adminRepo.deleteById(id);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/cancel")
	public String cancel() {
		return "forward:/admin";
	}
}
