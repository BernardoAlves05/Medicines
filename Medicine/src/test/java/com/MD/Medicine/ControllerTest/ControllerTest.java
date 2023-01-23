// package com.MD.Medicine.ControllerTest;

// import static org.mockito.Mockito.when;

// import java.math.BigDecimal;
// import java.sql.Date;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import com.MD.Medicine.Controller.Controller;
// import com.MD.Medicine.Models.Meds;
// import com.MD.Medicine.Models.PlanDay;
// import com.MD.Medicine.Models.Plans;
// import com.MD.Medicine.Repo.MedsRepo;
// import com.MD.Medicine.Repo.PlanDayRepo;
// import com.MD.Medicine.Repo.PlansRepo;
// import com.MD.Medicine.Services.DeleteService;
// import com.MD.Medicine.Services.SaveService;
// import com.MD.Medicine.Services.UpdateService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// // import static org.mockito.BDDMockito.given;
// // import static org.hamcrest.CoreMatchers.is;
// // import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// // import static org.mockito.BDDMockito.willReturn;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// @RunWith(SpringRunner.class)
// @WebMvcTest(Controller.class)
// public class ControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private SaveService saveService;

//     @MockBean
//     private UpdateService updateService;

//     @MockBean
//     private DeleteService deleteService;

//     @MockBean
//     private MedsRepo medsRepo;

//     @MockBean
//     private PlansRepo plansRepo;

//     @MockBean
//     private PlanDayRepo planDayRepo;

//     @Test
//     public void controllerTest_getMedicine() throws Exception {
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);

//         // Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         when(medsRepo.findAll()).thenReturn(List.of(new Meds(50, "test med", price, "Flu", 500, date, plans)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/medicines"))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_saveMeds() throws Exception {
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);

//         ObjectMapper mapper = new ObjectMapper();
//         mapper.registerModule(new JavaTimeModule());
//         this.mockMvc.perform(MockMvcRequestBuilders.post("/medicines/save")
//                 .content(mapper.writeValueAsString(meds))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_deleteMeds() throws Exception {

//         // Set<PlanDay> plans = new HashSet<>();
//         // Date date = new Date(0);
//         // BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds();
//         meds.setMedsId(1);
//         meds.setMedsName("teste");

//         // doNothing().when(deleteService).deleteMeds(meds.getId());

//         this.mockMvc.perform(MockMvcRequestBuilders.delete("/medicines/delete/" + Long.valueOf(meds.getMedsId()))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//         // when(medsRepo.findById(meds.getMedsId())).thenReturn(Optional.of(meds));

//         // deleteService.deleteMeds(meds.getMedsId());
//         // verify(medsRepo).deleteById(meds.getMedsId());

//     }

//     @Test
//     public void controllerTest_updateMedicine() throws Exception {
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);

//         // given(updateService.updateMeds(meds.getId(), meds)).willReturn(null, null);
//         ObjectMapper mapper = new ObjectMapper();
//         mapper.registerModule(new JavaTimeModule());
//         this.mockMvc.perform(MockMvcRequestBuilders.put("/medicines/update/" + String.valueOf(meds.getMedsId()))
//                 .content(mapper.writeValueAsString(meds))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getPlans() throws Exception {
//         Set<PlanDay> setPlans = new HashSet<>();
//         // Plans plans = new Plans(50, setPlans);

//         when(plansRepo.findAll()).thenReturn(List.of(new Plans(50, setPlans)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/plan"))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getPlanDay() throws Exception {
//         LocalDate localDate = LocalDate.now();
//         Date date = new Date(0);
//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(50, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, localDate, setPlans);

//         // PlanDay planDay = new PlanDay( 50, date, "teste", plans, meds, 50 );

//         when(planDayRepo.findAll()).thenReturn(List.of(new PlanDay(50, date, "teste", plans, meds, 50)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/planDay"))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_savePlans() throws Exception {
//         LocalDate localDate = LocalDate.now();
//         Date date = new Date(2023 - 01 - 05);
//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(50, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, localDate, setPlans);
//         PlanDay planDay = new PlanDay(50, date, "teste", plans, meds, 50);
//         List<PlanDay> planList = new ArrayList<PlanDay>();
//         planList.add(planDay);

//         ObjectMapper mapper = new ObjectMapper();
//         mapper.registerModule(new JavaTimeModule());
//         this.mockMvc.perform(MockMvcRequestBuilders.post("/plan/save")
//                 .content(mapper.writeValueAsString(planList))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_deletePlans() throws Exception {

//         Set<PlanDay> planDay = new HashSet<>();
//         Plans plans = new Plans(1, planDay);

//         // doNothing().when(deleteService).deleteMeds(meds.getId());

//         this.mockMvc.perform(MockMvcRequestBuilders.delete("/plans/delete/" + String.valueOf(plans.getPlanId()))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getPlanDayByDate() throws Exception {
//         LocalDate localDate = LocalDate.now();
//         Date date = new Date(0);
//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(50, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, localDate, setPlans);

//         PlanDay planDay = new PlanDay(50, date, "teste", plans, meds, 50);

//         when(planDayRepo.findAll()).thenReturn(List.of(new PlanDay(50, date, "teste", plans, meds, 50)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/plans/get/date/" + String.valueOf(planDay.getPlanDate()))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getPlanDayByCategory() throws Exception {
//         LocalDate localDate = LocalDate.now();
//         Date date = new Date(0);
//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(50, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, localDate, setPlans);

//         when(planDayRepo.findAll()).thenReturn(List.of(new PlanDay(50, date, "teste", plans, meds, 50)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/plans/get/category/" + String.valueOf(meds.getCategory()))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getPlanDayById() throws Exception {
//         LocalDate localDate = LocalDate.now();
//         Date date = new Date(0);
//         Set<PlanDay> setPlans = new HashSet<>();
//         Plans plans = new Plans(50, setPlans);
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, localDate, setPlans);

//         when(planDayRepo.findAllByPlansPlanId(plans.getPlanId())).thenReturn(List.of(new PlanDay(50, date, "teste", plans, meds, 50)));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/plans/get/id/" + plans.getPlanId())
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getMedicineByCategory() throws Exception {
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         // Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         when(medsRepo.findAll()).thenReturn(List.of(meds));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/medicines/get/category/"+ String.valueOf(meds.getCategory())))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

//     @Test
//     public void controllerTest_getMedicineByName() throws Exception {
//         Set<PlanDay> plans = new HashSet<>();
//         LocalDate date = LocalDate.now();
//         BigDecimal price = new BigDecimal(1);
//         Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         // Meds meds = new Meds(50, "test med", price, "Flu", 500, date, plans);
//         when(medsRepo.findAll()).thenReturn(List.of(meds));

//         this.mockMvc.perform(MockMvcRequestBuilders.get("/medicines/get/name/"+ String.valueOf(meds.getMedsName())))
//                 .andExpect(MockMvcResultMatchers.status().isOk());

//     }

// }
