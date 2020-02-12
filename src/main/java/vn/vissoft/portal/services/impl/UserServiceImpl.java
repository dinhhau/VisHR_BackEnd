package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.services.UserService;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {


    @Autowired
    private UserDAO userDao;

    @Override
    public User getManagerLv2ByUserCode(String code) {
        return userDao.getManagerLv2ByUserCode(code);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userDao.getAllUsers();
    }

    @Override
    public List<User> CheckDuplicateUserCode() {
        return userDao.CheckDuplicateUserCode();
    }

    @Override
    public List<User> getListUserName(String username) {
        return userDao.getListUserName(username);
    }

    @Override
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByCode1(String code) {
        return userDao.getUserByCode(code);
    }

    @Override
    public List<User> getAllMrg() {
        return userDao.getAllMrg();
    }

    @Override
    public User getUserByMrg(String manager) {
        return userDao.getUserByMrg(manager);
    }

    @Override
    public User getUserByUserName(String user_name) {
        // TODO Auto-generated method stub
        return userDao.getUserByUserName(user_name);
    }

    @Override
    public List<Role> getRoleByUserName(String username) {
        return userDao.getRoleNameByUserName(username);
    }

    @Override
    public Role getRoleByRoleId(Integer id) {
        return userDao.getRoleByRoleId(id);
    }

    @Override
    public synchronized boolean addUser(User user) {
        // TODO Auto-generated method stub
        if (userDao.userExists(user)) {
            return false;
        } else {
            userDao.addUser(user);
            return true;
        }
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        userDao.updateUser(user);
    }

    @Override
    public void updatePassword(User user) {
        // TODO Auto-generated method stub
        userDao.updatePassword(user);
    }

    @Override
    public void updateByUser(User user) {
        // TODO Auto-generated method stub
        userDao.updateByUser(user);
    }

    @Override
    public void updateTotalTimeOffOfUser(User user) {
        userDao.updateTotalTimeOffOfUser(user);
    }

    @Override
    public void deleteUserByUsername(String user_name) {
        // TODO Auto-generated method stub
        userDao.deleteUserByUsername(user_name);
    }

    @Override
    public boolean authenUser(String username, String password) {
        // TODO Auto-generated method stub
        return userDao.authenUser(username, password);
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userDao.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<Role> list = userDao.getRoleNameByUserName(user.getUsername());
        List<Object> lst = userDao.getObjectNameByUserName(list);
        String au[] = {"ADMIN", "USER"};
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (int i = 0; i < lst.size(); i++) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + lst.get(i).getObjectCode()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.returnPassword(), grantedAuthorities);
    }

    @Override
    public List<User> SearchUserByCondition(String code,
                                            String username, String fullName, String manager, String email, String deptCode,
                                            Integer titleId) {

        // TODO Auto-generated method stub
        return userDao.SearchUserByCondition(
                code, username, fullName, manager, email, deptCode, titleId);
    }

    @Override
    public void deleteUserById(Integer id) {
        // TODO Auto-generated method stub
        userDao.deleteUserById(id);
    }

    @Override
    public List<java.lang.Object[]> getEmailOfUserHr() {
        return userDao.getEmailOfUserHR();
    }

    @Override
    public EmpWorkDetail getEWDByUserCodeAndWorkDay(String code, String date) throws ParseException {
        return userDao.getEWDByUserCodeAndWorkDay(code, date);
    }

    @Override
    public List<Role> getRoleNameByUserName(String username) {
        return userDao.getRoleNameByUserName(username);
    }

    @Override
    public User getUserByCode(String code) {
        List<User> list = userDao.getAllUsers();
        for (User u : list) {
            if (u.getCode().equals(code)) {
                return u;
            }
        }

        return new User();
    }

    @Override
    public List<User> findUserByRole(String roleCode) {
        return userDao.findUserByRoleCode(roleCode);
    }

    @Override
    public int getRowCount(String username, String email) {
        // TODO Auto-generated method stub
        return userDao.getRowCount(username, email);
    }

    @Override
    public boolean addUserTest(User user) {
        if (user.getId() == null) {
            return false;
        }
        if (!(user.getId() > 0)) {
            return false;
        }
        if ((user.getCode() == "")) {
            return false;
        }
        if (user.getUsername() == "") {
            return false;
        }
        if (user.getUsername().length() > 255) {
            return false;
        }
        if (user.getPassword() == "") {
            return false;
        }
        if (user.getPassword().length() < 6) {
            return false;
        }
        if (user.getPassword().length() > 50) {
            return false;
        }
        if (user.getEmail() == "") {
            return false;
        }
        if (user.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            return false;
        }
        if (user.getFullName() == "") {
            return false;
        }
        if (user.getFullName().length() > 255) {
            return false;
        }
        if (user.getManager() == "") {
            return false;
        }
        if (user.getBirthDay() == null) {
            return false;
        }
        if (user.getAddress() == "") {
            return false;
        }
        user.setStatus(1);
        userDao.addUser(user);
        return true;

    }

    @Override
    public List<Contract> getTimeOffLaborOfUser() {
        return userDao.getTimeOffLaborOfUser();
    }

    @Override
    public List<User> getUserByDeptId(Integer deptId) {
        return userDao.getUserByDeptId(deptId);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
