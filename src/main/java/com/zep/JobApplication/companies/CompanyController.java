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
    private final CompanyService companyService;

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
    @DeleteMapping("/company")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
       boolean isDeleted=companyService.deleteCompany(id);
       if(isDeleted){return new ResponseEntity<>("Company is deleted", HttpStatus.OK);}else{
           return  new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
       }}
@GetMapping("/company/{id}")
       public ResponseEntity<Company> getCompany(@PathVariable Long id){
           Company company=companyService.getCompany(id);
           if(company!=null){
               return  new ResponseEntity<>(company,HttpStatus.OK);
           }else{ return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        }
    @GetMapping("/companies/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }
    }

