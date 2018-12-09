package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.model.sf_response.AvgCompletionTimePerServiceRequestType;
import com.uoa.di.csr.model.sf_response.CountPerColor;
import com.uoa.di.csr.model.sf_response.CountPerDay;
import com.uoa.di.csr.model.sf_response.CountPerLicencePlate;
import com.uoa.di.csr.model.sf_response.CountPerServiceRequestType;
import com.uoa.di.csr.model.sf_response.CountPerSsa;
import com.uoa.di.csr.model.sf_response.MostCommonServiceRequestPerZipCode;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface StoredFunctionRepository {

    List<CountPerServiceRequestType> getTotalRequestsPerTypeInRange(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<CountPerDay> getTotalRequestsPerDayWithTypeInRange(ServiceRequestType serviceRequestType, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<MostCommonServiceRequestPerZipCode> getMostCommonRequestTypesPerZipCodeForDay(LocalDateTime localDateTime);

    List<AvgCompletionTimePerServiceRequestType> getAvgCompletionTimePerTypeInRange(LocalDateTime startDateTime, LocalDateTime endDateTime);

    //TODO maybe change to CountPerServiceRequestType instead of list, as it will (most possibly?) never return more than 1 result
    List<CountPerServiceRequestType> getMostCommonRequestInBoundingBoxForDay(double minX, double minY, double maxX, double maxY, LocalDateTime localDateTime);

    List<CountPerLicencePlate> getLicencePlatesInvolvedInMoreThanOneRequests();

    List<CountPerSsa> getTopFiveSsaInRegardToTotalNumberOfRequestsInRange(LocalDateTime startDate, LocalDateTime endDate);

    List<CountPerColor> getSecondMostCommonVehicleColor();

    List<BigInteger> getPotHolesTogetherWithRodentBaitingForDay(LocalDateTime localDateTime);
}
