package vn.vissoft.portal.controller;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.DepartmentService;
import vn.vissoft.portal.services.StorageService;
import vn.vissoft.portal.services.TitleService;
import vn.vissoft.portal.services.UserService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TUYENLH UserController
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TitleService titleService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    StorageService storageService;

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username) {
        User user = userService.getUserByUserName(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }



    @GetMapping("/getListUsername/{username}")
    public ResponseEntity<ApiResponse> getListUserName(@PathVariable("username") String username) {
        ApiResponse object = new ApiResponse();
        List<User> list = userService.getListUserName(username);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
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

    @GetMapping("CheckDuplicateUserCode")
    public ResponseEntity<ApiResponse> CheckDuplicateUserCode() {
        ApiResponse object = new ApiResponse();
        List<User> list = userService.CheckDuplicateUserCode();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User get = userService.getUserById(id);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("getUserByDeptId/{id}")
    public ResponseEntity<ApiResponse> getUserByDeptId(@PathVariable("id") Integer id) {
        ApiResponse object = new ApiResponse();
        List<User> list = userService.getUserByDeptId(id);object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("code/{code}")
    public ResponseEntity<User> getUserByCode(@PathVariable("code") String code) {
        User get = userService.getUserByCode1(code);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("/getUserByMrg/{manager}")
    public ResponseEntity<User> getUserByMrg(@PathVariable("manager") String manager) {
        User get = userService.getUserByMrg(manager);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("/getRoleById/{id}")
    public ResponseEntity<Role> getRoleByRoleId(@PathVariable("id") Integer id) {
        Role get = userService.getRoleByRoleId(id);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @GetMapping("/getAllMrg")
    public ResponseEntity<ApiResponse> getAllMrg() {
        ApiResponse object = new ApiResponse();
        List<User> list = userService.getAllMrg();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
    @GetMapping("getUsersByCondition")
    public ResponseEntity<ApiResponse> SearchUserByCondition(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "manager", required = false) String manager,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @RequestParam(value = "titleId", required = false) Integer titleId) {

        ApiResponse object = new ApiResponse();
        List<User> list = userService.SearchUserByCondition(
                code, username, fullName, manager, email, deptCode, titleId);
        int rowCount = userService.getRowCount(username, email);

        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        object.setTotalRow(rowCount);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }


    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
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

    @DeleteMapping("deleteByName/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable("username") String userName) {
        userService.deleteUserByUsername(userName);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("getRoleNameByUserName/{username}")
    public ResponseEntity<List<Role>> getRoleNameByUserName(@PathVariable String username) {
        List<Role> list = userService.getRoleNameByUserName(username);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping("/getAllTitle")
    public ResponseEntity<ApiResponse> getAllTitle() {
        ApiResponse object = new ApiResponse();
        List<Title> list = titleService.getAllTitle();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @RequestMapping("/getAllDept")
    public ResponseEntity<ApiResponse> getAllDept() {
        ApiResponse object = new ApiResponse();
        List<Department> list = departmentService.getAllDept();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    List<String> files = new ArrayList<String>();

    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/getAllFiles")
    public ResponseEntity<List<String>> getListFiles(Model model) {
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(UploadController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(fileNames);
    }

    @GetMapping("getTest/{code}/{date}")
    public ResponseEntity<EmpWorkDetail> getTest(@PathVariable(name = "code") String code, @PathVariable(name = "date") String date) throws ParseException {
        EmpWorkDetail empWorkDetail = userDAO.getEWDByUserCodeAndWorkDay(code, date);
        return new ResponseEntity<EmpWorkDetail>(empWorkDetail, HttpStatus.OK);
    }
}
