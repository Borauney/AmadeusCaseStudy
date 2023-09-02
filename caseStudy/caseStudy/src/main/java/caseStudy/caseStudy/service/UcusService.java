package caseStudy.caseStudy.service;

import caseStudy.caseStudy.dto.UcusDto;
import caseStudy.caseStudy.entity.Ucus;

import java.time.LocalDateTime;
import java.util.List;

public interface UcusService {

    UcusDto createUcus(UcusDto ucusDto);

    UcusDto getUcusById(long ucusId);
    void deleteUcusById(Long ucusId);
    UcusDto updateUcus(Long ucusId,UcusDto ucusRequest);


    List<UcusDto> getAllUcus();

    List<Ucus> ucusSearch(String kalkisHavaalani,String varisHavaalani,LocalDateTime kalkisZamani,LocalDateTime donusZamani);
}
