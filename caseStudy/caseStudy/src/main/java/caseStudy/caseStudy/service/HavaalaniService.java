package caseStudy.caseStudy.service;

import caseStudy.caseStudy.dto.HavaalaniDto;
import caseStudy.caseStudy.entity.Havaalani;

import java.util.List;

public interface HavaalaniService {


    HavaalaniDto createHavaalani(HavaalaniDto havaalaniDto);

    HavaalaniDto getHavaalaniById(long id);

    HavaalaniDto updateHavaalani(HavaalaniDto havaalaniDto,long id);

    List<Havaalani> getAllHavaalani();

    void deleteById(long id);

}
