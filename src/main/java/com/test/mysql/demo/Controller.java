package com.test.mysql.demo;

import java.security.Principal;
import com.test.mysql.demo.dto.EmployeeDto;
import com.test.mysql.demo.entity.Employee;
import com.test.mysql.demo.repo.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

	@RequestMapping("/getEmployee")
	public @ResponseBody EmployeeDto getEmployee(@RequestParam(value = "id", defaultValue = "10001") String id) {
		Employee entity = repo.getEmployee(Integer.parseInt(id));
		if (entity == null) {
			throw new NullPointerException("Can not find employee id: " + id);
		}
		return convertToDto(entity);// repo.getEmployee(Integer.parseInt(id));
		// return repo.findAll().get(0);
	}

	@RequestMapping(value = "GetAll", method = RequestMethod.GET)
	public @ResponseBody Page<Employee> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@GetMapping("/")
	String home(Principal user) {
		return "Hello " + user.getName();
	}

	@GetMapping("/user/me")
	public Principal user(Principal principal) {
		return principal;
	}

	public EmployeeDto convertToDto(Employee emp) {
		EmployeeDto result = mapper.map(emp, EmployeeDto.class);
		return result;
	}

	@ExceptionHandler({ NullPointerException.class,NumberFormatException.class })
	public String handleException(Exception exception) {
		return exception.getMessage();
	}
}
