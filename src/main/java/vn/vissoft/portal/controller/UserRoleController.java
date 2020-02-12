package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.entities.UserRole;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.UserRoleService;
import vn.vissoft.portal.services.UserService;

import java.util.List;

@Controller
@RequestMapping("userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUserRole")
    public ResponseEntity<ApiResponse> getAllUserRole() {
        ApiResponse object = new ApiResponse();
        List<UserRole> list = userRoleService.getAllUserRole();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @RequestMapping("/getRoleById/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(name = "id") Integer id) {
        Role role = userRoleService.getRoleByUserId(id);
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    @RequestMapping("/getUserRoleById/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable(name = "id") Integer id) {
        UserRole userRole = userRoleService.getUserRoleByUserId(id);
        return new ResponseEntity<UserRole>(userRole, HttpStatus.OK);
    }

    @PostMapping("/addUserRole")
    public ResponseEntity<User> addUser(@RequestBody UserRole userRole) {
        userRoleService.addUserRole(userRole);
        userService.getUserByUserName(userRole.getUser().getUsername());
        return new ResponseEntity<User>(userService.getUserByUserName(userRole.getUser().getUsername()), HttpStatus.CREATED);
    }

    @PutMapping("/updateUserRole")
    public ResponseEntity<UserRole> updateDept(@RequestBody UserRole userRole) {
        userRoleService.updateUserRole(userRole);
        return new ResponseEntity<UserRole>(userRole, HttpStatus.OK);
    }
}
