package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vissoft.portal.entities.Checkobr;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.entities.ObjectRole;
import vn.vissoft.portal.entities.Role;
import vn.vissoft.portal.repositories.ObjectRoleRepository;
import vn.vissoft.portal.services.impl.ObjectServiceImpl;
import vn.vissoft.portal.services.impl.RoleServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleServiceImpl rolesv;

    @Autowired
    private ObjectRoleRepository objrole;

    @Autowired
    private ObjectServiceImpl obsv;

    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> lst = (List<Role>) rolesv.getAllRole();
        return new ResponseEntity<List<Role>>(lst, HttpStatus.OK);
    }

    @GetMapping("allobject")
    public ResponseEntity<List<Object>> getAllob() {
        List<Object> lst = (List<Object>) obsv.getAllObject();
        return new ResponseEntity<List<Object>>(lst, HttpStatus.OK);
    }

    @PostMapping("object")
    public ResponseEntity<List<Checkobr>> getAll(@RequestBody Role role) {
        List<Checkobr> check = new ArrayList<>();
        List<ObjectRole> listObr = (List<ObjectRole>) objrole.findAllByRoleId(role);
        List<Object> listOb = obsv.getAllObject();
        for (int i = 0; i < listOb.size(); i++) {
            int obr = 0;
            int objid = listOb.get(i).getObjectId();
            String objname = listOb.get(i).getObjectName();
            boolean ischeck = false;
            for (int j = 0; j < listObr.size(); j++) {
                if (objid == listObr.get(j).getObjectId().getObjectId()) {
                    ischeck = true;
                    obr = listObr.get(j).getOrId();
                }
            }
            check.add(new Checkobr(objid, obr, objname, ischeck));
        }

        return new ResponseEntity<List<Checkobr>>(check, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getAll(@PathVariable("id") int id) {
        return new ResponseEntity<Role>(rolesv.getRoleByIad(id), HttpStatus.OK);
    }

    @GetMapping("/object/{id}")
    public ResponseEntity<Object> getAlla(@PathVariable("id") int id) {
        Object ob = (Object) obsv.getObjectByID(id);
        return new ResponseEntity<Object>(ob, HttpStatus.OK);
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<Checkobr> addne(@RequestBody List<Checkobr> check, @PathVariable("id") int id) {
        for (int i = 0; i < check.size(); i++) {
            ObjectRole obj = new ObjectRole();
            obj.setObjectId((Object) obsv.getObjectByID(check.get(i).getObjectId()));
            obj.setOrRole(rolesv.getRoleByIad(id));
            obj.setStatus(1);
            if (check.get(i).getSelected() == true && check.get(i).getOrId() == 0) {
                objrole.save(obj);
            } else if (check.get(i).getSelected() == false && check.get(i).getOrId() != 0) {
                obj.setOrId(check.get(i).getOrId());
                rolesv.deleteobjr(obj);
            }
        }
        return new ResponseEntity<Checkobr>(new Checkobr(), HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Role>> find(@RequestBody Role role) {
        List<Role> lst = (List<Role>) rolesv.findRole(role.getRoleCode(), role.getRoleName());
        return new ResponseEntity<List<Role>>(lst, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> update(@RequestBody Role role) {
        rolesv.update(role);
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> add(@RequestBody Role role) {
        rolesv.save(role);
        List<Role> lst = rolesv.getAllRole();
        return new ResponseEntity<Role>(lst.get(lst.size() - 1), HttpStatus.OK);
    }
}
