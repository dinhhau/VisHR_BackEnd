package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.EvaluateKPI;
import vn.vissoft.portal.entities.KPI;

import java.util.List;

public interface EvaluateKPIService {

    List<EvaluateKPI> getAllKPI();

    List<KPI> getAllByKPI();

    List<EvaluateKPI> getKPIForManager(String manager);

    List<EvaluateKPI> getKPIForUser(Integer user);

    List<EvaluateKPI> searchByName(String name);

    EvaluateKPI getKPIById(Integer id);

    void addEvaluateKPI(EvaluateKPI evaluateKPI);

    void updateEvalueteKPI(EvaluateKPI evaluateKPI);

    void deleteEvaluateKPI(Integer id);
}
