package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vissoft.portal.dao.ContractTypeDAO;
import vn.vissoft.portal.entities.ContractType;
import vn.vissoft.portal.repositories.ContractReponsitory;
import vn.vissoft.portal.services.ContractTypeService;
import vn.vissoft.portal.services.UploadFileConTy;
import vn.vissoft.portal.services.impl.ContractTypeServiceimpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ContractType")
public class ContractTypeController {

    @Autowired
    private ContractTypeServiceimpl contractTypeServiceimpl;
    @Autowired
    private ContractReponsitory contractReponsitory;
    @Autowired
    private ContractTypeDAO contractTypeDao;
    @Autowired
    private ContractTypeService contractTypeService;

    @GetMapping("/getAllConType")
    public ResponseEntity<List<ContractType>> getAllConType() {
        return new ResponseEntity<List<ContractType>>(contractTypeService.getAllConType(), HttpStatus.OK);
    }

    @PostMapping("/addConType")
    public ResponseEntity<ContractType> addConType(@RequestBody ContractType contractType) {
        contractTypeService.addConType(contractType);
        return new ResponseEntity<ContractType>(contractType, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ContractType> updateConType(@RequestBody ContractType contractType) {
        contractTypeService.updateConType(contractType);
        return new ResponseEntity<ContractType>(contractType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ContractType> deleteConType(@PathVariable(name = "id") Integer id) {
        contractTypeService.deleteConType(id);
        return new ResponseEntity<ContractType>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<ContractType>> search(@RequestBody ContractType contractType) {
        List<ContractType> list = (List<ContractType>) contractTypeServiceimpl.getSearchConTy(contractType.getCtName(), contractType.getContract_code());
        return new ResponseEntity<List<ContractType>>(list, HttpStatus.OK);
    }


    @Autowired
    private UploadFileConTy uploadFileConTy;

    @PostMapping("/post")
    public ResponseEntity<String> handlefileUpload(@RequestParam("file") MultipartFile file) {
        List<String> files = new ArrayList<String>();
        String mess = "";
        try {
            uploadFileConTy.storeUpConty(file);
            files.add(file.getOriginalFilename());
            mess = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(mess);
        } catch (Exception e) {
            mess = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mess);
        }
    }
}
