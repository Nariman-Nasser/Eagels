package com.example.Eagle.Contanier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContanierService {


    private final ContanierRepostiory contanierRepostiory;

    @Autowired
    public ContanierService(ContanierRepostiory contanierRepostiory)
    {
        this.contanierRepostiory = contanierRepostiory;
    }
    public List<Contanier> GetContaniers(){
        return contanierRepostiory.findAll();
    }

    public  void addContanier(Contanier cntr  ) {
        contanierRepostiory.save(cntr);
    }


}
