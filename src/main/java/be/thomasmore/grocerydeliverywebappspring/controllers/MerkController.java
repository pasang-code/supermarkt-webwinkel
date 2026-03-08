package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Merk;
import be.thomasmore.grocerydeliverywebappspring.repositories.MerkRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MerkController {

    private final MerkRepository merkRepository;

    public MerkController(MerkRepository merkRepository) {
        this.merkRepository = merkRepository;
    }

    @GetMapping("/merkDetails/{id}")
    public String merk(Model model, @PathVariable(required = false) Integer id){
        Optional<Merk> merk = merkRepository.findById(id);

        if (merk.isPresent()) model.addAttribute("merk",merk.get());
        return "merkDetails";

    }

}
