package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.DepartmentDAO;
import vn.vissoft.portal.entities.Department;
import vn.vissoft.portal.services.DepartmentService;

import java.util.List;

@Service(value = "DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDao;

    @Override
    public List<Department> getAllDept() {
        return departmentDao.getAllDept();
    }

    @Override
    public Department getDeptById(Integer deptId) {
        return departmentDao.getDeptById(deptId);
    }

    @Override
    public void addDept(Department department) {
        departmentDao.addDept(department);
    }

    @Override
    public void updateDept(Department department) {
        departmentDao.updateDept(department);
    }

    @Override
    public void deleteDeptById(Integer deptId) {
        departmentDao.deleteByDeptId(deptId);
    }

    @Override
    public List<Department> searchDeptByCondition(int page, int pageSize, String columnSortName, Boolean asc, String deptCode, String deptName) {
        return departmentDao.searchDeptByCondition(page, pageSize, columnSortName, asc, deptCode, deptName);
    }
}
