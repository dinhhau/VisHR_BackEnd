package vn.vissoft.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.Visrules;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.VisruleRepository;
import vn.vissoft.portal.services.VisrulesService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/visrule/")
public class VisrulesController {
    @Autowired
    private VisrulesService visrulesService;

    @Autowired
    private VisruleRepository visruleRepository;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ApiResponse createRules(@Valid @RequestBody Visrules visrules) throws ParseException {

        boolean flag = visrulesService.addVisrules(visrules);
        if (flag == false) {
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content",
                    null);
            return apiResponse;
        }
        if (flag == true) {
            visrulesService.addVisrules(visrules);
            return ApiResponse.build(HttpServletResponse.SC_OK, false, "No content",
                    visrules);

        }
        return ApiResponse.build(HttpServletResponse.SC_ACCEPTED, false, "No content",
                null);

    }
    @GetMapping("SearchVisrulebyCodition")
    public ResponseEntity<ApiResponse> searchEmpByCondition(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "columnSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "ruleCode", required = false) String rulecode


    ) {
        ApiResponse api = new ApiResponse();
        List<Visrules> lstRpE = visrulesService.searchVisruleEmpByCondition(page, pageSize, columnSortName, asc, rulecode);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lstRpE);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Visrules> getReasonById(@PathVariable("id") Integer rid) {
        Visrules e = visruleRepository.getAllByRuleid(rid);
        return new ResponseEntity<Visrules>(e, HttpStatus.OK);
    }

    @PutMapping("updateVisrules")
    public ResponseEntity<Void> UpdateReason(@RequestBody Visrules visrules) {
        visrulesService.updateVisrules(visrules);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("DeleteByCode/{rCode}")
    public ResponseEntity<Void> deleteReasonbyReasonCode(@PathVariable("rCode") Integer visruleid) {
        visrulesService.deleteVisrules(visruleid);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @GetMapping("getAlls")
    public ResponseEntity<ApiResponse> getAllVisrules() {
        ApiResponse object = new ApiResponse();

        List<Visrules> list = visrulesService.getall();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getAllsbycode/{code}")
    public ResponseEntity<ApiResponse> getAllbyCode(@PathVariable("code") Integer code) {
        ApiResponse object = new ApiResponse();

        List<Visrules> list = visrulesService.getBycode(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }


}
