package ren.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ren.practice.model.Organization;
import ren.practice.repository.OrganizationRepository;

import java.util.List;

@RestController
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private OrganizationRepository repository;
//    DepartmentClient departmentClient;
//    EmployeeClient employeeClient;

    @Autowired
    public OrganizationController(OrganizationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return repository.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        LOGGER.info("Organization find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id);
    }

//    @GetMapping("/{id}/with-departments")
//    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
//        return organization;
//    }
//
//    @GetMapping("/{id}/with-departments-and-employees")
//    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
//        return organization;
//    }
//
//    @GetMapping("/{id}/with-employees")
//    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
//        LOGGER.info("Organization find: id={}", id);
//        Organization organization = repository.findById(id);
//        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
//        return organization;
//    }

}