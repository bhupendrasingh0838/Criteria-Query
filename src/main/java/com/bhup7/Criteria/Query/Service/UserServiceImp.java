package com.bhup7.Criteria.Query.Service;

import com.bhup7.Criteria.Query.Entity.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> getAllUsers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> getUser(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.equal(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
        System.out.println("Data Created Successfully");


    }

    @Transactional
    public void deleteUser(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.equal(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        User user = tq.getSingleResult();
        entityManager.remove(user);

    }

    @Transactional
    public User updateUser(int id, User user) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.equal(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        User user1 = tq.getSingleResult();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setMobNumber(user.getMobNumber());
        entityManager.merge(user1);
        return user1;
    }

    @Transactional
    public List<User> userGreaterThan(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.gt(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Override
    public List<User> userGreaterThanEqual(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.ge(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userLessThan(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select((userRoot));
        cq.where(cb.lt(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userLessThanEqual(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.le(userRoot.get("id"), id));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Override
    public List<User> userBetween(int id, int id1) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.between(userRoot.get("id"), id, id1));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userLike(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(cb.like(userRoot.get("name"), "B%"));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userNameAndAddress(String name, String address) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        // cq.where(cb.equal(userRoot.get("name"), name)).and(cb.equal(userRoot.get("address"),address));

        Predicate name1 = cb.equal(userRoot.get("name"), name);
        Predicate address1 = cb.equal(userRoot.get("address"), address);
        Predicate nameAndAddress = cb.and(name1, address1);
        cq.where(nameAndAddress);
        // cq.where(cb.and(name1,address1));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userNameorEmail(String name, String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        Predicate name1 = cb.equal(userRoot.get("name"), name);
        Predicate email1 = cb.equal(userRoot.get("email"), email);
        Predicate nameOremail = cb.or(name1, email1);
        cq.where(nameOremail);
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

    @Transactional
    public List<User> userNotName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        Predicate name1 = cb.equal(userRoot.get("name"), name);
        cq.where(cb.not(name1));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

   /* @Transactional       Not Working
    public List<User> userIsNull() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        // Predicate address1=cb.equal(userRoot.get("address"),address);
        //cq.where(cb.isNull(address1);
        cq.where(userRoot.get("address").isNull());
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }*/

    @Transactional
    public List<User> userIn(String address) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot);
        cq.where(userRoot.get("address").in(address));
        TypedQuery<User> tq = entityManager.createQuery(cq);
        List<User> users = tq.getResultList();
        return users;
    }

}
