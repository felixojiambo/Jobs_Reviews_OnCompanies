package com.zep.JobApplication.companies.impl;

import com.zep.JobApplication.companies.Company;
import com.zep.JobApplication.companies.CompanyRepository;
import com.zep.JobApplication.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional=companyRepository.findById(id);

            if (companyOptional.isPresent()) {
                Company companyToUpdate = companyOptional.get();


                    companyToUpdate.setDescription(company.getDescription());
                    companyToUpdate.setName(company.getName());

                    companyToUpdate.setJobs(company.getJobs());

                    companyRepository.save(companyToUpdate);
                    return true;
                }else{

            return false;}
        }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id))
        { companyRepository.deleteById(id);return true;}else
        {return false;}
    }
}

