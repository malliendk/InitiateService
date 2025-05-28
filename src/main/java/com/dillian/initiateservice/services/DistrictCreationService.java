package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.District;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.dtos.Tile;
import com.dillian.initiateservice.util.OtherConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DistrictCreationService {

    public District createNewDistrict(InitiateDTO initiateDTO) {
        final int currentNumberOfDistricts = initiateDTO.getDistricts().size();
        final int currentNumberOfTiles = initiateDTO.getDistricts().stream()
                .map(District::getTiles)
                .flatMap(List::stream)
                .toList()
                .size();
        District newDistrict = new District();
        newDistrict.setId(currentNumberOfDistricts + 1l);
        for (int i = currentNumberOfTiles;
             i < currentNumberOfTiles + OtherConstants.STARING_TILE_AMOUNT_PER_DISTRICT;
             i++) {
            Tile newTile = new Tile();
            newTile.setId(i + 1l);
            newTile.setBuildingId(0l);
            newTile.setDistrictId(currentNumberOfDistricts + 1l);
            newDistrict.getTiles().add(newTile);
        }
        return newDistrict;
    }
}
