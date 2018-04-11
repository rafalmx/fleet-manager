package com.mazurek.service;

import com.mazurek.generated.Flota;

public interface XmlFleetReportService {

    String generateReport(Flota fleet);

    Flota loadReport(String path, boolean isValidationEnabled);
}
