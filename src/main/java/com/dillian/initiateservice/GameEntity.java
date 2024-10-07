package com.dillian.initiateservice;

import com.dillian.initiateservice.dtos.SupervisorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue
    private Long id;
}
