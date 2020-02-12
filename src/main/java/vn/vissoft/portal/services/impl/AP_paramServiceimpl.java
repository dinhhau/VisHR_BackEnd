package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ApParamDAO;
import vn.vissoft.portal.entities.ApParam;
import vn.vissoft.portal.services.AP_paramService;

import java.util.List;


@Service
public class AP_paramServiceimpl implements AP_paramService {
    @Autowired
    public ApParamDAO ap_paramDAO;

    @Override
    public List<ApParam> getallParamByParType() {
        return ap_paramDAO.getallParamByParType();
    }

}
