package vn.vissoft.portal.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import vn.vissoft.portal.dao.impl.DepartmentDAOImpl;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.ContractReponsitory;
import vn.vissoft.portal.repositories.ContractTypeReponsitory;
import vn.vissoft.portal.services.ContractService;
import vn.vissoft.portal.services.FillDataService;
import vn.vissoft.portal.services.StorageService;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("contracts")
public class ContractController {

    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    StorageService storageService;

    @Autowired
    FillDataService fillsv;

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractTypeReponsitory contractReponsitory;

    @Autowired
    private ContractReponsitory contractRepon;

    @Autowired
    private DepartmentDAOImpl dpm;

    @GetMapping("getAllContracts")
    public ResponseEntity<ApiResponse> getAllContract() {
        ApiResponse object = new ApiResponse();
        List<Contract> list = contractService.getAllContract();
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }
    @GetMapping("getnodelete")
    public ResponseEntity<ApiResponse> getall() {
        ApiResponse object = new ApiResponse();
        List<Contract> list = contractRepon.findAll();
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Contract> addCon(@RequestBody Contract contract) {
        contractService.addCon(contract);
        return new ResponseEntity<Contract>(contract, HttpStatus.OK);
    }

    @GetMapping("department")
    public ResponseEntity<List<Department>> getDept() {
        return new ResponseEntity<List<Department>>(dpm.getAllDept(), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Contract> updateCon(@RequestBody Contract contract) {
        contractService.updateCon((contract));
        return new ResponseEntity<Contract>(contract, HttpStatus.OK);
    }

    @DeleteMapping("delete/{cId}")
    public ResponseEntity<Void> delCon(@PathVariable("cId") int cId) {
        contractService.delCon(cId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("ContractType/add")
    public ResponseEntity<ContractType> addCon(@RequestBody ContractType contractType) {
        contractReponsitory.save(contractType);
        return new ResponseEntity<ContractType>(contractType, HttpStatus.OK);
    }

    @GetMapping("getAllContractType")
    public ResponseEntity<List<ContractType>> getAllContractType() {
        return new ResponseEntity<List<ContractType>>(contractReponsitory.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Contract> getById(@PathVariable("id") int id) {
        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
        Contract contract = contractService.getAllById(id);
        try {
            contract.setStartdate(formatdate.parse(formatdate.format(contract.getStartdate())));
        } catch (Exception e) {
            LOG.error(String.valueOf(e));
        }
        return new ResponseEntity<Contract>(contract, HttpStatus.OK);
    }

    @GetMapping("getContractByCondition")
    public ResponseEntity<ApiResponse> SearchContractByCondition(
            @RequestParam(value = "contractTypeId", required = false) Integer contractTypeId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "deptId", required = false) Integer deptId,
            @RequestParam(value = "startDateFrom", required = false) String startDateFrom,
            @RequestParam(value = "startDateTo", required = false) String startDateTo,
            @RequestParam(value = "endDateFrom", required = false) String endDateFrom,
            @RequestParam(value = "endDateTo", required = false) String endDateTo) {

        ApiResponse object = new ApiResponse();
        List<Contract> list = contractService.SearchContractByCondition(contractTypeId, userId, deptId, startDateFrom, startDateTo, endDateFrom, endDateTo);

        object.setCode(200);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("search")
    public ResponseEntity<List<Contract>> getSearch(@RequestBody ContractFind contract) {
        List<Contract> lst = contractService.getSearch(contract.getCtype(), contract.getcUser(), contract.getCno(), contract.getDepartment(), contract.getStartDate(), contract.getEndDate(), contract.getStatus());
        List<Contract> list = new ArrayList<>();
        if (lst != null) {
            for (int a = 0; a < lst.size(); a++) {
                list.add((lst.get(a)));
            }
            return new ResponseEntity<List<Contract>>(lst, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Contract>>(lst, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getcontracts/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getCFile(@PathVariable String filename) {
        Resource file = storageService.loadPDF(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
    @PostMapping("/filldata/{type:.+}")
    public ResponseEntity<String> Fill(@PathVariable("type") String type,@RequestBody FillData fill) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        fill.setBirthday(fill.getBirthday().substring(8,10)+"/"+fill.getBirthday().substring(5,7)+"/"+fill.getBirthday().substring(0,4));
        fill.setDatecmt(fill.getDatecmt().substring(8,10)+"/"+fill.getDatecmt().substring(5,7)+"/"+fill.getDatecmt().substring(0,4));
        fill.setStartdate(fill.getStartdate().substring(8,10)+"/"+fill.getStartdate().substring(5,7)+"/"+fill.getStartdate().substring(0,4));
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        if (!type.equals("CTV.docx")) {
            fill.setSalary(vn.format(Integer.parseInt(fill.getSalary())));
        }
        if(fill.getEnddate().length()>=10){
            fill.setEnddate(fill.getEnddate().substring(8,10)+"/"+fill.getEnddate().substring(5,7)+"/"+fill.getEnddate().substring(0,4));
        }
        if(fill.getValidity().length()>5){
            fill.setValidity(fill.getValidity().substring(8,10)+"/"+fill.getValidity().substring(5,7)+"/"+fill.getValidity().substring(0,4));
        }
        fillsv.meo(fill);
        fillsv.fill(contractService.getByCode(fill.getContractcode()).getcId()+".docx",type);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getFileXML")
    @ResponseBody
    public ResponseEntity<Resource> getFile() {
        try {
            Path filePath = Paths.get("/home/vishr/VIS-HR/HR-Frontend/webapps/upload/XML/contract.xml");
            Resource resource = new UrlResource(filePath.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"MappingPanel.xml\"")
                    .body(resource);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
