package vn.vissoft.portal.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.vissoft.portal.dao.impl.UserDAOImpl;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.ReportEmpRepository;
import vn.vissoft.portal.services.OutputReportemp;
import vn.vissoft.portal.services.ReportEmpService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Api(hidden = true)
@RequestMapping("Report_emp")
public class ReportEmpController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportEmpController.class);

    @Value("${config.path_upload}")
    private String urlUpload;

    @Autowired
    private ReportEmpService reportEmpService;

    @Autowired
    private OutputReportemp outputReportemp;
    private List<ReportEmp> ReportEmprp = new ArrayList<>();

    public List<ReportEmp> getReportEmprp() {
        return ReportEmprp;
    }

    public void setReportEmprp(List<ReportEmp> reportEmprp) {
        ReportEmprp = reportEmprp;
    }

    @GetMapping("getAlls")
    public ResponseEntity<ApiResponse> getAllReportEmp() {
        ApiResponse object = new ApiResponse();

        List<ReportEmp> list = reportEmpService.getAll();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("AddRpEmp")

    public ResponseEntity<Void> addReportEmp(@RequestBody ReportEmp reportEmp, UriComponentsBuilder builder) {
        boolean flag = reportEmpService.addReportEmp(reportEmp);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("report_emp/{id}").buildAndExpand(reportEmp.getReID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);

    }

    @PutMapping("Update_RpEmp")
    public ResponseEntity<Void> updateReport_emp(@RequestBody ReportEmp reportEmp) {
        reportEmpService.updateReport_emp(reportEmp);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReportEmp> getEmpById(@PathVariable("id") int id) {
        ReportEmp e = reportEmpService.getRe_empbyReEmp_id(id);
        return new ResponseEntity<ReportEmp>(e, HttpStatus.OK);
    }

    @GetMapping("SearchReportEmpbyCodition")
    public ResponseEntity<ApiResponse> searchEmpByCondition(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "columnSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "reUser", required = false) Integer reUser,
            @RequestParam(value = "reReason", required = false) Integer reReason,
            @RequestParam(value = "reCreateDate", required = false) String reCreateDate,
            @RequestParam(value = "reportstatushide", required = false) Integer hider
    ) {
        ApiResponse api = new ApiResponse();
        List<ReportEmp> lstRpE = reportEmpService.searchReEmpByCondition(page, pageSize, columnSortName, asc, reUser, reReason, hider, reCreateDate);
        this.setReportEmprp(lstRpE);

        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lstRpE);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);

    }

    @GetMapping("dowloadReportrp")
    public ResponseEntity<Resource> downloadFile() throws Exception {

        outputReportemp.createrpReport(this.getReportEmprp());

        Path filePath = Paths.get(urlUpload +  "reportemp");
//        Path filePath = Paths.get("upload/ReportEmp/");
        Path file = filePath.resolve(outputReportemp.getFileName());
        Resource resource = new UrlResource(file.toUri());

        String contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("deleteReport_empbyID/{reID}")
    public ResponseEntity<Void> deleteReport_emp_byid(@PathVariable("reID") Integer rID) {
        reportEmpService.deleteReport_emp_byid(rID);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @DeleteMapping("ConfirmReport/{reID}")
    public ResponseEntity<Void> confirmReport(@PathVariable("reID") Integer rID) {
        reportEmpService.confirmReport(rID);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
