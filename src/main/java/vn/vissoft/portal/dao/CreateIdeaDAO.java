package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.CreateIdea;

import java.util.List;

public interface CreateIdeaDAO {

    List<CreateIdea> getAllCreateIdea();

    CreateIdea getCreateIdeaById(Integer id);

    List<CreateIdea> getCreateIdeaByUserId(Integer userId);

    void addCreateIdea(CreateIdea createIdea);

    void updateCreateIdea(CreateIdea createIdea);

    void deleteCreateById(Integer id);
}
