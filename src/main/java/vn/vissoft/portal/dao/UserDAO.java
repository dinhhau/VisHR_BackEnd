package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.entities.Object;
import java.text.ParseException;
import java.util.List;

public interface UserDAO {

    User getManagerLv2ByUserCode(String code);

    List<User> getAllUsers();

    List<User> CheckDuplicateUserCode();

    List<User> getListUserName(String username);

    User getUserById(int id);

    User getUserByCode(String code);

    User getUserByUserName(String user_name);

    List<User> getAllMrg();

    User getUserByMrg(String manager);

    List<Role> getRoleNameByUserName(String username);

    Role getRoleByRoleId(Integer id);

    List<Object> getObjectNameByUserName(List<Role> lst);

    boolean addUser(User user);

    void updateUser(User user);

    void updatePassword(User user);

    void updateByUser(User user);

    void updateTotalTimeOffOfUser(User user);

    void deleteUserByUsername(String user_name);

    boolean userExists(User user);

    boolean authenUser(String username, String password);

    List<User> SearchUserByCondition(String code,
                                     String username, String fullName, String manager, String email, String deptCode,
                                     Integer titleId);

    void deleteUserById(Integer id);

    List<User> getUsersByRole(String role);

    List<User> findUserByRoleCode(String roleCode);

    int getRowCount(String username, String email);

    List<java.lang.Object[]> getEmailOfUserHR();

    EmpWorkDetail getEWDByUserCodeAndWorkDay(String code, String date) throws ParseException;

    List<Contract> getTimeOffLaborOfUser();

    List<User> getUserByDeptId(Integer deptId);

    User findByEmail(String email);
}
