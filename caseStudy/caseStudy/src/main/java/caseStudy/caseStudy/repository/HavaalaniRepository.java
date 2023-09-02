package caseStudy.caseStudy.repository;

import caseStudy.caseStudy.entity.Havaalani;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HavaalaniRepository extends JpaRepository<Havaalani,Long> {

    Havaalani getHavaAlaniBySehir(String sehir);
}
