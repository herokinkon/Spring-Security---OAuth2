package com.test.mysql.demo;

import com.test.mysql.demo.dto.EmployeeDto;
import com.test.mysql.demo.entity.Employee;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * configuration
 */
@Configuration
public class configuration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
			@Override
			protected void configure() {
				this.map().setId(source.getEmp_no());
				this.map().setFirstName(source.getFirst_name());
				this.map().setLastName(source.getLast_name());
            }
        });
        return mapper;
    }
}