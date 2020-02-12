package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.EvaluateKPI;
import vn.vissoft.portal.entities.KPI;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.EvaluateKPIService;
import java.util.List;

@Controller
@RequestMapping("evaluateKPI")
public class EvaluateKPIController {

    @Autowired
    private EvaluateKPIService evaluateKPIService;

    @GetMapping("getAllEvaluateKPI")
    public ResponseEntity<ApiResponse> getAllEvaluateKPI() {
        ApiResponse object = new ApiResponse();
        List<EvaluateKPI> list = evaluateKPIService.getAllKPI();
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getAllKPI")
    public ResponseEntity<ApiResponse> getAllKPI() {
        ApiResponse object = new ApiResponse();
        List<KPI> list = evaluateKPIService.getAllByKPI();
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEvaluateKPIForManager/{manager}")
    public ResponseEntity<ApiResponse> getEvaluateKPIForManager(@PathVariable(name = "manager") String manager) {
        ApiResponse object = new ApiResponse();
        List<EvaluateKPI> list = evaluateKPIService.getKPIForManager(manager);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEvaluateKPIForUser/{user}")
    public ResponseEntity<ApiResponse> getEvaluateKPIForUser(@PathVariable(name = "user") Integer user) {
        ApiResponse object = new ApiResponse();
        List<EvaluateKPI> list = evaluateKPIService.getKPIForUser(user);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("getEvaluateKPIById/{id}")
    public ResponseEntity<ApiResponse> getEvaluateKPIById(@PathVariable(name = "id") Integer id) {
        ApiResponse object = new ApiResponse();
        EvaluateKPI list = evaluateKPIService.getKPIById(id);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("searchByName/{name}")
    public ResponseEntity<ApiResponse> searchByName(@PathVariable(name = "name") String name) {
        ApiResponse object = new ApiResponse();
        List<EvaluateKPI> list = evaluateKPIService.searchByName(name);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("addEvaluateKPI")
    public ResponseEntity<EvaluateKPI> addEvaluateKPI(@RequestBody EvaluateKPI evaluateKPI) {
        evaluateKPIService.addEvaluateKPI(evaluateKPI);
        return new ResponseEntity<>(evaluateKPI, HttpStatus.CREATED);
    }

    @PutMapping("updateEvaluateKPI")
    public ResponseEntity<EvaluateKPI> updateEvaluateKPI(@RequestBody EvaluateKPI evaluateKPI){
        evaluateKPIService.updateEvalueteKPI(evaluateKPI);
        return new ResponseEntity<EvaluateKPI>(evaluateKPI, HttpStatus.OK);
    }

    @DeleteMapping("deleteEvaluateKPIById/{id}")
    public ResponseEntity<Void> deleteEvaluateKPIById(@PathVariable(name = "id") Integer id){
        evaluateKPIService.deleteEvaluateKPI(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
