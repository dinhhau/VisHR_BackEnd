package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Reason;

import java.util.List;

public interface ReasonService {
    List<Reason> getAll();

    List<Reason> getReasonTimeOff();

    List<Reason> getAlls();

    boolean addReason(Reason reason);

    boolean Reason_Exist(Reason reason);

    void updateReason(Reason reason);

    void deletebyReasonCode(String re_code);

    Reason getReasonbyReasonCode(String re_code);

    Reason GetReasonByID(Integer re_id);

    List<Reason> getReasonByCondition(int page, int pageSize, String columnSortName, Boolean asc, String reasonCode, String reasonName, Integer reasontype,
                                      Integer reasonMoney, Integer rStatus);

    List<Reason> getREasonByCode(String ResonCode);

    List<Reason> getReasonsForLeave();

    List<Reason> getReasonByid (Integer rID);


}
