package com.maincas.maincasapi.catalogs;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.maincas.maincasapi.catalogs.model.CompanyUserComment;
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

  @Test
  public void giventListOfCompanies_whenGetAllCompanies_thenReturnCompaniesList() throws Exception {
    List<Company> listOfCompanies = new ArrayList<>();
    listOfCompanies.add(Company.builder()
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
        .build());
    listOfCompanies.add(Company.builder()
        .name("ACME Company 2")
        .alias("ACME Company alias 2")
        .addressLineOne("123 Main St.")
        .addressLineTwo("Bldg 2")
        .addressCity("Laredo")
        .addressState("TX")
        .addressZip("73123")
        .addressCountry("USA")
        .roles("SELLER")
        .block(false)
        .build());

    given(companyService.fetchAll()).willReturn(listOfCompanies);
    ResultActions response = mockMvc.perform(get("/api/company/list"));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(listOfCompanies.size())));
  }

  @Test
  public void givenListOfCompanies_whenGetCompaniesByRole_thenReturnCompaniesListFilteredWithRole()
      throws Exception {
    List<Company> listOfCompanies = new ArrayList<>();
    String roleName = "BUYER";
    listOfCompanies.add(Company.builder()
        .name("ACME Company")
        .alias("ACME Company alias")
        .addressLineOne("123 Main St.")
        .addressLineTwo("Bldg 2")
        .addressCity("Laredo")
        .addressState("TX")
        .addressZip("73123")
        .addressCountry("USA")
        .roles(roleName)
        .block(false)
        .build());

    given(companyService.fetchByRole(roleName)).willReturn(listOfCompanies);
    ResultActions response = mockMvc.perform(get("/api/company/roles/{roleName}", roleName));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(1)));
  }

  @Test
  public void givenCompanyId_whenGetCompanyById_thenReturnCompanyObject() throws Exception {
    Long companyId = 1L;
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
    given(companyService.fetchById(companyId)).willReturn(Optional.of(company));

    ResultActions response = mockMvc.perform(get("/api/company/{id}", companyId));

    response.andExpect(status().isOk())
        .andDo(print())
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

  @Test
  public void givenInvalidCompanyId_whenGetCompanyById_thenReturnEmpty() throws Exception {
    Long companyId = 1L;
    given(companyService.fetchById(companyId)).willReturn(Optional.empty());

    // when - action or the behaviour that we are going test
    ResultActions response = mockMvc.perform(get("/api/company/{id}", companyId));

    // then - verify the output
    response.andExpect(status().isNotFound())
        .andDo(print());
  }

  @Test
  public void givenInvalidRole_whenGetCompaniesByRole_thenReturnEmpty() throws Exception {
    List<Company> listOfCompanies = new ArrayList<>();
    String roleName = "BUYER";

    given(companyService.fetchByRole(roleName)).willReturn(listOfCompanies);
    ResultActions response = mockMvc.perform(get("/api/company/roles/{roleName}", roleName));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(0)));
  }

  @Test
  public void givenUpdatedCompany_whenUpdateCompany_thenReturnUpdatedCompany() throws Exception {
    Long companyId = 1L;
    Company savedCompany = Company.builder()
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
    Company updatedCompany = Company.builder()
        .name("ACME Company 2")
        .alias("ACME Company alias 2")
        .addressLineOne("123 Main St.")
        .addressLineTwo("Bldg 2")
        .addressCity("Laredo")
        .addressState("TX")
        .addressZip("73123")
        .addressCountry("USA")
        .roles("BUYER,SELLER")
        .block(false)
        .build();

    given(companyService.fetchById(companyId)).willReturn(Optional.of(savedCompany));
    given(companyService.update(any(Long.class), any(Company.class)))
        .will((invocation) -> invocation.getArgument(1));

    ResultActions response = mockMvc.perform(put("/api/company/{id}", companyId).with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(updatedCompany)));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.name", is(updatedCompany.getName())))
        .andExpect(jsonPath("$.alias", is(updatedCompany.getAlias())))
        .andExpect(jsonPath("$.addressLineOne", is(updatedCompany.getAddressLineOne())))
        .andExpect(jsonPath("$.addressLineTwo", is(updatedCompany.getAddressLineTwo())))
        .andExpect(jsonPath("$.addressCity", is(updatedCompany.getAddressCity())))
        .andExpect(jsonPath("$.addressState", is(updatedCompany.getAddressState())))
        .andExpect(jsonPath("$.addressZip", is(updatedCompany.getAddressZip())))
        .andExpect(jsonPath("$.addressCountry", is(updatedCompany.getAddressCountry())))
        .andExpect(jsonPath("$.roles", is(updatedCompany.getRoles())))
        .andExpect(jsonPath("$.block", is(updatedCompany.getBlock())));
  }

  @Test
  public void givenUpdatedCompany_whenUpdateCompany_thenReturn404() throws Exception {
    Long companyId = 1L;
    Company updatedCompany = Company.builder()
        .name("ACME Company 2")
        .alias("ACME Company alias 2")
        .addressLineOne("123 Main St.")
        .addressLineTwo("Bldg 2")
        .addressCity("Laredo")
        .addressState("TX")
        .addressZip("73123")
        .addressCountry("USA")
        .roles("BUYER,SELLER")
        .block(false)
        .build();

    given(companyService.fetchById(companyId)).willReturn(Optional.empty());
    given(companyService.update(any(Long.class), any(Company.class)))
        .will((invocation) -> invocation.getArgument(1));

    ResultActions response = mockMvc.perform(put("/api/company/{id}", companyId).with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(updatedCompany)));

    response.andExpect(status().isNotFound())
        .andDo(print());
  }

  @Test
  public void givenCompanyId_whenDeletecompany_thenReturnDeletedCode() throws Exception {
    Long companyId = 1L;
    Company savedCompany = Company.builder()
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
    given(companyService.fetchById(companyId)).willReturn(Optional.of(savedCompany));
    willDoNothing().given(companyService).deleteById(companyId);

    ResultActions response = mockMvc.perform(delete("/api/company/{id}", companyId));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.deleted", is(Boolean.TRUE)));
  }

  @Test
  public void givenCompanyId_whenDeleteCompany_thenReturn404() throws Exception {
    Long companyId = 1L;
    given(companyService.fetchById(companyId)).willReturn(Optional.empty());
    willDoNothing().given(companyService).deleteById(companyId);

    ResultActions response = mockMvc.perform(delete("/api/company/{id}", companyId));

    response.andExpect(status().isNotFound())
        .andDo(print());
  }

  @Test
  public void givenCompanyUserComment_whenCreateCompanyUserComment_thenReturnSavedCompanyUserComment()
      throws Exception {
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
    CompanyUserComment comment = CompanyUserComment.builder()
        .company(company)
        .comment("test comment")
        .createdBy("testUser")
        .build();

    given(commentService.create(any(CompanyUserComment.class)))
        .willAnswer((invocation) -> invocation.getArgument(0));

    ResultActions response = mockMvc.perform(post("/api/company/{id}/comments/create", 1L).with(csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(comment)));

    response.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.comment", is(comment.getComment())))
        .andExpect(jsonPath("$.createdBy", is(comment.getCreatedBy())));
  }

  @Test
  public void giventListOfCompanyUserComments_whenGetCompanyComments_thenReturnCompanyUserCommentsList()
      throws Exception {
    List<CompanyUserComment> listOfComments = new ArrayList<>();
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
    listOfComments.add(CompanyUserComment.builder()
        .company(company)
        .comment("test comment 1")
        .createdBy("testUser")
        .build());
    listOfComments.add(CompanyUserComment.builder()
        .company(company)
        .comment("test comment 2")
        .createdBy("testUser")
        .build());

    given(commentService.fetchByParentId(1L)).willReturn(listOfComments);
    ResultActions response = mockMvc.perform(get("/api/company/{id}/comments", 1L));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(listOfComments.size())));
  }

}
