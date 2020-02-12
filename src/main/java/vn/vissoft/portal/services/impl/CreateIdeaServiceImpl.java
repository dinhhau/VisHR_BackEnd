package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.CreateIdeaDAO;
import vn.vissoft.portal.entities.CreateIdea;
import vn.vissoft.portal.services.CreateIdeaService;

import java.util.List;

@Service
public class CreateIdeaServiceImpl implements CreateIdeaService {

    @Autowired
    private CreateIdeaDAO createIdeaDAO;

    @Override
    public List<CreateIdea> getAllCreateIdea() {
        return createIdeaDAO.getAllCreateIdea();
    }

    @Override
    public CreateIdea getCreateIdeaById(Integer id) {
        return createIdeaDAO.getCreateIdeaById(id);
    }

    @Override
    public List<CreateIdea> getCreateIdeaByUserId(Integer userId) {
        return createIdeaDAO.getCreateIdeaByUserId(userId);
    }

    @Override
    public void addCreateIdea(CreateIdea createIdea) {
        createIdeaDAO.addCreateIdea(createIdea);
    }

    @Override
    public void updateCreateIdea(CreateIdea createIdea) {
        createIdeaDAO.updateCreateIdea(createIdea);
    }

    @Override
    public void deleteCreateById(Integer id) {
        createIdeaDAO.deleteCreateById(id);
    }
}
