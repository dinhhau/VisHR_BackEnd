package vn.vissoft.portal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.ReasonRepository;
import vn.vissoft.portal.services.ReasonService;

import java.util.List;

@RestController
@RequestMapping("Reason")
public class ReasonController {
    @Autowired
    private ReasonService reasonService;
    @Autowired
    private ReasonRepository reasonRepository;

    @GetMapping("getAlls")
    public ResponseEntity<ApiResponse> getReason() {
        ApiResponse object = new ApiResponse();
        List<Reason> list = reasonService.getAll();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getReasonTimeOff")
    public ResponseEntity<ApiResponse> getReasonTimeOff() {
        ApiResponse object = new ApiResponse();
        List<Reason> list = reasonService.getReasonTimeOff();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getAllshow")
    public ResponseEntity<ApiResponse> getReasonShow() {
        ApiResponse object = new ApiResponse();
        List<Reason> list = reasonService.getAlls();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("addReason")
    public ResponseEntity<Void> addReason(@RequestBody Reason reason, UriComponentsBuilder builder) {
        boolean flag = reasonService.addReason(reason);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("Reason/{id}").buildAndExpand(reason.getrID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);

    }

    @PutMapping("updateReason")
    public ResponseEntity<Void> UpdateReason(@RequestBody Reason reason) {
        reasonService.updateReason(reason);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @DeleteMapping("DeleteByCode/{rCode}")
    public ResponseEntity<Void> deleteReasonbyReasonCode(@PathVariable("rCode") String rcode) {
        reasonService.deletebyReasonCode(rcode);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @GetMapping("getbycode/{rCode}")
    public ResponseEntity<Reason> getReasonByCode(@PathVariable("rCode") String rcode) {
        Reason rs = reasonService.getReasonbyReasonCode(rcode);
        return new ResponseEntity<Reason>(rs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reason> getReasonById(@PathVariable("id") Integer rid) {
        Reason e = reasonService.GetReasonByID(rid);
        return new ResponseEntity<Reason>(e, HttpStatus.OK);
    }

    @GetMapping("SearchReasonbyCodition")
    public ResponseEntity<ApiResponse> searchEmpByCondition(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "columnSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "rCode", required = false) String rCode,
            @RequestParam(value = "rName", required = false) String rName,
            @RequestParam(value = "rType", required = false) Integer rType,
            @RequestParam(value = "rMoney", required = false) Integer rMoney,
            @RequestParam(value = "rStatus", required = false) Integer Rstatus


    ) {
        ApiResponse api = new ApiResponse();
        List<Reason> lstRpE = reasonService.getReasonByCondition(page, pageSize, columnSortName, asc, rCode, rName, rType, rMoney, Rstatus);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lstRpE);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);
    }

    @GetMapping("SearchConditionByReasonCode")
    public ResponseEntity<ApiResponse> searchGenCode(
            @RequestParam(value = "rcode", required = true) String rcode
    ) {
        ApiResponse api = new ApiResponse();
        List<Reason> LstGencode = reasonService.getREasonByCode(rcode);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(LstGencode);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);
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
}
