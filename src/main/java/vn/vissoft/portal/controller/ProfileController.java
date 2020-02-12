package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.dao.impl.ZipProfile;
import vn.vissoft.portal.entities.Profile;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    ProfileTypeService profileTypeService;

    @Autowired
    UserService userService;

    @Autowired
    StorageService storageService;

    @Autowired
    ZipProfileService zipProfileService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<Profile>> getById(@PathVariable(name = "id") Integer id){
        List<Profile> profile = profileService.getProfileByUserId(id);
        return new ResponseEntity<List<Profile>>(profile, HttpStatus.OK);
    }

    @GetMapping("/getProfileById/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable(name = "id") Integer id){
        Profile profile = profileService.findByProfileId(id);
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    @GetMapping("/getProfileType/{userId}&{profileTypeId}")
    public ResponseEntity<ApiResponse> getProfileType(@PathVariable("userId") Integer userId, @PathVariable("profileTypeId") Integer profileTypeId) {
        ApiResponse object = new ApiResponse();
        List<Profile> list = profileService.getProfileType(userId, profileTypeId);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("/addProfile/{userId}/{profileTypeId}")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile, @PathVariable Integer userId, @PathVariable Integer profileTypeId) {
        profile.setUser(userService.getUserById(userId));
        profile.setProfileType(profileTypeService.getProfileTypeById(profileTypeId));
        profileService.addProfile(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        profileService.updateProfile(profile);
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{profile}/{name:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable ("name") String name) {
        Resource file = storageService.DownloadFile(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/downloadFile/{name:.+}")
    public ResponseEntity<Resource> downloadProfileZip(@PathVariable ("name") String name) {
        Resource file = storageService.DownloadFileZip(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/getPathByUserId/{id}")
    public ResponseEntity<Void> getPathByUserId(@PathVariable(name = "id") Integer id) throws IOException {
        zipProfileService.zipFile(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable("id") Integer id) {
        profileService.deleteProfileById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
