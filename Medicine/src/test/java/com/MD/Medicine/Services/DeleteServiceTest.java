// package com.MD.Medicine.Services;

// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.math.BigDecimal;
// import java.sql.Date;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Optional;
// import java.util.Set;

// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner;
// import org.springframework.boot.test.context.SpringBootTest;
// import com.MD.Medicine.Models.Meds;
// import com.MD.Medicine.Models.PlanDay;
// import com.MD.Medicine.Models.Plans;
// import com.MD.Medicine.Repo.MedsRepo;
// import com.MD.Medicine.Repo.PlanDayRepo;
// import com.MD.Medicine.Repo.PlansRepo;

// @RunWith(MockitoJUnitRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class DeleteServiceTest {

//     @Mock
//     private MedsRepo medsRepo;
//     @Mock
//     private PlansRepo plansRepo;
//     @Mock
//     private PlanDayRepo planDayRepo;

//     @Mock
//     UpdateService updateService;
//     @InjectMocks
//     DeleteService deleteService;

//     @Test
//     void testDeleteMeds() {

//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(1, "test med", price, "Flu", 500, date, plans);
//         when(medsRepo.findById(meds.getMedsId())).thenReturn(Optional.of(meds));
//         deleteService.deleteMeds(meds.getMedsId());
//         verify(medsRepo).delete(meds);

//     }

//     @Test
//     void testDeletePlans() {
//         Date date2 = new Date(2022 - 12 - 31);
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Plans plans2 = new Plans(1, plans);
//         List<PlanDay> planList = new ArrayList<PlanDay>();
//         Meds meds = new Meds(1, "test med", price, "Flu", 500, date, plans);
//         PlanDay planDay1 = new PlanDay(1, date2, "teste", plans2, meds, 50);
//         planList.add(planDay1);

//         when(plansRepo.findById(plans2.getPlanId())).thenReturn(Optional.of(plans2));
//         deleteService.deletePlans(plans2.getPlanId());
//         verify(plansRepo).deleteById(plans2.getPlanId());

//     }

// }
