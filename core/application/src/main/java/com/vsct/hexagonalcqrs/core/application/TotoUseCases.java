package com.vsct.hexagonalcqrs.core.application;

import com.vsct.hexagonalcqrs.core.domain.TotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TotoUseCases {

    private final TotoRepository totoRepository;

    @Autowired
    public TotoUseCases(TotoRepository totoRepository) {
        this.totoRepository = totoRepository;
    }

    public String getToto() {
        return totoRepository.getToto();
    }
}
