package br.una.prova.controller;

import br.una.prova.entity.Filme;
import br.una.prova.repository.FilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.Valid;

@Controller
public class FilmeController {
	
	@Autowired
    private FilmeRepository filmeRepository;
	
    @GetMapping("/")
    public String list(Model model) {
    	model.addAttribute("filme", new Filme());
        model.addAttribute("filmes", filmeRepository.findAll());
        model.addAttribute("data", getAno());
        return "filme/listar";
    }
    
    private String getAno() {
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		return DateFormat.format(cal.getTime());
	}

	@GetMapping("/novo/{id}")
    public String novo(Model model) {
    	Filme filme = new Filme();
        model.addAttribute("filme", filme);
        return "filme/formulario";
    }
	@GetMapping("/buscar")
	public String buscarnotaImdb(Model model){
		model.addAttribute("filme", new Filme());
		model.addAttribute("filmes", filmeRepository.findByNotaImdbGreaterThan(5));
		model.addAttribute("data", getAno());
		return "filme/listar";
	}
    
    @GetMapping("/editar/{id}")
    public String edit(Model model, @PathVariable Integer id) {
    	model.addAttribute("filme", filmeRepository.findOne(id));
        model.addAttribute("filmes", filmeRepository.findAll());
        return "filme/formulario";
    }
    
    
    @GetMapping("/excluir/{id}")
    public String delete(@PathVariable Integer id) {
        filmeRepository.delete(id);
        return "redirect:/";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Filme filme, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	return "filme/formulario";
        }
        filmeRepository.save(filme);
        return "redirect:/";
    }

}
