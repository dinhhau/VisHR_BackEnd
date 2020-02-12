package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.DashboardService;
import vn.vissoft.portal.services.TotalLaborService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("DashBoard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private TotalLaborService totalLaborService;

    @GetMapping("GetLateWorkEmp")
    public ResponseEntity<ApiResponse> getLateEmpWork() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getLateWorkEmp();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getBirtDay")
    public ResponseEntity<ApiResponse> getBirtDay() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getUserBirthdayByMounth();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getContractOld")
    public ResponseEntity<ApiResponse> getcontractOld() {
        ApiResponse object = new ApiResponse();
        List<Contract> list = dashboardService.getContractsOLD();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getBonusEmpinMonth")
    public ResponseEntity<ApiResponse> getBonusempinMonth() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getBonusempinMonth();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getBonusEmpinDay")
    public ResponseEntity<ApiResponse> getBonusempinday() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getBonusempinday();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getBonusempinYear")
    public ResponseEntity<ApiResponse> getBonusempinYear() {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getBonusempinYear();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);

    }

    @GetMapping("getEmpworkCountLate")
    public ResponseEntity<ApiResponse> getEmpworkCountLate(@RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkCountLate(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEmpworkCountSoon")
    public ResponseEntity<ApiResponse> getEmpworkCountSoon(@RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkCountSoon(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEmpworkCountTimeoff")
    public ResponseEntity<ApiResponse> getEmpworkCountTimeoff(
            @RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkCountTimeoff(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEmpworkDetailLate")
    public ResponseEntity<ApiResponse> getEmpworkDetailLate(
            @RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkDetailLate(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEmpworkDetailSoon")
    public ResponseEntity<ApiResponse> getEmpworkDetailSoon(
            @RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkDetailSoon(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEmpworkDetailTimeoff")
    public ResponseEntity<ApiResponse> getEmpworkDetailTimeoff(
            @RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getEmpworkDetailTimeoff(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getTotalLabor")
    public ResponseEntity<ApiResponse> getTotalLabor(@RequestParam(value = "id", required = true) String usercoder

    ) {
        ApiResponse object = new ApiResponse();
        List<Object[]> list = dashboardService.getTotalLabor(usercoder);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getTotalLaborDetail")
    public ResponseEntity<ApiResponse> getTotalLaborDetail(
    		@RequestParam(value = "id", required = true) String usercoder


    ) {
		SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
		String date = df.format(new Date());
        ApiResponse object = new ApiResponse();
        List<EmpWorkDetail> list = totalLaborService.getDetailLaborByUserCode(usercoder,date);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }


}
