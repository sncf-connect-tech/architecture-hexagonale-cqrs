package com.vsct.hexagonalcqrs.core.infrastructure;

import com.vsct.hexagonalcqrs.core.domain.TotoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TotoProjectionRepository implements TotoRepository {
    @Override
    public String getToto() {
        return "toto";
    }
}
