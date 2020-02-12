package vn.vissoft.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Holiday;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.FillDataService;
import vn.vissoft.portal.services.HolidayService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class HolidayController {

    private static final Logger LOG = LoggerFactory.getLogger(HolidayController.class);

    @Autowired
    HolidayService holidayService;

    @GetMapping("/holidays")
    public ResponseEntity<ApiResponse> getAllHoliday() {
        ApiResponse object = new ApiResponse();
        List<Holiday> list = holidayService.getAllHolidays();
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping(value = "holidays/{hID}")
    public ApiResponse getProduct(@PathVariable("hID") int id) {
        try {
            Optional<Holiday> holiday = holidayService.findByIdHoliday(id);
            if (holiday.isPresent()) {
                Holiday holiday1 = holiday.get();
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", holiday1);
            } else {
                return ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content", null);
            }
        } catch (Exception e) {
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @PostMapping("/holidays")
    public ResponseEntity<Holiday> createHoliday(@Valid @RequestBody Holiday holiday) {
        try {
            if (!holidayService.checkCodeConflict(holiday.gethCode())) {
                ApiResponse object = new ApiResponse();
                object.setCode(409);
                object.setErrors("Code conflict");
                object.setStatus(false);
                object.setData(null);
                return new ResponseEntity(object, HttpStatus.OK);
            } else {
                holidayService.createOrUpdateHoliday(holiday);
                return new ResponseEntity<>(holiday, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("holidays/{hID}")
    public ResponseEntity<Holiday> editHoliday(@Valid @RequestBody Holiday holiday, @PathVariable int hID) {
        Optional<Holiday> holiday1 = holidayService.findByIdHoliday(hID);
        try {
            if (holiday1.isPresent()) {
                holiday1.get().sethCode(holiday.gethCode());
                holiday1.get().sethName(holiday.gethName());
                holiday1.get().sethTimeBegin(holiday.gethTimeBegin());
                holiday1.get().sethTimeEnd(holiday.gethTimeEnd());

                holidayService.createOrUpdateHoliday(holiday);
                return new ResponseEntity<>(holiday, HttpStatus.OK);
            } else {
                ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content", null);
                return new ResponseEntity(apiResponse, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
            return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/holidays/{hID}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable(name = "hID") Integer hID) {
        try {
            Optional<Holiday> holiday = holidayService.findByIdHoliday(hID);
            if (holiday.isPresent()) {
                holiday.get().setStatus(0);
                holidayService.deleteHoliday(holiday.get());
                return ResponseEntity.ok().build();
            } else {
                ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_NO_CONTENT, false, "No content", null);
                return new ResponseEntity(apiResponse, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            ApiResponse apiResponse = ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
            return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
