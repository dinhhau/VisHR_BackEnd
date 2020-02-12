package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Department;

import java.util.List;

public interface DepartmentDAO {

    List<Department> getAllDept();

    Department getDeptById(Integer deptId);

    void addDept(Department department);

    void updateDept(Department department);

    void deleteByDeptId(Integer deptId);

    List<Department> searchDeptByCondition(int page, int pageSize, String columnSortName, Boolean asc, String deptCode, String deptName);

    boolean deptExists(Department department);
}
