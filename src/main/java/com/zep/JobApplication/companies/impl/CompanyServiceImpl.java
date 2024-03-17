package com.zep.JobApplication.companies.impl;

import com.zep.JobApplication.companies.Company;
import com.zep.JobApplication.companies.CompanyRepository;
import com.zep.JobApplication.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
     return companyRepository.findAll();
    }
}
