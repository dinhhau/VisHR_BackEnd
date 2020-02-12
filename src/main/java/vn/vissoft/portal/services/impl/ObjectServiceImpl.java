package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.repositories.ObjectRepository;
import vn.vissoft.portal.services.ObjectService;

import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    private ObjectRepository objrp;

    @Override
    public List<Object> getAllObject() {
        return objrp.findAllByStatus();
    }

    @Override
    public List<Object> getAllObjectnene() {
        return objrp.findAll();
    }

    @Override
    public void update(Object obj) {
        objrp.save(obj);
    }

    @Override
    public void save(Object obj) {
        objrp.save(obj);
    }

    @Override
    public List<Object> findObject(String code, String name, String url, String icon) {
        return objrp.findObject(code, name, url, icon);
    }

    @Override
    public java.lang.Object getObjectByID(int id) {
        return objrp.findobjectById(id);
    }
}
