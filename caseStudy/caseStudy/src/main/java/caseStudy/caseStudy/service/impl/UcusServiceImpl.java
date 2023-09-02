package caseStudy.caseStudy.service.impl;

import caseStudy.caseStudy.dto.UcusDto;
import caseStudy.caseStudy.entity.Havaalani;
import caseStudy.caseStudy.entity.Ucus;
import caseStudy.caseStudy.exception.BlogApiException;
import caseStudy.caseStudy.exception.ResourceNotFoundException;
import caseStudy.caseStudy.repository.HavaalaniRepository;
import caseStudy.caseStudy.repository.UcusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UcusServiceImpl implements caseStudy.caseStudy.service.UcusService {

    private final UcusRepository ucusRepository;
    private final HavaalaniRepository havaalaniRepository;







    @Override
    public UcusDto createUcus( UcusDto ucusDto) {
       Ucus ucus=mapToEntity(ucusDto);
        Ucus createdUcus = ucusRepository.save(ucus);
        return mapToDto(createdUcus);
    }



    @Override
    public UcusDto getUcusById(  long ucusId) {


        Ucus ucus = ucusRepository.findById(ucusId).orElseThrow(() -> new ResourceNotFoundException("Ucus","id",ucusId));

        return  mapToDto(ucus);
    }

    @Override
    public void deleteUcusById(  Long ucusId) {


        Ucus ucus = ucusRepository.findById(ucusId).orElseThrow(() -> new ResourceNotFoundException("Ucus","id",ucusId));


        ucusRepository.delete(ucus);
    }

    @Override
    public UcusDto updateUcus(  Long ucusId, UcusDto ucusRequest) {

        Ucus ucus = ucusRepository.findById(ucusId).orElseThrow(() -> new ResourceNotFoundException("Ucus","id",ucusId));
        ucus.setFiyat(ucusRequest.getFiyat());
        ucus.setKalkisZamani(ucusRequest.getKalkisZamani());
        ucus.setDonusZamani(ucusRequest.getDonusZamani());
        ucus.setVarisHavaalani(ucusRequest.getVarisHavaalani());
        ucus.setKalkisHavaalani(ucus.getKalkisHavaalani());
        Ucus upatedUcus = ucusRepository.save(ucus);

        return  mapToDto(upatedUcus);
    }

    @Override
    public List<UcusDto> getAllUcus() {
        List<Ucus> ucusList =ucusRepository.findAll();
        List<UcusDto> ucusDtoList= new ArrayList<>();
        for(Ucus ucus: ucusList){
            UcusDto ucusDto= mapToDto(ucus);
            ucusDtoList.add(ucusDto);

        }
       return ucusDtoList;
    }


    @Override
    public List<Ucus> ucusSearch(String kalkisHavaalani, String varisHavaalani, LocalDateTime kalkisZamani, LocalDateTime donusZamani) {

        if(donusZamani==null){
         return    ucusRepository.findByKalkisHavaalaniAndVarisHavaalaniAndKalkisZamani(kalkisHavaalani,varisHavaalani,kalkisZamani);
        }
        else {
            List<Ucus>  gidis= ucusRepository.findByKalkisHavaalaniAndVarisHavaalaniAndKalkisZamaniDonusZamani(kalkisHavaalani,varisHavaalani,kalkisZamani);
            List<Ucus> donus =ucusRepository.findByKalkisHavaalaniAndVarisHavaalaniAndKalkisZamaniDonusZamani(varisHavaalani,kalkisHavaalani,donusZamani);


          List<Ucus> mergeUcus = new ArrayList<>();
          mergeUcus.addAll(gidis);
          mergeUcus.addAll(donus);
            return  mergeUcus;



        }

    }


    private Ucus mapToEntity(UcusDto ucusDto){
        Ucus ucus = new Ucus();
        ucus.setId(ucusDto.getId());
        ucus.setFiyat(ucusDto.getFiyat());
        ucus.setKalkisZamani(ucusDto.getKalkisZamani());
        ucus.setDonusZamani(ucusDto.getDonusZamani());
        ucus.setKalkisHavaalani(ucusDto.getKalkisHavaalani());
        ucus.setVarisHavaalani(ucusDto.getVarisHavaalani());

        return ucus;

    }


    private UcusDto mapToDto(Ucus ucus){
        UcusDto ucusDto=new UcusDto();
        ucusDto.setId(ucus.getId());
        ucusDto.setFiyat(ucus.getFiyat());
        ucusDto.setKalkisZamani(ucus.getKalkisZamani());
        ucusDto.setDonusZamani(ucus.getDonusZamani());
        ucusDto.setVarisHavaalani(ucus.getVarisHavaalani());
        ucusDto.setKalkisHavaalani(ucus.getKalkisHavaalani());
        return  ucusDto;

    }
}
