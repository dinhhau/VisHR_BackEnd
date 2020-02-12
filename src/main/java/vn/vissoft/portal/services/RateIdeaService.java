package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.RateIdea;

import java.util.List;
import java.util.Optional;

public interface RateIdeaService {

    List<RateIdea> getAllRateIdea();

    List<RateIdea> getRateIdeaById(Integer id);

    List<RateIdea> getRateIdeaByUserId(Integer userId);

    List<RateIdea> getRateIdeaByCreateIdeaId(Integer createIdeaId);

    Optional<RateIdea> getRateIdeaByUserIdAndCreateIdeaId(Integer userId, Integer createIdeaId);

    void addRateIdea(RateIdea rateIdea, Integer userId, Integer createIdeaId);

    void updateRateIdea(RateIdea rateIdea);

    void deleteRateIdea(Integer id);
}
