package vn.vissoft.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.vissoft.portal.entities.ApParam;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.AP_paramService;

@Controller
@RequestMapping("AP_param")
public class ApParamController {
@Autowired
private AP_paramService AP_paramService;
	@GetMapping("GETallByApType")
	public ResponseEntity<ApiResponse> GetAllAPbyType(){
		ApiResponse object = new ApiResponse();
        List<ApParam> list = AP_paramService.getallParamByParType();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
}
