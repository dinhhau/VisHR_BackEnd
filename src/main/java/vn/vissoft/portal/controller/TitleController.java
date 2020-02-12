package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.vissoft.portal.entities.Title;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.TitleRepository;
import vn.vissoft.portal.services.TitleService;
import vn.vissoft.portal.services.impl.TitleServiceImpl;

import java.util.List;

@Controller
@RequestMapping("title")
public class TitleController {

    @Autowired
    private TitleServiceImpl titlesv;
    @Autowired
    private TitleRepository tt;

    @Autowired
    private TitleService titleService;

    @RequestMapping("/getAllTitle")
    public ResponseEntity<ApiResponse> getAllDept() {
        ApiResponse object = new ApiResponse();
        List<Title> list = titleService.getAllTitle();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Title>> find(@RequestBody Title title) {
        List<Title> lst = (List<Title>) titleService.findTitle(title.getTitleCode(), title.getTitleName());
        return new ResponseEntity<List<Title>>(lst, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Title> update(@RequestBody Title title) {
        titleService.update(title);
        return new ResponseEntity<Title>(title, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Title> add(@RequestBody Title title) {
        titleService.save(title);
        return new ResponseEntity<Title>(title, HttpStatus.OK);
    }
}
