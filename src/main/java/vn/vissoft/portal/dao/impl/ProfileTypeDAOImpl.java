package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.ProfileTypeDAO;
import vn.vissoft.portal.entities.ProfileType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProfileTypeDAOImpl implements ProfileTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProfileType> getAllProfileType() {
        String hql = "FROM ProfileType as pt WHERE pt.status = 1";
        return (List<ProfileType>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public ProfileType getProfileTypeById(Integer id) {
        return entityManager.find(ProfileType.class, id);
    }

    @Override
    public List<ProfileType> searchProfileTypeByCondition(String profileTypeCode, String profileTypeName, Integer is_required,
                                                          Integer is_multiple) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<ProfileType> from = criteriaQuery.from(ProfileType.class);

        CriteriaQuery<Object> select = criteriaQuery.select(from);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(from.get("status"), 1));

        if (profileTypeCode != null && !profileTypeCode.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("profileTypeCode"), "%" + profileTypeCode + "%"));
        }

        if (profileTypeName != null && !profileTypeName.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("profileTypeName"), "%" + profileTypeName + "%"));
        }

        if (is_required != null && !is_required.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("is_required"), "%" + is_required + "%"));
        }

        if (is_multiple != null && !is_multiple.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("is_multiple"), "%" + is_multiple + "%"));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));

        Query query = entityManager.createQuery(criteriaQuery);

        List<ProfileType> lstResult = query.getResultList();
        return lstResult;
    }

    @Override
    public void addProfileType(ProfileType profileType) {
        entityManager.persist(profileType);
    }

    @Override
    public void updateProfileType(ProfileType profileType) {
        entityManager.merge(profileType);
    }

    @Override
    public void deleteById(Integer id) {
        ProfileType profileType = getProfileTypeById(id);
        profileType.setStatus(0);
        entityManager.merge(profileType);
    }
}
