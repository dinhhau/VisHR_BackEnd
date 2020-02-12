package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.vissoft.portal.entities.Department;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("department")
public class    DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getAllDept")
    public ResponseEntity<ApiResponse> getAllDept(){
        ApiResponse object = new ApiResponse();
        List<Department> list = departmentService.getAllDept();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @RequestMapping("/getDeptById/{deptId}")
    public ResponseEntity<Department> getDeptById(@PathVariable(name = "deptId") Integer deptId){
        Department department = departmentService.getDeptById(deptId);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @PostMapping("/addDept")
    public ResponseEntity<Department> addDept(@RequestBody Department department, UriComponentsBuilder builder) {
         departmentService.addDept(department);
         return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PutMapping("/updateDept")
    public ResponseEntity<Department> updateDept(@RequestBody Department department){
        departmentService.updateDept(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDeptById/{deptId}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable(name = "deptId") Integer deptId){
        departmentService.deleteDeptById(deptId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getDeptByCondition")
    public ResponseEntity<ApiResponse> SearchDeptByCondition(
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "pageSize", required = false) int pageSize,
            @RequestParam(value = "columnSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @RequestParam(value = "deptName", required = false) String deptName) {

        ApiResponse object = new ApiResponse();
        List<Department> list = departmentService.searchDeptByCondition(page, pageSize, columnSortName, asc, deptCode, deptName);

        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        object.setPage(page);
        object.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }
}
