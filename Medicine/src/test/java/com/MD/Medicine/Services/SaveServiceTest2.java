// package com.MD.Medicine.Services;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.MockitoJUnitRunner;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.HashSet;
// import java.util.Set;
// import com.MD.Medicine.Models.Meds;
// import com.MD.Medicine.Models.PlanDay;
// import com.MD.Medicine.Repo.MedsRepo;

// @RunWith(MockitoJUnitRunner.class)
// public class SaveServiceTest2 {

//     @Mock
//     MedsRepo medsRepo;

//     @InjectMocks
//     SaveService saveService = new SaveService();

//     @BeforeEach
//     void setUp() throws Exception {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     void testSaveMeds() {

//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds2 = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         String expected = "Saved Successfully";
//         // when(saveService.saveMeds(meds2)).thenReturn(expected);
//         when(medsRepo.save(meds2)).thenReturn(meds2);

//         String created = saveService.saveMeds(meds2);
//         assertEquals(expected, created);

//     }
// }