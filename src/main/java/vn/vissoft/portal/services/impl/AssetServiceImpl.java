package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.AssetDAO;
import vn.vissoft.portal.entities.Asset;
import vn.vissoft.portal.services.AssetService;

import java.util.Date;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetDAO assetDAO;

    @Override
    public boolean addAsset(Asset asset) {
        if (assetDAO.Asset_Exist(asset)) {
            return false;
        } else
            assetDAO.addAsset(asset);
        return true;
    }

    @Override
    public boolean Asset_Exist(Asset asset) {
        return false;
    }

    @Override
    public void updateAsset(Asset asset) {
        assetDAO.updateAsset(asset);

    }

    @Override
    public boolean saveAsset(Asset asset) {
        if (assetDAO.Asset_Exist(asset)) {
            return false;
        } else
            assetDAO.addAsset(asset);
        return true;

    }

    @Override
    public void deleteAssetByid(Integer assetid) {
       assetDAO.deleteAssetByid(assetid);

    }

    @Override
    public Asset GetAssetByID(Integer ast_id) {
        return assetDAO.GetAssetByID(ast_id);
    }

    @Override
    public List<Asset> GetAssetByCode(String assetcode) {
        return assetDAO.GetAssetByCode(assetcode);
    }

    @Override
    public List<Asset> getAssetBycondition(Integer page, Integer pageSize, String columnShortname, Boolean asc, String assetCode,String assetName,  String AssetDatefrom, String AssetDateTo, Integer Money, Integer Assetmanager, Integer AssetUser, Integer deprecation_PeriodFrom, Integer deprecation_PeriodTo) {
        return assetDAO.getAssetBycondition(page,pageSize,columnShortname,  asc,assetCode, assetName,AssetDatefrom,AssetDateTo,Money,Assetmanager,AssetUser,deprecation_PeriodFrom, deprecation_PeriodTo);
    }
}
