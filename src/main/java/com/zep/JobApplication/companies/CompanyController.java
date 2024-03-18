package com.zep.JobApplication.companies;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private  CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/companies")
    public  ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);

    }
    @PutMapping("/companies")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
      companyService.updateCompany(company,id);
        return  new ResponseEntity<>("Company updated  successfully", HttpStatus.OK);
    }
    @PostMapping("/company")
    public  ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return  new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }
}
