package caseStudy.caseStudy.controller;

import caseStudy.caseStudy.dto.HavaalaniDto;
import caseStudy.caseStudy.entity.Havaalani;
import caseStudy.caseStudy.service.HavaalaniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/havaalanlari")
public class HavaalaniController {

    private HavaalaniService havaalaniService;

    public HavaalaniController(HavaalaniService havaalaniService) {
        this.havaalaniService = havaalaniService;
    }

    @GetMapping
    public List<Havaalani> getAllHavaalanlari(){


        return  havaalaniService.getAllHavaalani();
    }
    @PostMapping
    public ResponseEntity<HavaalaniDto> createHavaalani(@RequestBody HavaalaniDto havaalaniDto){
        return new ResponseEntity<>(havaalaniService.createHavaalani(havaalaniDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HavaalaniDto> getHavaalaniById(@PathVariable(name ="id") long id){

        return   ResponseEntity.ok(havaalaniService.getHavaalaniById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<HavaalaniDto> updateHavaalani(@RequestBody HavaalaniDto havaalaniDto,@PathVariable (name ="id") long id){
        HavaalaniDto havaAlaniResponse = havaalaniService.updateHavaalani(havaalaniDto,id);

        return new ResponseEntity<>(havaAlaniResponse,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHavaalani(@PathVariable(name ="id") long id){

        havaalaniService.deleteById(id);
        return new ResponseEntity<>("Havaalani entity deleted succcesfully",HttpStatus.OK);
    }


}
