package com.example.Eagle.Contanier;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Contanier")
@CrossOrigin(origins = "*")
public class ContanierController {
    private  final ContanierService ContanierService;

    @Autowired
    public ContanierController(ContanierService contanierService)
    {
        ContanierService = contanierService;
    }
    @GetMapping
    public List<Contanier> GetContanier()
    {
        return ContanierService.GetContaniers();
    }
    @PostMapping
    public  void AddNewContanier(@RequestBody Contanier contanier)
    {

        ContanierService.addContanier(contanier);
    }

}
