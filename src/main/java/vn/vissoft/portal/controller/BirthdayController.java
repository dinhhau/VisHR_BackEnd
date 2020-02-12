package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.BirthdayEmpService;

import java.util.List;

@Controller
@RequestMapping("Birthday")
public class BirthdayController {
    @Autowired
    private BirthdayEmpService birthdayEmpService;

    @GetMapping("getbyMounth")
    public ResponseEntity<ApiResponse> getBirthday() {
        ApiResponse object = new ApiResponse();
        List<User> list = birthdayEmpService.getUserBirthdayByMounth();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getAge")
    public ResponseEntity<ApiResponse> getAge() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = birthdayEmpService.getAgeEmp();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("GetBirthdaySoon")
    public ResponseEntity<ApiResponse> getSoon() {
        ApiResponse object = new ApiResponse();
        List<Object[]> lst = birthdayEmpService.getBirthdaysoon();
        object.setErrors(null);
        object.setCode(200);
        object.setStatus(true);
        object.setData(lst);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("GetBirthdayRealtime")
    public ResponseEntity<ApiResponse> getBirthdayRealtime() {
        ApiResponse object = new ApiResponse();
        List<Object[]> lst = birthdayEmpService.getBirthdayrealtime();
        object.setErrors(null);
        object.setCode(200);
        object.setStatus(true);
        object.setData(lst);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("GetBirthdaysource2")
    public ResponseEntity<ApiResponse> getBirthdaybysource2() {
        ApiResponse object = new ApiResponse();
        List<Object[]> lst = birthdayEmpService.getNotifybySourceType2();
        object.setErrors(null);
        object.setCode(200);
        object.setStatus(true);
        object.setData(lst);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("GetBirthdaysource3")
    public ResponseEntity<ApiResponse> getBirthdaybysource3() {
        ApiResponse object = new ApiResponse();
        List<Object[]> lst = birthdayEmpService.getNotifybySourceType3();
        object.setErrors(null);
        object.setCode(200);
        object.setStatus(true);
        object.setData(lst);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("SearchBirthdayUser")
    public ResponseEntity<ApiResponse> searchBirthDay(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "colunSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "fromDate", required = false) String fromdate,
            @RequestParam(value = "toDate", required = false) String toDate,
            @RequestParam(value = "status", required = false) Integer status


    ) {
        ApiResponse api = new ApiResponse();
        List<User> LstUr = birthdayEmpService.getUserByCondition(page, pageSize, columnSortName, asc, fromdate, toDate, status);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(LstUr);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);

    }

    @GetMapping("searhbyQuery")
    public ResponseEntity<ApiResponse> searchByQuery(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "colunSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "fromDate", required = false) String fromdate,
            @RequestParam(value = "toDate", required = false) String toDate
    ) {
        ApiResponse api = new ApiResponse();
        List<User> LstUr = birthdayEmpService.SearchBirtday(page, pageSize, columnSortName, asc, fromdate, toDate);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(LstUr);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);


    }


}
