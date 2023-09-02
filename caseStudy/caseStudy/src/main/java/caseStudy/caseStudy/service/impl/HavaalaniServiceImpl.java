package caseStudy.caseStudy.service.impl;


import caseStudy.caseStudy.dto.HavaalaniDto;
import caseStudy.caseStudy.dto.HavaalaniResponse;
import caseStudy.caseStudy.entity.Havaalani;
import caseStudy.caseStudy.exception.ResourceNotFoundException;
import caseStudy.caseStudy.repository.HavaalaniRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HavaalaniServiceImpl  implements caseStudy.caseStudy.service.HavaalaniService {
    private HavaalaniRepository havaalaniRepository;

    public HavaalaniServiceImpl(HavaalaniRepository havaalaniRepository) {
        this.havaalaniRepository = havaalaniRepository;
    }

    @Override
    public HavaalaniDto createHavaalani(HavaalaniDto havaalaniDto) {
        Havaalani havaalani = mapToEntity(havaalaniDto);
        Havaalani newHavaalani=havaalaniRepository.save(havaalani);

        //convert entity to dto
        HavaalaniDto postResponse =mapToDto(newHavaalani);

        return postResponse;
    }

    @Override
    public HavaalaniDto getHavaalaniById(long id) {
        Havaalani havaalani = havaalaniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Havaalani","id",id));
        return mapToDto(havaalani);

    }

    @Override
    public HavaalaniDto updateHavaalani(HavaalaniDto havaalaniDto, long id) {
        Havaalani havaalani = havaalaniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Havaalani","id",id));

        havaalani.setSehir(havaalaniDto.getSehir());

        Havaalani updatedHavaalani = havaalaniRepository.save(havaalani);

        return  mapToDto(updatedHavaalani);
    }

    public List<Havaalani> getAllHavaalani(){
        return havaalaniRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        Havaalani havaalani = havaalaniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
        havaalaniRepository.delete(havaalani);

    }

    private  HavaalaniDto mapToDto(Havaalani havaalani){
        HavaalaniDto havaalaniDto =new HavaalaniDto();
        havaalaniDto.setId(havaalani.getId());
        havaalaniDto.setSehir(havaalani.getSehir());

        return havaalaniDto;
    }

    private  Havaalani mapToEntity(HavaalaniDto havaalaniDto){
        Havaalani havaalani =new Havaalani();
        havaalani.setSehir(havaalaniDto.getSehir());
        return havaalani;

    }
}
