package ra.model.service.imgOfDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ra.model.entity.ImgOfDay;
import ra.model.repository.imgOfDate.ImgOfDateRepository;

import java.util.Optional;

public class ImgOfDateServiceIMPL implements ImgOfDateService{
    @Autowired
    private ImgOfDateRepository imgOfDateRepository;
    @Override
    public Page<ImgOfDay> findAll(Pageable pageable, Sort sort) {
        return null;
    }

    @Override
    public Optional<ImgOfDay> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(ImgOfDay customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
