package com.sysy.maliTourist.controller;

import com.sysy.maliTourist.models.Population;
import com.sysy.maliTourist.models.Region;
import com.sysy.maliTourist.service.PopulationService;
import com.sysy.maliTourist.service.RegionService;
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
@RequestMapping(path = "/api/region", name = "app_region")
public class RegionController {
    private RegionService regionService;

    private PopulationService populationService;

    @Autowired
    public RegionController(RegionService regionService){
        this.regionService=regionService;
    }
    //decrit une operation ou généralement une méthode HTTP par rapport à un chemin spécifique
    @ApiOperation(value = "Créer une region")
    @PostMapping(path="/add", name="create")
    @ResponseStatus(HttpStatus.CREATED)
    public Region add(@RequestBody Region region, Population population){

        if(population==null){
            populationService.savePopulation(population);
        }
        return this.regionService.saveRegion(region);
    }

    @ApiOperation(value = "lister les regions")
    @GetMapping(path = "/list", name="list")
    @ResponseStatus(HttpStatus.OK)
    public List<Region> list(){
        return this.regionService.getAllRegion();
    }

    @ApiOperation(value = "lire une region à partir de son id")
    @GetMapping(path = "/read/{id}", name="read")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Region> read(@PathVariable long id){
        return this.regionService.getOneRegion(id);
    }

    @ApiOperation(value = "Lister les region sans pays")
    @GetMapping("/regionsanspays")
    public Iterable<Object[]> lireREGION_SANS_Pays() {
        return regionService.lireREGION_SANS_Pays();
    }

    @ApiOperation(value = "Lister les region en fonction du pays")
    @GetMapping("/regionenfonctionpays/{pays}")
    public Iterable<Object[]> lireREGION_EN_FONCTION_DU_Pays(@PathVariable String pays) {
        return regionService.lireREGION_EN_FONCTION_DU_Pays(pays);
    }

    @ApiOperation(value = "Lister les region avec pays")
    //mappe les requêttes HTTP Get sur la méthode de géstionnaire spécifique
    @GetMapping("/regionavecpays")
    public Iterable<Object[]> lireALLREGION_WITH_PAYS() {
        return regionService. lireALLREGION_WITH_PAYS();
    }

    @ApiOperation(value = "Mettre à jour les region à travers son id")
    //mappe les requêtes HTTP Put sur la méthodes de géstionnaire spécifique
    @PutMapping(path = "/update/{id}", name="update")
    //méthodede gestionnaire ou une classe d'exception
    @ResponseStatus(HttpStatus.OK)
    public Region update(@RequestBody Region region, @PathVariable long id){
        return this.regionService.updateRegion(region, id);
    }

    @ApiOperation(value = "Supprimer les regions à travers son id")
    //il mappe les requêtes HTTP patch sur la méthode de gestionnaire spécifique
    @DeleteMapping(path = "/delete/{id}", name="remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id){
        this.regionService.removeRegion(id);
    }
}
