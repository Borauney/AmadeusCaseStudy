package caseStudy.caseStudy.dto;

import caseStudy.caseStudy.entity.Havaalani;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UcusDto {
    private Long id;
    private String kalkisHavaalani;
    private  String varisHavaalani;
    private  LocalDateTime kalkisZamani;
    private  LocalDateTime donusZamani;
    private  long fiyat;
}
