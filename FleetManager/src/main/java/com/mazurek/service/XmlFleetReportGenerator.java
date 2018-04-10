package com.mazurek.service;

import com.mazurek.generated.Flota;

public interface XmlFleetReportGenerator {

    String generateReport(Flota fleet);
}
