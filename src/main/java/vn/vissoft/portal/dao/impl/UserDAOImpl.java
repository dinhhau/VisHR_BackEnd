package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.UserDAO;
import vn.vissoft.portal.entities.*;
import vn.vissoft.portal.entities.Object;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @SuppressWarnings("unchecked")

    @Override
    public User getManagerLv2ByUserCode(String code) {
        String hql = "FROM User as u WHERE u.status = 1 AND u.code =: code";
        List<User> lstResult = entityManager.createQuery(hql).setParameter("code", code).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User as u WHERE u.status = 1 and username!='' ORDER BY u.id asc";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<User> CheckDuplicateUserCode() {
        String hql = "FROM User as u";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUserByDeptId(Integer deptId) {
        String hql = "FROM User AS u WHERE u.department.deptId =: deptId";
        List<User> list = entityManager.createQuery(hql).setParameter("deptId", deptId).getResultList();
        return list;
    }

    @Override
    public User getUserByCode(String code) {
        String hql = "FROM User AS u WHERE u.code =: code AND u.status = 1";
        List<User> list = entityManager.createQuery(hql).setParameter("code", code).getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAllMrg() {
        String hql = "SELECT DISTINCT u.manager FROM User as u WHERE u.status = 1";
        @SuppressWarnings("unchecked")
        List<User> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public User getUserByUserName(String username) {
        String hql = "FROM User as u WHERE u.username LIKE :username and u.status = 1";
        @SuppressWarnings("unchecked")
        List<User> lstResult = entityManager.createQuery(hql).setParameter("username", "%" + username + "%").getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public List<User> getListUserName(String username) {
        String hql = ("From User u where u.username LIKE :username");
        List<User> list = entityManager.createQuery(hql).setParameter("username", "%" + username + "%").getResultList();
        return list;
    }

    @Override
    public List<Role> getRoleNameByUserName(String username) {
        String hql = "SELECT r FROM Role as r join UserRole as us on r.roleId = us.role join User as u on us.user = u.id  where u.username =: username";
        List<Role> lstResult = entityManager.createQuery(hql).setParameter("username", username).getResultList();
        return lstResult;
    }

    @Override
    public Role getRoleByRoleId(Integer id) {
        String hql = "FROM Role as r WHERE r.id = :id and r.status = 1";
        @SuppressWarnings("unchecked")
        List<Role> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public User getUserByMrg(String manager) {
        String hql = "FROM User as u WHERE u.code = :manager and u.status = 1";
        @SuppressWarnings("unchecked")
        List<User> lstResult = entityManager.createQuery(hql).setParameter("manager", manager).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
//        User mUser = entityManager.find(User.class, user.getId());
//        user.setPassword(passwordEncoder.encode(user.returnPassword()));
        entityManager.merge(user);
    }

    @Override
    public void updateByUser(User user) {
        User mUser = entityManager.find(User.class, user.getId());

        mUser.setEmail(user.getEmail());
        mUser.setFullName(user.getFullName());
        mUser.setManager(user.getManager());
        mUser.setDepartment(user.getDepartment());
        mUser.setBirthDay(user.getBirthDay());
        mUser.setAddress(user.getAddress());
        mUser.setTitle(user.getTitle());
        mUser.setImage(user.getImage());
        mUser.setGender(user.getGender());
        mUser.setPhoneNumber(user.getPhoneNumber());
        mUser.setIdentityCardNumber(user.getIdentityCardNumber());
        mUser.setIssueDate(user.getIssueDate());
        mUser.setIssuePlace(user.getIssuePlace());
        mUser.setManagerLevel2(user.getManagerLevel2());
        mUser.setBankAccountNumber(user.getBankAccountNumber());
        mUser.setBankName(user.getBankName());
        mUser.setBankBranch(user.getBankBranch());

        entityManager.merge(mUser);
    }

    @Override
    public void updateTotalTimeOffOfUser(User user) {
        User user1 = entityManager.find(User.class, user.getId());

        user1.setToLbor(user.getToLbor());
        entityManager.merge(user1);
    }

    @Override
    public void updatePassword(User user) {

        user.setPassword(passwordEncoder.encode(user.returnPassword()));

        entityManager.merge(user);
    }

    @Override
    public void deleteUserByUsername(String user_name) {
        entityManager.remove(getUserByUserName(user_name));
        User mUser = getUserByUserName(user_name);
        mUser.setStatus(0);
        entityManager.merge(mUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        // TODO Auto-generated method stub
        User mUser = entityManager.find(User.class, id);

        mUser.setStatus(0);

        entityManager.merge(mUser);
    }

    @Override
    public boolean userExists(User user) {
        // TODO Auto-generated method stub
        String hql = "FROM User as u WHERE u.status = 1 AND u.username = :username";
        return entityManager.createQuery(hql).setParameter("username", user.getUsername()).getResultList().size() > 0 ? true : false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean authenUser(String username, String password) {
        // TODO Auto-generated method stub
        String hql = "FROM User as u WHERE u.username = :username AND u.password = :password AND u.status = 1";
        List<User> lstUsers = (List<User>) entityManager.createQuery(hql).setParameter("username", username).setParameter("password", password).getResultList();
        if (lstUsers != null && lstUsers.size() > 0) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> SearchUserByCondition(String code, String username, String fullName, String manager, String email, String deptCode,
                                            Integer titleId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<java.lang.Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<User> from = criteriaQuery.from(User.class);

        Join<User, Department> dept = from.join("department", JoinType.LEFT);
        Join<User, Title> title = from.join("title", JoinType.LEFT);

        CriteriaQuery<java.lang.Object> select = criteriaQuery.select(from);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(from.get("status"), 1));

        if (code != null && !code.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("code"), "%" + code + "%"));
        }

        if (username != null && !username.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("username"), "%" + username + "%"));
        }

        if (fullName != null && !fullName.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("fullName"), "%" + fullName + "%"));
        }

        if (manager != null && !manager.equals("0") && !manager.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("manager"), "%" + manager + "%"));
        }

        if (email != null && !email.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("email"), "%" + email + "%"));
        }

        if (deptCode != null && !deptCode.equals("")) {
            predicates.add(criteriaBuilder.like(dept.get("deptCode"), "%" + deptCode + "%"));
        }

        if (titleId != null && titleId != 0 && !titleId.equals("")) {
            predicates.add(criteriaBuilder.equal(title.get("titleId"), titleId));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        List<User> lstResult = query.getResultList();
        return lstResult;
    }


    @SuppressWarnings("unchecked")
    @Override
    public int getRowCount(String username, String email) {
        // TODO Auto-generated method stub
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<java.lang.Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<User> from = criteriaQuery.from(User.class);

        CriteriaQuery<java.lang.Object> select = criteriaQuery.select(from);
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(from.get("status"), 1));

        if (username != null && !username.equals("")) {
            predicates.add(criteriaBuilder.equal(from.get("username"), username));
        }

        if (email != null && !email.equals("")) {
            predicates.add(criteriaBuilder.equal(from.get("email"), email));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(select);
        List<User> lstResult = query.getResultList();
        return lstResult.size();
    }


    @Override
    public boolean addUser(User user) {
        // TODO Auto-generated method stub
        user.setPassword(passwordEncoder.encode(user.returnPassword()));
        entityManager.persist(user);
        return true;
    }

    @Override
    public List<User> findUserByRoleCode(String roleCode) {

        String hql = "SELECT u FROM User as u join UserRole as us on u.id = us.user join Role as r " +
                "on us.role = r.roleId where r.roleCode =: roleCode";
        List<User> lstResult = entityManager.createQuery(hql).setParameter("roleCode", roleCode).getResultList();
        return lstResult;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        String hql = "FROM User as u WHERE u.role = :role AND u.isDeleted = 0";
        List<User> lstUsers = (List<User>) entityManager.createQuery(hql)
                .setParameter("role", role).getResultList();
        return lstUsers;
    }

    @Override

    public List<Object> getObjectNameByUserName(List<Role> lst) {

        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < lst.size(); i++) {
            String hql = "select o from Object as o join ObjectRole as r on o.ObjectId=r.ObjectId where r.roleId.roleId=: role and o.status = 1";
            List<Object> l = entityManager.createQuery(hql).setParameter("role", lst.get(i).getRoleId())
                    .getResultList();
            for (int j = 0; j < l.size(); j++) {
                list.add(l.get(j));
            }
        }
        return list;
    }

    @Override
    public List<java.lang.Object[]> getEmailOfUserHR() {
        String hql = "SELECT DISTINCT u.username, u.email " +
                        "FROM User as u JOIN UserRole as ur ON u.id = ur.user " +
                        "JOIN Role as r ON ur.role = r.roleId " +
                        "JOIN ObjectRole as obr ON r.roleId = obr.roleId " +
                        "JOIN Object as o ON obr.ObjectId = o.ObjectId " +
                        "WHERE r.roleCode = 'HR' GROUP BY u.username";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public EmpWorkDetail getEWDByUserCodeAndWorkDay(String code, String date) throws ParseException {

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        String hql = "FROM EmpWorkDetail as ewd WHERE ewd.id =: code AND ewd.workdate =: date1";
        List<EmpWorkDetail> list = entityManager.createQuery(hql).setParameter("code", code)
                .setParameter("date1", date1).getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Contract> getTimeOffLaborOfUser() {
        String hql = "SELECT c FROM User AS u JOIN Contract AS c ON u.id = c.cUser.id WHERE c.ctype.ctId = 3 OR c.ctype.ctId = 5 ORDER BY c.startdate DESC";
        List<Contract> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public User findByEmail(String email) {
        String hql = "FROM User AS u WHERE u.email =: email AND u.status = 1";
        List<User> list = entityManager.createQuery(hql).setParameter("email", email).getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}

