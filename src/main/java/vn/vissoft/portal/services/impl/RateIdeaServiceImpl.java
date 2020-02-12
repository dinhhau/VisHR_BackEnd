package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.RateIdeaDAO;
import vn.vissoft.portal.entities.RateIdea;
import vn.vissoft.portal.services.RateIdeaService;

import java.util.List;
import java.util.Optional;

@Service
public class RateIdeaServiceImpl implements RateIdeaService {

    @Autowired
    private RateIdeaDAO rateIdeaDAO;

    @Override
    public List<RateIdea> getAllRateIdea() {
        return rateIdeaDAO.getAllRateIdea();
    }

    @Override
    public List<RateIdea> getRateIdeaById(Integer id) {
        return rateIdeaDAO.getRateIdeaById(id);
    }

    @Override
    public List<RateIdea> getRateIdeaByUserId(Integer userId) {
        return rateIdeaDAO.getRateIdeaByUserId(userId);
    }

    @Override
    public Optional<RateIdea> getRateIdeaByUserIdAndCreateIdeaId(Integer userId, Integer createIdeaId) {return rateIdeaDAO.getRateIdeaByUserIdAndCreateIdeaId(userId, createIdeaId);
    }

    @Override
    public List<RateIdea> getRateIdeaByCreateIdeaId(Integer createIdeaId) {
        return rateIdeaDAO.getRateIdeaByCreateIdeaId(createIdeaId);
    }

    @Override
    public void addRateIdea(RateIdea rateIdea, Integer userId, Integer createIdeaId) {
        rateIdeaDAO.addRateIdea(rateIdea, userId, createIdeaId);
    }

    @Override
    public void updateRateIdea(RateIdea rateIdea) {
        rateIdeaDAO.updateRateIdea(rateIdea);
    }

    @Override
    public void deleteRateIdea(Integer id) {
        rateIdeaDAO.deleteRateIdea(id);
    }
}
