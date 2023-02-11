package com.maincas.maincasapi.catalogs;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maincas.maincasapi.catalogs.controller.CompanyRestController;
import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.service.CompanyAttachmentService;
import com.maincas.maincasapi.catalogs.service.CompanyService;
import com.maincas.maincasapi.catalogs.service.CompanyUserCommentService;

@WebMvcTest(CompanyRestController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CompanyRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CompanyService companyService;

  @MockBean
  private CompanyUserCommentService commentService;

  @MockBean
  private CompanyAttachmentService attachmentService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void givenCompany_whenCreateCompany_thenReturnSavedCompany() throws Exception {
    // given - precondition setup
    Company company = Company.builder()
        .name("ACME Company")
        .alias("ACME Company alias")
        .addressLineOne("123 Main St.")
        .addressLineTwo("Bldg 2")
        .addressCity("Laredo")
        .addressState("TX")
        .addressZip("73123")
        .addressCountry("USA")
        .roles("BUYER")
        .block(false)
        .build();

    given(companyService.create(any(Company.class)))
        .willAnswer((invocation) -> invocation.getArgument(0));

    // when - action or behaviour that we are going to test
    ResultActions response = mockMvc.perform(post("/api/company/create").with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(company)));

    // then - verify the result or output using assert statements
    response.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name", is(company.getName())))
        .andExpect(jsonPath("$.alias", is(company.getAlias())))
        .andExpect(jsonPath("$.addressLineOne", is(company.getAddressLineOne())))
        .andExpect(jsonPath("$.addressLineTwo", is(company.getAddressLineTwo())))
        .andExpect(jsonPath("$.addressCity", is(company.getAddressCity())))
        .andExpect(jsonPath("$.addressState", is(company.getAddressState())))
        .andExpect(jsonPath("$.addressZip", is(company.getAddressZip())))
        .andExpect(jsonPath("$.addressCountry", is(company.getAddressCountry())))
        .andExpect(jsonPath("$.roles", is(company.getRoles())))
        .andExpect(jsonPath("$.block", is(company.getBlock())));

  }

}
