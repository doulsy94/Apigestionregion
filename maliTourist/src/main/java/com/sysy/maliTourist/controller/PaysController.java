package com.sysy.maliTourist.controller;

import com.sysy.maliTourist.models.Pays;
import com.sysy.maliTourist.service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "ApiGestion")

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/api/pays", name = "app_pays")
public class PaysController {
    private PaysService paysService;

    @Autowired
    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @ApiOperation(value = "Creer un pays")
    @PostMapping(path = "/add", name = "create")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Pays créer avec succès")
    public Pays add(@RequestBody Pays pays) {
        return this.paysService.savePays(pays);
    }

    @ApiOperation(value = "Lister les pays")
    @GetMapping(path = "/list", name = "list")
    @ResponseStatus(value = HttpStatus.OK, reason = "Pays lister")
    public List<Pays> list() {
        return this.paysService.getAllPays();
    }

    @ApiOperation(value = "supprimer un pays à travers son id")
    @DeleteMapping(path = "/delete/{id}", name = "remove")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Pays supprimer avec succès")
    public void remove(@PathVariable String id) {
        this.paysService.removePays(id);
    }

}
