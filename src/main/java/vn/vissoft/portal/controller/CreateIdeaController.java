package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.CreateIdea;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.CreateIdeaService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("createIdea")
public class CreateIdeaController {



    @Autowired
    private CreateIdeaService createIdeaService;

    @RequestMapping("/getAllCreateIdea")
    public ResponseEntity<ApiResponse> getAllCreateIdea() {
        ApiResponse object = new ApiResponse();
        List<CreateIdea> list = createIdeaService.getAllCreateIdea();
        object.setCode(200);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getCreateIdeaById/{id}")
    public ResponseEntity<ApiResponse> getCreateIdeaById(@PathVariable(name = "id") Integer id){
        ApiResponse object = new ApiResponse();
        CreateIdea list = createIdeaService.getCreateIdeaById(id);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @GetMapping("/getCreateIdeaByUserId/{userId}")
    public ResponseEntity<ApiResponse> getCreateIdeaByUserId(@PathVariable(name = "userId") Integer userId){
        ApiResponse object = new ApiResponse();
        List<CreateIdea> list = createIdeaService.getCreateIdeaByUserId(userId);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("/addCreateIdea")
    public ResponseEntity<CreateIdea> addCreateIdea(@RequestBody CreateIdea createIdea) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        createIdea.setContentIdea(createIdea.getContentIdea());
        createIdea.setStatus(createIdea.getStatus());
        createIdea.setUser(createIdea.getUser());
        createIdea.setStartDate(df.parse(df.format(createIdea.getStartDate())));
        createIdea.setEndDate(df.parse(df.format(createIdea.getEndDate())));
        createIdeaService.addCreateIdea(createIdea);
        return new ResponseEntity<>(createIdea, HttpStatus.CREATED);
    }

    @PutMapping("/updateCreateIdea")
    public ResponseEntity<CreateIdea> updateCreateIdea(@RequestBody CreateIdea createIdea) {
        createIdeaService.updateCreateIdea(createIdea);
        return new ResponseEntity<>(createIdea, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCreateIdea/{id}")
    public ResponseEntity<Void> deleteCreateIdea(@PathVariable(name = "id") Integer id) {
        createIdeaService.deleteCreateById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
