package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.services.impl.ObjectServiceImpl;

import java.util.List;

@RestController
@RequestMapping("object")
public class ObjectController {
    @Autowired
    private ObjectServiceImpl objsv;

    @GetMapping("")
    public ResponseEntity<List<Object>> getAllTitle() {
        List<Object> lst = (List<Object>) objsv.getAllObject();
        return new ResponseEntity<List<Object>>(lst, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Object>> find(@RequestBody Object obj) {
        List<Object> lst = (List<Object>) objsv.findObject(obj.getObjectCode(), obj.getObjectName(), obj.getObjectUrl(), obj.getObject_icon());
        return new ResponseEntity<List<Object>>(lst, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Object obj) {
        objsv.update(obj);
        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Object obj) {
        objsv.save(obj);
        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }
}
