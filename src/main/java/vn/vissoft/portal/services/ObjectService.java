package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Object;

import java.util.List;

public interface ObjectService {
    List<Object> getAllObject();

    List<Object> getAllObjectnene();

    void update(Object obj);

    void save(Object obj);

    List<Object> findObject(String code, String name, String url, String icon);

    java.lang.Object getObjectByID(int id);

}
