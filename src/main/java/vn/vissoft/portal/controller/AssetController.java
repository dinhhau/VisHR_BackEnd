package vn.vissoft.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import vn.vissoft.portal.entities.Asset;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.Visrules;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.AssetService;
import vn.vissoft.portal.services.StorageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Asset/")
public class AssetController {

    @Autowired
    AssetService assetService;

    @Autowired
    StorageService storageService;

    List<String> files = new ArrayList<String>();

    @PutMapping("updateAsset")
    public ResponseEntity<Void> UpdateAsset(@RequestBody Asset asset) {

        assetService.updateAsset(asset);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("createAsset")
    public ApiResponse SaveAsset(@RequestBody Asset asset) {
        boolean flag = assetService.saveAsset(asset);
        if (flag == false) {
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content",
                    null);
            return apiResponse;

        } if (flag == true) {
            assetService.updateAsset(asset);
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "No content",
                    null);

        }else

        return ApiResponse.build(HttpServletResponse.SC_ACCEPTED, false, "No content",
                null);
    }

    @DeleteMapping("DeleteByID/{AstID}")
    public ResponseEntity<Void> deleteAssetByassetID(@PathVariable("AstID") Integer AstID) {
        assetService.deleteAssetByid(AstID);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }
//
//    @PostMapping("createAsset")
////    @ResponseStatus(HttpStatus.CREATED)
//    @Transactional
//    public ApiResponse createRules(@RequestBody Asset asset) throws ParseException {
//
//        boolean flag = assetService.addAsset(asset);
//        if (flag == false) {
//            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content",
//                    null);
//            return apiResponse;
//        }


//
//    }

    @GetMapping("{id}")
    public ResponseEntity<Asset> getAssetByid(@PathVariable("id") Integer rid) {
        Asset e = assetService.GetAssetByID(rid);
        return new ResponseEntity<Asset>(e, HttpStatus.OK);
    }

    @GetMapping("getassetCode")
    public ResponseEntity<ApiResponse> getAssetByCode(@RequestParam("code") String code) {
         List<Asset>  e = assetService.GetAssetByCode(code);
        ApiResponse api = new ApiResponse();
        api.setData(e);
        return new ResponseEntity<ApiResponse>( api, HttpStatus.OK);
    }




    @GetMapping("SearchAssetbyCondition")
    public ResponseEntity<ApiResponse> searchEmpByCondition(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "columnSortName", required = false) String columnSortName,
            @RequestParam(value = "asc", required = false) Boolean asc,
            @RequestParam(value = "assetCode", required = false) String assetCode,
            @RequestParam(value = "assetName", required = false) String assetName,
            @RequestParam(value = "AssetDatefrom", required = false) String AssetDatefrom,
            @RequestParam(value = "AssetDateTo", required = false) String AssetDateTo,
            @RequestParam(value = "Money", required = false) Integer Money,
            @RequestParam(value = "Assetmanager", required = false) Integer Assetmanager,
            @RequestParam(value = "AssetUser", required = false) Integer AssetUser,
            @RequestParam(value = "deprecation_PeriodFrom", required = false) Integer deprecation_PeriodFrom,
            @RequestParam(value = "deprecation_PeriodTo", required = false) Integer deprecation_PeriodTo

    ) {
        ApiResponse api = new ApiResponse();
        List<Asset> lstRpE = assetService.getAssetBycondition(page, pageSize, columnSortName, asc,
                assetCode, assetName, AssetDatefrom, AssetDateTo, Money, Assetmanager, AssetUser, deprecation_PeriodFrom, deprecation_PeriodTo);
        api.setCode(200);
        api.setErrors(null);
        api.setStatus(true);
        api.setData(lstRpE);
        api.setPage(page);
        api.setPageSize(pageSize);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


}
