package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.CreateIdea;

import java.util.List;

public interface CreateIdeaService {

    List<CreateIdea> getAllCreateIdea();

    CreateIdea getCreateIdeaById(Integer id);

    List<CreateIdea> getCreateIdeaByUserId(Integer userId);

    void addCreateIdea(CreateIdea createIdea);

    void updateCreateIdea(CreateIdea createIdea);

    void deleteCreateById(Integer id);
}
