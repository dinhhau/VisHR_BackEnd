package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ReasonDAO;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.repositories.ReasonRepository;
import vn.vissoft.portal.services.ReasonService;

import java.util.List;

@Service
public class ReasonServiceImpl implements ReasonService {
    @Autowired
    private ReasonDAO reasonDAO;

    @Autowired
    ReasonRepository reasonRepository;

    @Override
    public List<Reason> getAll() {
        // TODO Auto-generated method stub
        return reasonDAO.getAll();
    }

    @Override
    public List<Reason> getReasonTimeOff() {
        return reasonDAO.getReasonTimeOff();
    }

    @Override
    public synchronized boolean addReason(Reason reason) {
        if (reasonDAO.Reason_Exist(reason)) {
            return false;
        } else
            reasonDAO.addReason(reason);
        return true;
    }

    @Override
    public boolean Reason_Exist(Reason reason) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void updateReason(Reason reason) {
        reasonDAO.updateReason(reason);

    }

    @Override
    public void deletebyReasonCode(String re_code) {
        reasonDAO.deletebyReasonCode(re_code);

    }

    @Override
    public Reason getReasonbyReasonCode(String re_Code) {

        return reasonDAO.getReasonbyReasonCode(re_Code);
    }

    @Override
    public Reason GetReasonByID(Integer re_id) {
        return reasonDAO.GetReasonByID(re_id);

    }

    @Override
    public List<Reason> getReasonByCondition(int page, int pageSize, String columnSortName, Boolean asc,
                                             String reasonCode, String reasonName, Integer reasontype, Integer reasonMoney, Integer reasonStatus) {

        return reasonDAO.getReasonByCondition(page, pageSize, columnSortName, asc, reasonCode, reasonName, reasontype, reasonMoney, reasonStatus);
    }

    @Override
    public List<Reason> getAlls() {
        // TODO Auto-generated method stub
        return reasonDAO.getAlls();
    }

    @Override
    public List<Reason> getREasonByCode(String ResonCode) {

        return reasonDAO.getREasonByCode(ResonCode);
    }

    @Override
    public List<Reason> getReasonsForLeave() {
        return reasonDAO.getReasonsForLeave();
    }

    @Override
    public List<Reason> getReasonByid(Integer rID) {
        return reasonDAO.getReasonByid(rID);
    }


}
