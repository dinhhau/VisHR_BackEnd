package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDept();

    Department getDeptById(Integer deptId);

    void addDept(Department department);

    void updateDept(Department department);

    void deleteDeptById(Integer deptId);

    List<Department> searchDeptByCondition(int page, int pageSize, String columnSortName, Boolean asc, String deptCode, String deptName);
}
