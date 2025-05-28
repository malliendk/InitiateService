package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.District;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.services.DistrictCreationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("district")
@AllArgsConstructor
public class DistrictController {

    private final DistrictCreationService districtCreationService;

    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody InitiateDTO initiateDTO) {
        return ResponseEntity.ok(districtCreationService.createNewDistrict(initiateDTO));
    }
}
