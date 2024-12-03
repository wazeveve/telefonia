package bcc.ifsuldeminas.PrimeiroApp.controller;


import bcc.ifsuldeminas.PrimeiroApp.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.PrimeiroApp.model.entities.telefonia.comercial.Plano;
import bcc.ifsuldeminas.PrimeiroApp.model.repositories.comercial.OperadoraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operadora")
public class OperadoraController {
    OperadoraRepository operadoraRepository;

    public OperadoraController(OperadoraRepository operadoraRepository){
        this.operadoraRepository = operadoraRepository;
    }

    @PostMapping
    public Operadora create(@RequestBody Operadora operadora){
        this.operadoraRepository.save(operadora);
        return operadora;
    }

    @GetMapping("/{id}")
    public Operadora read(@PathVariable Long id){
        Optional opt = this.operadoraRepository.findById(id);
        if(opt.isPresent()){
            return (Operadora)opt.get();
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Operadora> read(){
        return this.operadoraRepository.findAll();
    }

    @PutMapping("/{id}")
    public Operadora update(@PathVariable Long id, @RequestBody Operadora operadora){
        Optional opt = this.operadoraRepository.findById(id);
        if(opt.isPresent()){
            Operadora operadoraOriginal = (Operadora)opt.get();
            operadoraOriginal.setNome(operadora.getNome());
            operadoraOriginal.setClientes(operadora.getClientes());
            operadoraOriginal.setCelulares(operadora.getCelulares());
            operadoraOriginal.setPlanos(operadora.getPlanos());
            this.operadoraRepository.save(operadoraOriginal);
            return operadoraOriginal;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.operadoraRepository.deleteById(id);
    }


}
