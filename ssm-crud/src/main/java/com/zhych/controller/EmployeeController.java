package com.zhych.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhych.bean.Employee;
import com.zhych.bean.Msg;
import com.zhych.service.EmployeeService;

/**
 * 处理员工CRUD请求
 * 
 * @author zhangyuchen
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/**
	 * 
	 * @Title 导入Jackson包
	 * @Description
	 * @param 
	 * @author zhangyuchen
	 * @throws 2017年9月5日上午11:40:46
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
				// 引入pageHelper分页插件
				// 在查询之前只需要调用，传入页码，以及每页的大小
				PageHelper.startPage(pn, 10);
				// startPage后面紧跟的查询就是一个分页查询
				List<Employee> emps = employeeService.getAll();
				// 用pageInfo包装查询后的结果,只需要将pageInfo交给页面就可以了
				// 封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
				PageInfo<Employee> page = new PageInfo<Employee>(emps,10);
				model.addAttribute("pageInfo", page);
				
				return Msg.success().add("pageInfo", page);
	}
	/**
	 * 
	 * @Title 查询员工数据（分页查询）
	 * @Description
	 * @param
	 * @author zhangyuchen
	 * @throws 2017年9月4日上午10:23:20
	 */
//	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
		// 引入pageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 用pageInfo包装查询后的结果,只需要将pageInfo交给页面就可以了
		// 封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo<Employee> page = new PageInfo<Employee>(emps,10);
		model.addAttribute("pageInfo", page);
		
		return "list";
	}
}
