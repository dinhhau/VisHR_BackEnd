package vn.vissoft.portal.controller;

import org.apache.poi.ss.formula.functions.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.RateIdea;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.RateIdeaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("rateIdea")
public class RateIdeaController {

    @Autowired
    private RateIdeaService rateIdeaService;

    @RequestMapping("/getAllRateIdea")
    public ResponseEntity<ApiResponse> getAllRateIdea() {
        ApiResponse object = new ApiResponse();
        List<RateIdea> list = rateIdeaService.getAllRateIdea();
        object.setCode(200);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getRateIdeaById/{id}")
    public ResponseEntity<ApiResponse> getRateIdeaById(@PathVariable(name = "id") Integer id){
        ApiResponse object = new ApiResponse();
        List<RateIdea> list = rateIdeaService.getRateIdeaById(id);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getRateIdeaByUserId/{userId}")
    public ResponseEntity<ApiResponse> getRateIdeaByUserId(@PathVariable(name = "userId") Integer userId){
        ApiResponse object = new ApiResponse();
        List<RateIdea> list = rateIdeaService.getRateIdeaByUserId(userId);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getRateIdeaByCreateIdeaId/{createIdeaId}")
    public ResponseEntity<ApiResponse> getRateIdeaByCreateIdeaId(@PathVariable(name = "createIdeaId") Integer createIdeaId){
        ApiResponse object = new ApiResponse();
        List<RateIdea> list = rateIdeaService.getRateIdeaByCreateIdeaId(createIdeaId);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getRateIdeaByCreateIdeaIdAndUserId/{userId}/{createIdeaId}")
    public ResponseEntity<ApiResponse> getRateIdeaByCreateIdeaId(@PathVariable(name = "createIdeaId") Integer createIdeaId,
                                                                 @PathVariable(name = "userId") Integer userId){
        ApiResponse object = new ApiResponse();
        Optional<RateIdea> optionalRateIdea = rateIdeaService.getRateIdeaByUserIdAndCreateIdeaId(userId, createIdeaId);
        RateIdea rateIdea;
        if (optionalRateIdea.isPresent()) {
            rateIdea = rateIdeaService.getRateIdeaByUserIdAndCreateIdeaId(userId, createIdeaId).get();
        } else {
            rateIdea = null;
        }
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(rateIdea);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("/addRateIdea/{userId}/{createIdeaId}")
    public ResponseEntity<RateIdea> addRateIdea(@RequestBody RateIdea rateIdea, @PathVariable(name = "userId") Integer userId, @PathVariable(name = "createIdeaId") Integer createIdeaId) {
        rateIdeaService.addRateIdea(rateIdea, userId, createIdeaId);
        return new ResponseEntity<>(rateIdea, HttpStatus.CREATED);
    }

    @PutMapping("/updateRateIdea")
    public ResponseEntity<RateIdea> updateRateIdea(@RequestBody RateIdea rateIdea) {
        rateIdeaService.updateRateIdea(rateIdea);
        return new ResponseEntity<>(rateIdea, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRateIdea/{id}")
    public ResponseEntity<Void> deleteRateIdea(@PathVariable(name = "id") Integer id) {
        rateIdeaService.deleteRateIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
