package caseStudy.caseStudy.repository;

import caseStudy.caseStudy.dto.UcusDto;
import caseStudy.caseStudy.entity.Ucus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.List;


public interface UcusRepository extends JpaRepository<Ucus,Long> {


   @Query("SELECT u FROM Ucus u WHERE u.kalkisHavaalani = :kalkisHavaalani AND u.varisHavaalani = :varisHavaalani AND u.kalkisZamani = :kalkisZamani AND u.donusZamani IS NULL ")
 List<Ucus> findByKalkisHavaalaniAndVarisHavaalaniAndKalkisZamani(String kalkisHavaalani ,String varisHavaalani,LocalDateTime kalkisZamani);

    @Query("SELECT u FROM Ucus u WHERE u.kalkisHavaalani = :kalkisHavaalani AND u.varisHavaalani = :varisHavaalani AND u.kalkisZamani = :kalkisZamani  ")
     List<Ucus> findByKalkisHavaalaniAndVarisHavaalaniAndKalkisZamaniDonusZamani(String kalkisHavaalani ,String varisHavaalani,LocalDateTime kalkisZamani);


}
