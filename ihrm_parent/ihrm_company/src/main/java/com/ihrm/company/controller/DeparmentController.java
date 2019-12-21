package com.ihrm.company.controller;


import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//1、解决跨域
@CrossOrigin
//2、声明restContoller
@RestController
//3、设置父路径
@RequestMapping("company")
public class DeparmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("department")
    public Result save(@RequestBody Department department) {
    //1、设置保存的企业id
//        String companyId = "1";
        department.setCompanyId(companyId);
        //2、调用service 完成保存企业
        this.departmentService.save(department);
        //3、构造返回结果

        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询企业的部门列表
     * 指定企业的id
     */
    @GetMapping("department")
    public Result findAll() {
        //1、指定企业的id 从父类重获取了
//        String companyId = "1";
        Company company = companyService.findById(companyId);
        //2、完成查询
        List<Department> list = departmentService.findAll(companyId);

        //3、构造返回结果
        DeptListResult deptListResult = new DeptListResult(company, list);
        return new Result(ResultCode.SUCCESS, deptListResult);
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("department/{id}")
    public Result findById(@PathVariable("id") String id) {
        System.out.println("id是："+id);
        Department department = this.departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    /**
     * 修改部门
     */
    @PutMapping("department/{id}")
    public Result updete(@PathVariable("id") String id, @RequestBody Department department) {
        //1、设置修改部门的id
        department.setId(id);
        //2、调用service更新
        departmentService.updete(department);
        return new Result(ResultCode.SUCCESS);
    }
    /**
     * 根据id删除部门
     */
    @DeleteMapping("department/{id}")
    public Result delete(@PathVariable("id") String id) {
        this.departmentService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

}
