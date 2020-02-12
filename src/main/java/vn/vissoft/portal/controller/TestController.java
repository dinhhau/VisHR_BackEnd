package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.UserService;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAlls/{username}")
    public ResponseEntity<ApiResponse> getRole(@PathVariable(name = "username") String username) {
        ApiResponse object = new ApiResponse();
        List<Role> list = userService.getRoleByUserName(username);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }
}
