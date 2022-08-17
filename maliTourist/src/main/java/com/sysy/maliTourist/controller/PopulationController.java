package com.sysy.maliTourist.controller;
import com.sysy.maliTourist.models.Population;
import com.sysy.maliTourist.service.PopulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Api(value = "ApiGestion")
@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/api/population", name = "app_population")

public class PopulationController {

    private PopulationService populationService;

    @Autowired
    public PopulationController(PopulationService populationService){
        this.populationService=populationService;
    }
    @ApiOperation(value = "Creer une population")
    @PostMapping(path="/add", name="create")
    @ResponseStatus(HttpStatus.CREATED)
    public Population add(@RequestBody Population population){
        return this.populationService.savePopulation(population);
    }

    @ApiOperation(value = "Lister les populations")
    @GetMapping(path = "/list", name="list")
    @ResponseStatus(HttpStatus.OK)
    public List<Population> list(){
        return this.populationService.getAllPopulation();
    }

    @ApiOperation(value = "Lire une population en fonction de l'ID")
    @GetMapping(path = "/read/{id}", name="read")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Population> read(@PathVariable long id){
        return this.populationService.getOnePopulation(id);
    }

    @ApiOperation(value = "Mettre à jour une population")
    @PutMapping(path = "/update/{id}", name="update")
    @ResponseStatus(HttpStatus.OK)
    public Population update(@RequestBody Population population, @PathVariable long id){
        return this.populationService.updatePopulation(population, id);
    }

    @ApiOperation(value = "Supprimer une population")
    @DeleteMapping(path = "/delete/{id}", name="remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id){
        this.populationService.removePopulation(id);
    }
}

