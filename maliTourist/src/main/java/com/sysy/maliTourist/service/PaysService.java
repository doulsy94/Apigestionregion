package com.sysy.maliTourist.service;

import com.sysy.maliTourist.exceptions.PaysNotFoundException;
import com.sysy.maliTourist.models.Pays;
import com.sysy.maliTourist.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
//indique a spring que la classe contient la logique métier
public class PaysService {

    @Autowired // Va injecter la classe pays Repository et créer une instance de celle ci
    private PaysRepository paysRepository;

    public Pays savePays(Pays pays){
        return this.paysRepository.save(pays);
    }

    public List<Pays> getAllPays(){
        return this.paysRepository.findAll();
    }
    public Optional<Pays> getOnePays(String code_Pays){
        Optional<Pays> pays = this.paysRepository.findById(code_Pays);
        if(!pays.isPresent()) {
            throw new PaysNotFoundException(String.format("Pays avec id non trouvé" + code_Pays));
        }
        return this.paysRepository.findById(code_Pays);
    }

    public void removePays(String id){
        Optional<Pays> pays = this.paysRepository.findById(id);
        if(!pays.isPresent()){
            throw new PaysNotFoundException(String.format("Pays avec id supprimé"+id));
        }
        this.paysRepository.delete(pays.get());

    }
}


