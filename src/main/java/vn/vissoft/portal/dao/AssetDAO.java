package vn.vissoft.portal.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.Asset;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface AssetDAO {

    boolean addAsset(Asset asset);

    boolean Asset_Exist(Asset asset);

    void updateAsset(Asset asset);

    boolean saveasset(Asset asset);

    void deleteAssetByid(Integer assetid);

    Asset GetAssetByID(Integer ast_id);

    List<Asset> GetAssetByCode(String assetcode);



    List<Asset> getAssetBycondition(Integer page, Integer pageSize, String columnShortname, Boolean asc,
                                    String assetCode,String assetName, String AssetDatefrom, String AssetDateTo, Integer Money,
                                    Integer Assetmanager, Integer AssetUser, Integer deprecation_PeriodFrom,
                                    Integer deprecation_PeriodTo);
}
