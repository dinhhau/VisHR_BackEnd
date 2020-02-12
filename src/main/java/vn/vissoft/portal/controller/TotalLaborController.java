package vn.vissoft.portal.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.entities.TimeoffLabor;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.helper.TotalLaborRespone;
import vn.vissoft.portal.services.OutputTotalLabor;
import vn.vissoft.portal.services.TimeOffLaborService;
import vn.vissoft.portal.services.TotalLaborService;

@RestController
@RequestMapping("totalLabor")
public class TotalLaborController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportEmpController.class);

    @Value("${config.path_upload}")
    private String urlUpload;

    private List<TotalLaborRespone> totalLabor = new ArrayList<>();

    public List<TotalLaborRespone> getTotalLabor() {
        return totalLabor;
    }

    public void setTotalLabor(List<TotalLaborRespone> totalLabor) {
        this.totalLabor = totalLabor;
    }

    @Autowired
    private TotalLaborService totalLaborService;

    @Autowired
    private TimeOffLaborService timeOffLaborService;

    @GetMapping("getTimeOffLaborUser/{userId}/{month}")
    public ResponseEntity<TimeoffLabor> getTimeOffLaborUser(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "month") String month) {
        TimeoffLabor timeoffLabor = timeOffLaborService.getByUserIdAndMonth(userId, month);
        return new ResponseEntity<>(timeoffLabor, HttpStatus.OK);
    }

    @RequestMapping("getTotalLabor")
    public ResponseEntity<ApiResponse> searchByQuery(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "colunSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "userid", required = false) String userid,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {
        ApiResponse api = new ApiResponse();
        List<Object[]> LstLb = totalLaborService.getTotalLaborCondition(page, pageSize, columnSortName, asc, userid, dateSearch);
        List<TotalLaborRespone> respone = new ArrayList<>();
        for (Object[] l : LstLb) {
            TotalLaborRespone totalLaborRespone = new TotalLaborRespone();
            totalLaborRespone.setUserid(l[0].toString());
            totalLaborRespone.setUsername(l[1].toString());
            totalLaborRespone.setTotalLabor(Float.parseFloat(l[2].toString()));
            totalLaborRespone.setMonth(l[3].toString());


            respone.add(totalLaborRespone);
            this.setTotalLabor(respone);
        }

        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(respone);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }

    @GetMapping("dowloadRpTotalLabor")
    public ResponseEntity<Resource> downloadFile() throws Exception {

        OutputTotalLabor rpTotalLabor = new OutputTotalLabor();
        rpTotalLabor.createrpRpTotalLabor(this.getTotalLabor());

        Path filePath = Paths.get(urlUpload + "totalLabor");
        Path file = filePath.resolve(rpTotalLabor.getFileName());
        Resource resource = new UrlResource(file.toUri());

        String contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("detailIO")
    public ResponseEntity<ApiResponse> getDetailLaborByUserCode(
            @RequestParam(value = "usercode", required = false) String usercode,
            @RequestParam(value = "dateSearch", required = false) String dateSearch
    ) {

        ApiResponse api = new ApiResponse();
        List<EmpWorkDetail> lst = totalLaborService.getDetailLaborByUserCode(usercode, dateSearch);

        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lst);

        return new ResponseEntity<>(api, HttpStatus.OK);

    }

}
