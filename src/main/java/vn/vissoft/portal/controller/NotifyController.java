package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Notify;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.services.NotifyService;

import java.util.List;

@RestController
@RequestMapping("leave/")
public class NotifyController {

    @Autowired
    NotifyService notifyService;

    @PostMapping("notify")
    public ResponseEntity<Notify> createNotify(@RequestBody Notify notify) {
    	notify.setStatushide(1);
        notifyService.createNotify(notify);
        return ResponseEntity.ok().body(notify);
    }

    @GetMapping("getNotifyByReceiver/{code}")
    public ResponseEntity<ApiResponse> getNotifyByReceiver(@PathVariable String code) {
        ApiResponse object = new ApiResponse();
        List<Notify> list = notifyService.getNotifyByReceiver(code);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(list);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PutMapping("/editNotifyStatus/{notifyID}")
    public ResponseEntity<Notify> changeStatus(@RequestBody Notify notify, @PathVariable Integer notifyID) {
        Notify n = notifyService.getNotifiesByNID(notifyID);
        if (n != null) {
            n.setnStatus(notify.getnStatus());
        }
        notifyService.createNotify(notify);
        return new ResponseEntity<Notify>(notify, HttpStatus.OK);
    }
}
