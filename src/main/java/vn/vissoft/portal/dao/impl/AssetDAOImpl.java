package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import vn.vissoft.portal.dao.AssetDAO;
import vn.vissoft.portal.entities.Asset;
import vn.vissoft.portal.entities.Reason;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class AssetDAOImpl implements AssetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean addAsset(Asset asset) {
        asset.setIs_deleted(0);
        entityManager.merge(asset);
        return true;
    }

    @Override
    public boolean Asset_Exist(Asset asset) {
        String hql = "from " + Asset.class.getName() + " ast where ast.asset_code = :asset_code";
        return entityManager.createQuery(hql).setParameter("asset_code", asset.getAsset_code()).getResultList().size() > 0 ? true : false;
    }

    @Override
    @Transactional
    public void updateAsset(Asset asset) {
        asset.setIs_deleted(0);
        entityManager.flush();
        entityManager.merge(asset);
    }

    @Override
    @Transactional
    public boolean saveasset(Asset asset) {
        entityManager.flush();
        entityManager.merge(asset);
        return true;
    }

    @Override
    @Transactional
    public void deleteAssetByid(Integer assetid) {

        Asset assets = GetAssetByID(assetid);
        entityManager.flush();
        assets.setIs_deleted(1);
        entityManager.merge(assets);
    }

    @Override
    public Asset GetAssetByID(Integer ast_id) {
        String hql = "from " + Asset.class.getName() + " ast where ast.asset_id = :asset_id";
        @SuppressWarnings("unchecked")
        List<Asset> lstAsset = entityManager.createQuery(hql).setParameter("asset_id", ast_id).getResultList();
        if (lstAsset != null && lstAsset.size() > 0) {
            return lstAsset.get(0);
        }
        return null;
    }

    @Override
    public List<Asset> GetAssetByCode(String assetcode) {
        String hql = " from "+ Asset.class.getName()+" ast  where ast.asset_code ="+"'"+assetcode+"'" +"and ast.is_deleted = 0";
        System.out.println(hql);
        List<Asset> LstAsset = entityManager.createQuery(hql).getResultList();
        return LstAsset;
    }

    @Override
    public List<Asset> getAssetBycondition(Integer page, Integer pageSize, String columnShortname, Boolean asc,
                                           String assetCode,String assetName, String AssetDatefrom, String AssetDateTo, Integer Money,
                                           Integer Assetmanager, Integer AssetUser, Integer deprecation_PeriodFrom, Integer deprecation_PeriodTo) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = builder.createQuery();
        Root<Asset> from = criteriaQuery.from(Asset.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        List<Predicate> PD = new ArrayList<Predicate>();

        if (assetCode != null) {
            PD.add(builder.like(from.get("asset_code").as(String.class), "%" + assetCode + "%"));
        }
        if (assetName != null) {
            PD.add(builder.like(from.get("asset_name").as(String.class), "%" + assetCode + "%"));
        }
        if (AssetDatefrom != null && AssetDateTo == null) {
            PD.add(builder.equal(from.get("asset_date").as(String.class), AssetDatefrom));
        }
        if (AssetDateTo != null && AssetDatefrom == null) {
            PD.add(builder.equal(from.get("asset_date").as(String.class), AssetDateTo));
        }
        if (AssetDatefrom != null && AssetDateTo != null) {
            PD.add(builder.between(from.get("asset_date").as(String.class), AssetDatefrom, AssetDateTo));
        }
        if (Money != null) {
            PD.add(builder.equal(from.get("money").as(Integer.class), Money));
        }
        if (Assetmanager != null) {
            PD.add(builder.equal(from.get("asset_manager").as(Integer.class), Assetmanager));
        }
        if (AssetUser != null) {
            PD.add(builder.equal(from.get("asset_user").as(Integer.class), AssetUser));
        }
        PD.add(builder.equal(from.get("is_deleted").as(Integer.class),0));
        select.select(from).where(PD.toArray(new Predicate[]{}));
        if (columnShortname != null && !columnShortname.equals("")) {
            if (asc == null || asc) {
                select.orderBy(builder.asc(from.get(columnShortname)));
            } else {
                select.orderBy(builder.desc(from.get(columnShortname)));
            }
        }
        Query query = entityManager.createQuery(criteriaQuery);
        List<Asset> lstResult = query.getResultList();

        return lstResult;

    }
}
