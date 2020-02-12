package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    User getManagerLv2ByUserCode(String code);

    List<User> getAllUsers();

    List<User> CheckDuplicateUserCode();

    List<User> getListUserName(String username);

    User getUserById(int id);

    User getUserByCode1(String code);

    List<User> getAllMrg();

    User getUserByMrg(String manager);

    User getUserByUserName(String user_name);

    List<Role> getRoleByUserName(String username);

    Role getRoleByRoleId(Integer id);

    boolean addUser(User user);

    public boolean addUserTest(User user);

    void updateUser(User user);

    void updatePassword(User user);

    void updateByUser(User user);

    void updateTotalTimeOffOfUser(User user);

    void deleteUserByUsername(String user_name);

    boolean authenUser(String username, String password);

    List<User> SearchUserByCondition(String code,
                                     String username, String fullName, String manager, String email, String deptCode,
                                     Integer titleId);

    int getRowCount(String username, String email);

    List<Role> getRoleNameByUserName(String username);

    User getUserByCode(String code);

    List<User> findUserByRole(String roleCode);

    void deleteUserById(Integer id);

    List<Object[]> getEmailOfUserHr();

    EmpWorkDetail getEWDByUserCodeAndWorkDay(String code, String date) throws ParseException;

    List<Contract> getTimeOffLaborOfUser();

    List<User> getUserByDeptId(Integer deptId);

    User findByEmail(String email);
}
