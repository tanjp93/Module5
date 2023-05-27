package ra.model.repository;

import ra.model.entity.MyBlog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class MyBlogRepositoryIMPL implements IMyBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<MyBlog> findAll() {
        TypedQuery<MyBlog>query=entityManager.createQuery("select b from MyBlog as b",MyBlog.class);
        return query.getResultList();
    }
    @Override
    public MyBlog findById(Long id) {
        TypedQuery<MyBlog>query=entityManager.createQuery("select b from MyBlog  as b where b.id=:id",MyBlog.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        return null;
        }
    }

    @Override
    public void save(MyBlog blog) {
        if (findById(blog.getId())==null){
            //create Blog
            entityManager.persist(blog);
        }
        else {
            entityManager.merge(blog);
        }

    }

    @Override
    public void remove(Long id) {
        MyBlog myBlog=findById(id);
        if (myBlog!=null){
            entityManager.remove(myBlog);
        }
    }
}
