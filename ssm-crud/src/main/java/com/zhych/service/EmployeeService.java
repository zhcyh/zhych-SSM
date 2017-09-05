package com.zhych.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhych.bean.Employee;
import com.zhych.dao.EmployeeMapper;
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	/**
	 * 
	 * @Title 查询所有员工
	 * @Description
	 * @param
	 * @author zhangyuchen
	 * @throws 2017年9月4日上午10:28:06
	 */
	public List<Employee> getAll() {
		
		return employeeMapper.selectByExampleWithDept(null);
	}

}
