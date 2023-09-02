package caseStudy.caseStudy.jobService;

import caseStudy.caseStudy.entity.Ucus;
import caseStudy.caseStudy.repository.HavaalaniRepository;
import caseStudy.caseStudy.repository.UcusRepository;
import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class JobService {
   private final HavaalaniRepository havaalaniRepository ;
    private final UcusRepository ucusRepository ;

    @Scheduled(cron = "0 */1 * * * *" )
    //@Scheduled(cron = "0 0 9 * * ?") // Her gün saat 09:00:00'da çalıştır
    public void Job(){
        System.out.println("Job Working");
        Ucus ucus = new Ucus();
        ucus=execute();

        ucusRepository.save(ucus);

    }

    public Ucus execute() {

        Ucus ucus = new Ucus();
        ucus.setKalkisHavaalani("IST");
        ucus.setVarisHavaalani("ANK");
        ucus.setKalkisZamani(LocalDateTime.now());
        ucus.setDonusZamani(LocalDateTime.now().plusHours(10));
        ucus.setFiyat(500);


        return ucus;
    }
}
