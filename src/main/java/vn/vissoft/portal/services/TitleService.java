package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Title;

import java.util.List;

public interface TitleService {

    List<Title> getAllTitle();

    void update(Title title);

    void save(Title title);

    List<Title> findTitle(String code, String name);
}
