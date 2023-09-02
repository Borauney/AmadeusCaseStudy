package caseStudy.caseStudy.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ucuslar")
public class Ucus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String kalkisHavaalani;
    private  String varisHavaalani;
    private  LocalDateTime kalkisZamani;
    private  LocalDateTime donusZamani;
    private  long fiyat;



}
