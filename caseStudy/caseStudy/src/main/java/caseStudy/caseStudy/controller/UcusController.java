package caseStudy.caseStudy.controller;

import caseStudy.caseStudy.dto.UcusDto;
import caseStudy.caseStudy.entity.Havaalani;
import caseStudy.caseStudy.entity.Ucus;
import caseStudy.caseStudy.service.UcusService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ucuslar")
public class UcusController {

    private UcusService ucusService;


    public UcusController(UcusService ucusService) {
        this.ucusService = ucusService;
    }

    @GetMapping("/all")
    public  ResponseEntity<List<UcusDto>> getAllucuslar(){
        List<UcusDto> ucuslar= ucusService.getAllUcus();
        return new ResponseEntity<>(ucuslar,HttpStatus.OK);

    }
    @PostMapping()
    public ResponseEntity<UcusDto> createUcus(
                                                    @RequestBody UcusDto commentDto){


        return new ResponseEntity<>(ucusService.createUcus(commentDto), HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UcusDto>  getUcusById(@PathVariable(value = "id") Long ucusId){
        UcusDto ucusDto  =ucusService.getUcusById(ucusId);
        return  new ResponseEntity<>(ucusDto,HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<UcusDto>  updateUcus(@PathVariable(value = "id") Long ucusId,
                                               @RequestBody UcusDto ucusDto){
        return  new ResponseEntity<>(ucusService.updateUcus(ucusId,ucusDto),HttpStatus.ACCEPTED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>  deleteUcusById(@PathVariable(value = "id") Long ucusId){
       ucusService.deleteUcusById(ucusId);
       return  new ResponseEntity<>("Succesfully deleted",HttpStatus.OK);
    }



    @GetMapping("/search")
    public ResponseEntity<List<Ucus>> searchUcuslarParam(
            @RequestParam String kalkisHavaalani,
        @RequestParam String varisHavaalani,
        @RequestParam LocalDateTime kalkisZamani,
        @RequestParam(required = false) LocalDateTime donusZamani) {

        List<Ucus> ucuslar = ucusService.ucusSearch(kalkisHavaalani, varisHavaalani, kalkisZamani, donusZamani);
        return  ResponseEntity.ok(ucuslar);
    }




}
