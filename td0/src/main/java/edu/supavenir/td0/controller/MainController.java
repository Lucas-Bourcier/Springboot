package edu.supavenir.td0.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.supavenir.td0.models.Elements;

@Controller
@SessionAttributes("items")
public class MainController {
	@ModelAttribute("items")

	public List<Elements> getItems() {
		return new ArrayList<>();
	}

	@GetMapping("items")
	public String itemsAction(ModelMap model) {
		return "index";
	}

	@GetMapping("/testAdd")
	public RedirectView add(@SessionAttribute List<Elements> items) {
		Elements elm = new Elements();
		elm.setNom("bop");
		getItems().add(elm);
		items.add(elm);
		return new RedirectView("items");
	}

	@GetMapping("/items/new")
	public String addNew() {
		return "AddNew";
	}

	@PostMapping("items/new")
	public RedirectView addNew(@RequestParam String nom, @SessionAttribute List<Elements> items) {
		Elements Feca = new Elements();
		Feca.setNom(nom);
		items.add(Feca);
		return new RedirectView("/items/");
	}

	@GetMapping("items/{nom}")
	public String a(@PathVariable String nom, @SessionAttribute List<Elements> items) {
		items.contains(nom);

		return "items";
	}
}