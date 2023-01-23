// package com.MD.Medicine.Services;

// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.HashSet;
// import java.util.Optional;
// import java.util.Set;

// import static org.mockito.BDDMockito.given;
// import static org.mockito.Mockito.verify;
// import com.MD.Medicine.Models.Meds;
// import com.MD.Medicine.Models.PlanDay;
// import com.MD.Medicine.Repo.MedsRepo;
// import com.MD.Medicine.Repo.PlanDayRepo;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class UpdateServiceTest {

//     @Mock
//     MedsRepo medsRepo;
//     @Mock
//     PlanDayRepo planDayRepo;

//     @InjectMocks
//     DeleteService deleteService;

//     @InjectMocks
//     UpdateService updateService;
//     @InjectMocks
//     SaveService saveService;

//     @Test
//     void testUpdateMeds() {

//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(0, "test med", price, "Flu", 500, date, plans);
//         Meds newMeds = new Meds();
//         newMeds.setMedsName("teste2");
//         newMeds.setPrice(price);
//         newMeds.setCategory("Flu");
//         newMeds.setPillNumber(500);
//         newMeds.setMedsDate(date);
//         newMeds.setDays(plans);

//         given(medsRepo.findById(meds.getMedsId())).willReturn(Optional.of(meds));
//         updateService.updateMeds(meds.getMedsId(), newMeds);

//         verify(medsRepo).save(newMeds);
//         verify(medsRepo).findById(meds.getMedsId());
//     }

//     // @Test
//     // void testUpdatePills() {
 
//     //     Date date3 = new Date(1673740800000L);
//     //     Set<PlanDay> setDays = new HashSet<>();
//     //     Plans plans = new Plans(1, setDays);
//     //     Meds meds = new Meds();
//     //     meds.setMedsName(null);
//     //     meds.setPrice(null);
//     //     meds.setCategory(null);
//     //     meds.setPillNumber(0);
//     //     meds.setMedsDate(null);
//     //     meds.setDays(setDays);
       

//     //     Meds expected = updateService.updatePills(anyLong());
//     //     assertEquals(expected, meds);
    
//     // }

// }
