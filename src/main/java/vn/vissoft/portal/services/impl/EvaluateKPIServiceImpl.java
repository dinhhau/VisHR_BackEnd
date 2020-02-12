package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.EvaluateKPIDAO;
import vn.vissoft.portal.entities.EvaluateKPI;
import vn.vissoft.portal.entities.KPI;
import vn.vissoft.portal.services.EvaluateKPIService;

import java.util.List;

@Service
public class EvaluateKPIServiceImpl implements EvaluateKPIService {

    @Autowired
    private EvaluateKPIDAO evaluateKPIDAO;

    @Override
    public List<EvaluateKPI> getAllKPI() {
        return evaluateKPIDAO.getAllKPI();
    }

    @Override
    public List<KPI> getAllByKPI() {
        return evaluateKPIDAO.getAllByKPI();
    }

    @Override
    public List<EvaluateKPI> getKPIForManager(String manager) {
        return evaluateKPIDAO.getKPIForManager(manager);
    }

    @Override
    public List<EvaluateKPI> getKPIForUser(Integer user) {
        return evaluateKPIDAO.getKPIForUser(user);
    }

    @Override
    public EvaluateKPI getKPIById(Integer id) {
        return evaluateKPIDAO.getKPIById(id);
    }

    @Override
    public List<EvaluateKPI> searchByName(String name) {
        return evaluateKPIDAO.searchByName(name);
    }

    @Override
    public void addEvaluateKPI(EvaluateKPI evaluateKPI) {
        evaluateKPIDAO.addEvaluateKPI(evaluateKPI);
    }

    @Override
    public void updateEvalueteKPI(EvaluateKPI evaluateKPI) {
        evaluateKPIDAO.updateEvalueteKPI(evaluateKPI);
    }

    @Override
    public void deleteEvaluateKPI(Integer id) {
        evaluateKPIDAO.deleteEvaluateKPI(id);
    }
}
