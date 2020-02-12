package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.dao.impl.UserDAOImpl;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.ReasonService;
import vn.vissoft.portal.services.TimeOffService;
import vn.vissoft.portal.services.UserService;
import vn.vissoft.portal.services.VisrulesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("personal")
public class PersonalController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAOImpl dao;

    @Autowired
    ReasonService reasonService;

    @Autowired
    private TimeOffService timeOffService;

    @Autowired
    private VisrulesService visrulesService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User get = userService.getUserById(id);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("getPersonal/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username) {
        User user = userService.getUserByUserName(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("object/{username}")
    public ResponseEntity<List<Object>> getObjectByUserName(@PathVariable("username") String username) {
        List<Role> lst = userService.getRoleByUserName(username);
        List<Object> list = dao.getObjectNameByUserName(lst);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }

    @GetMapping("/reasonsLeave")
    public ResponseEntity<ApiResponse> getReasonsForLeave() {
        ApiResponse object = new ApiResponse();
        List<Reason> list = reasonService.getReasonsForLeave();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping("getAllUser")
    public ResponseEntity<ApiResponse> getAllUsers() {
        ApiResponse object = new ApiResponse();
        List<User> list = userService.getAllUsers();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            String webappRoot = "E:\\vis-portal\\VP-Frontend\\src\\assets\\";
            String filename = webappRoot + fileName;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            return new ResponseEntity<String>("not ok", HttpStatus.OK);
        }
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @PutMapping("updatePassword")
    public ResponseEntity<User> updatePassword(@RequestBody User user) {
        userService.updatePassword(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("updateByUser")
    public ResponseEntity<User> updateByUser(@RequestBody User user) {
        userService.updateByUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/getRoleById/{id}")
    public ResponseEntity<Role> getRoleByRoleId(@PathVariable("id") Integer id) {
        Role get = userService.getRoleByRoleId(id);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("/getUserByMrgLv2/{managerLv2}")
    public ResponseEntity<User> getUserByMrgLv2(@PathVariable("managerLv2") String manager) {
        User get = userService.getManagerLv2ByUserCode(manager);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("/getUserByMrg/{manager}")
    public ResponseEntity<User> getUserByMrg(@PathVariable("manager") String manager) {
        User get = userService.getUserByMrg(manager);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("timeOff/{idUser}")
    public ResponseEntity<ApiResponse> getTimeOffByUserID(@PathVariable("idUser") Integer idUser) {
        ApiResponse object = new ApiResponse();
        List<TimeOff> list = timeOffService.findByRtUser(idUser);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping("getAlls")
    public ResponseEntity<ApiResponse> getAllVisrules() {
        try {
            ApiResponse object = new ApiResponse();

            List<Visrules> list = visrulesService.getall();
            object.setCode(200);
            object.setErrors(null);
            object.setStatus(true);
            object.setData(list);
            return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
