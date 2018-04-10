package com.mazurek.service;

import com.mazurek.generated.Flota;

public interface FleetService {

    Flota generateFleetReport(int positionCount, int carCount, int driverCount);

    void save(com.mazurek.persistence.entity.Flota flota);
}
