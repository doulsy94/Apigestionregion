package com.sysy.maliTourist.service;
import com.sysy.maliTourist.exceptions.PopulationNotFoundException;
import com.sysy.maliTourist.models.Population;
import com.sysy.maliTourist.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //forni certaines fonctionnalitées métiers
public class PopulationService {

    @Autowired // Va injecter la classe population Repository et créer une instance de celle ci

    private PopulationRepository populationRepository;

    public Population savePopulation(Population population){

        return this.populationRepository.save(population);
    }

    public List<Population> getAllPopulation(){
        return this.populationRepository.findAll();
    }
    public Optional<Population> getOnePopulation(long id){
        Optional<Population> population = this.populationRepository.findById(id);
        if(!population.isPresent()) {
            throw new PopulationNotFoundException(String.format("Population avec id non à jour" + id));
        }
        return this.populationRepository.findById(id);
    }
    public Population updatePopulation(Population population, long id){
        Population populationExist = populationRepository.findById(id).get();
        System.out.println(populationExist);
        if(populationExist!=null){
            populationRepository.save(population);
            return population;
        }else {
            return null;
        }
    }
    public void  removePopulation(long id){
        Optional<Population> population = this.populationRepository.findById(id);
        if(!population.isPresent()){
            throw new PopulationNotFoundException(String.format("Population avec id supprimé"+id));
        }
        this.populationRepository.delete(population.get());

    }
}



