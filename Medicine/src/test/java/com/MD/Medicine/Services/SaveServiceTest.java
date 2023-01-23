// package com.MD.Medicine.Services;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.MockitoJUnitRunner;
// import org.springframework.boot.test.context.SpringBootTest;
// import static org.assertj.core.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.Mockito.when;

// import java.math.BigDecimal;
// import java.sql.Date;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Optional;
// import java.util.Set;
// import com.MD.Medicine.Models.Meds;
// import com.MD.Medicine.Models.PlanDay;
// import com.MD.Medicine.Models.Plans;
// import com.MD.Medicine.Repo.MedsRepo;
// import com.MD.Medicine.Repo.PlanDayRepo;
// import com.MD.Medicine.Repo.PlansRepo;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @RunWith(MockitoJUnitRunner.class)
// public class SaveServiceTest {

//     @Mock
//     private MedsRepo medsRepo;
//     @Mock
//     private PlansRepo plansRepo;
//     @Mock
//     private PlanDayRepo planDayRepo;
//     @InjectMocks
//     SaveService saveService = new SaveService();


//     @BeforeEach
//     void setUp() throws Exception{
//         MockitoAnnotations.initMocks(this);
//     }
        

//     @Test
//     void testSavePlans_success() {
        
//         LocalDate date = LocalDate.now();
//         Date date3 = new Date(1673740800000L);
//         Set<PlanDay> setPlans = new HashSet<PlanDay>();
//         Plans plans = new Plans(1, setPlans);
//         BigDecimal price = new BigDecimal(1);

//         Meds meds = new Meds(1, "teste", price, "test", 200, date, setPlans);
//         when(medsRepo.findById(anyLong())).thenReturn(Optional.of(meds));
        

//         List<PlanDay> planList2 = new ArrayList<PlanDay>();        
//         PlanDay planDay2 = new PlanDay(1, date3, "Tuesday", plans, meds, 5);        
//         planList2.add(planDay2);
        

//         String expected2 = saveService.savePlans(planList2);
//         assertThat(expected2).isEqualTo("Saved Successfully");

       
//     }

//     @Test
//     void testSavePlans_failPills() {

//         LocalDate date = LocalDate.now();
//         Date date3 = new Date(1673740800000L);
//         Set<PlanDay> setPlans = new HashSet<PlanDay>();
//         Plans plans = new Plans(1, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(1, "Brufen", price, "Pain", 200, date, setPlans);
//         when(medsRepo.findById(anyLong())).thenReturn(Optional.of(meds));
//         int pillNumber = meds.getPillNumber();
//         List<PlanDay> planList3 = new ArrayList<PlanDay>();
//         PlanDay planDay3 = new PlanDay(1, date3, "Tuesday", plans, meds, 50000);
//         planList3.add(planDay3);


//         String expected3 = saveService.savePlans(planList3);
//         assertThat(expected3).isEqualTo("Error: No piils available (Existing Pills: " + pillNumber + ")");

//     }

//     @Test
//     void testSavePlans_failDate() {

//         LocalDate date = LocalDate.now();
//         Date date2 = new Date(2022 - 12 - 31);

//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(1, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(1, "teste", price, "test", 200, date, setPlans);

//         List<PlanDay> planList = new ArrayList<PlanDay>();

//         PlanDay planDay1 = new PlanDay(0, date2, "teste", plans, meds, 5);

//         planList.add(planDay1);

//         String expected = saveService.savePlans(planList);
//         assertThat(expected).isEqualTo("Week time interval not correct/Invalid planId (only one plan can be saved)");

//     }
// }
