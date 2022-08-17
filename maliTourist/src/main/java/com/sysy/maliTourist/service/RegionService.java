package com.sysy.maliTourist.service;
import com.sysy.maliTourist.exceptions.RegionNotFoundException;
import com.sysy.maliTourist.models.Region;
import com.sysy.maliTourist.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired // Va injecter la classe region Repository et créer une instance de celle ci
    private RegionRepository regionRepository;

    //Iterable objet: un objet qui permet d'iterer
    public Iterable<Object[]> lireREGION_SANS_Pays() {
        return regionRepository.REGION_SANS_Pays();
    }

    public Iterable<Object[]> lireREGION_EN_FONCTION_DU_Pays(String pays) {
        return regionRepository.REGION_EN_FONCTION_DU_Pays(pays);
    }

    public Iterable<Object[]> lireALLREGION_WITH_PAYS() {
        return regionRepository.REGION_WITH_PAYS();
    }

    public Region saveRegion(Region region){
        return this.regionRepository.save(region);
    }

    public List<Region> getAllRegion(){
        return this.regionRepository.findAll();
    }
    public Optional<Region> getOneRegion(long id){
        Optional<Region> region = this.regionRepository.findById(id);
        if(!region.isPresent()) {
            throw new RegionNotFoundException(String.format("Region avec id non à jour" + id));
        }
            return this.regionRepository.findById(id);
    }
    public Region updateRegion(Region region, long id){
        Region regionExist = regionRepository.findById(id).get();
        System.out.println(regionExist);
        if(regionExist!=null){
            regionRepository.save(region);
            return region;
        }else {
            return null;
        }
    }

    public void  removeRegion(long id){
        Optional<Region> region = this.regionRepository.findById(id);
        if(!region.isPresent()){
            throw new RegionNotFoundException(String.format("Region avec id supprimé"+id));
        }
        this.regionRepository.delete(region.get());

    }
}
