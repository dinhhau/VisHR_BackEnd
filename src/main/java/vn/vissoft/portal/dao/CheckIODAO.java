package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.EmpWorkDetail;

import java.util.List;

public interface CheckIODAO {
    List<EmpWorkDetail> getAllCheck();

    void addCon(EmpWorkDetail empWorkDetail);

}
