package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.EmpTime;
import vn.vissoft.portal.entities.EmpWorkDetail;

import java.util.List;

public interface CheckIOService {
    List<EmpWorkDetail> getAllCheck();

    void addCheck(EmpWorkDetail empworkdetail);

    List<EmpWorkDetail> getSearch(EmpTime emp);

}
