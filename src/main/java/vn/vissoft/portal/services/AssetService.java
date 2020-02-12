package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Asset;

import java.util.Date;
import java.util.List;

public interface AssetService {

    boolean addAsset(Asset asset);

    boolean Asset_Exist(Asset asset);

    void updateAsset(Asset asset);

    boolean saveAsset(Asset asset);
    void deleteAssetByid(Integer assetid);

    Asset GetAssetByID(Integer ast_id);
    List<Asset> GetAssetByCode(String ast_id);

    List<Asset> getAssetBycondition(Integer page, Integer pageSize  , String columnShortname, Boolean asc,
                                    String assetCode,String assetName,  String AssetDatefrom, String AssetDateTo, Integer Money, Integer Assetmanager, Integer AssetUser, Integer deprecation_PeriodFrom , Integer deprecation_PeriodTo);
}
