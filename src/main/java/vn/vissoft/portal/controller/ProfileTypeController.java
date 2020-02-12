package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.vissoft.portal.entities.ProfileType;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.ProfileTypeService;

import java.util.List;

@Controller
@RequestMapping("profileType")
public class ProfileTypeController {

    @Autowired
    private ProfileTypeService profileTypeService;

    @RequestMapping("/getAllProfileType")
    public ResponseEntity<ApiResponse> getAllProfileType() {
        ApiResponse object = new ApiResponse();
        List<ProfileType> list = profileTypeService.getAllProfileType();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @RequestMapping("/getProfileTypeById/{id}")
    public ResponseEntity<ProfileType> getProfileTypeById(@PathVariable(name = "id") Integer id) {
        ProfileType profileType = profileTypeService.getProfileTypeById(id);
        return new ResponseEntity<ProfileType>(profileType, HttpStatus.OK);
    }

    @PostMapping("/addProfileType")
    public ResponseEntity<ProfileType> addProfileType(@RequestBody ProfileType profileType, UriComponentsBuilder builder) {
        profileTypeService.addProfileType(profileType);
        return new ResponseEntity<>(profileType, HttpStatus.CREATED);
    }

    @PutMapping("/updateProfileType")
    public ResponseEntity<ProfileType> updateProfileType(@RequestBody ProfileType profileType) {
        profileTypeService.updateProfileType(profileType);
        return new ResponseEntity<ProfileType>(profileType, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable(name = "id") Integer id) {
        profileTypeService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/searchProfileTypeByCondition")
    public ResponseEntity<ApiResponse> searchProfileTypeByCondition(
            @RequestParam(value = "profileTypeCode", required = false) String profileTypeCode,
            @RequestParam(value = "profileTypeName", required = false) String profileTypeName,
            @RequestParam(value = "is_required", required = false) Integer is_required,
            @RequestParam(value = "is_multiple", required = false) Integer is_multiple) {

        ApiResponse object = new ApiResponse();
        List<ProfileType> list = profileTypeService.searchProfileTypeByCondition(profileTypeCode, profileTypeName, is_required, is_multiple);

        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }
}
