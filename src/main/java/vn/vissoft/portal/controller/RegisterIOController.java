package vn.vissoft.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.Time_work;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.RegisterRepository;
import vn.vissoft.portal.services.RegisterIOService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/RegisterIO/")
public class RegisterIOController {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    RegisterIOService registerIOService;

    @GetMapping("getRequestByuser/{userid}")
    public ResponseEntity<ApiResponse> getbyUser(@PathVariable("userid") Integer userid) {
        ApiResponse object = new ApiResponse();
        List<Time_work> listTW = registerRepository.getallRequestByUser(userid);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(listTW);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }



    @GetMapping("getRequestByManager/{usercode}")
    public ResponseEntity<ApiResponse> getByManager(@PathVariable("usercode") String userCode) {
        ApiResponse object = new ApiResponse();
        List<Time_work> listTW = registerRepository.getRequestByManager(userCode);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(listTW);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getRequestByAdmin")
    public ResponseEntity<ApiResponse> getByAdmin() {
        ApiResponse object = new ApiResponse();
        List<Time_work> listTW = registerRepository.getallByAdmin();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(listTW);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }


    @GetMapping("createTW")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ApiResponse createTimeWork(@Valid @RequestBody Time_work time_work) throws ParseException {
        List<java.lang.Object[]> listDate = registerIOService.getListDate(time_work.getsDate(),time_work.geteDate());
        if(listDate.size()-1 < 30){
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_RESET_CONTENT, false, "No content",
                    null);
            return apiResponse;
        }
        boolean checkDuplicate = registerIOService.getAllbyUserid(time_work.getEmployee().getId(),time_work.geteDate());
        if(checkDuplicate == false){

            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content",
                    null);
            return apiResponse;
        }
        if(time_work!=null){
            time_work.setStatus(2);
            registerIOService.createOrupdateRegesterIO(time_work);
            return ApiResponse.build(HttpServletResponse.SC_OK, false, "No content",
                    time_work);
        }
        return ApiResponse.build(HttpServletResponse.SC_ACCEPTED, false, "No content",
                null);
    }


}
