package ra.model.service.fileUpload;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ra.model.entity.FileUpload;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class FileUploadIPLM implements IFileUploadService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {

        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FileUpload> findAll() {
        return null;
    }

    @Override
    public boolean save(FileUpload fileUpload) throws SQLException {
        return false;
    }

    @Override
    public boolean update(FileUpload fileUpload) {
        return false;
    }

    @Override
    public FileUpload findById(int e) {
        return null;
    }

    @Override
    public boolean delete(int e) {
        return false;
    }
}
