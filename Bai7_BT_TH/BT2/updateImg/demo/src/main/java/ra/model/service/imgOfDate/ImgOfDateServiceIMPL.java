package ra.model.service.imgOfDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.ImgOfDay;
import ra.model.repository.imgOfDate.ImgOfDateRepository;

import java.util.Optional;
@Service
public class ImgOfDateServiceIMPL implements ImgOfDateService{
    @Autowired
    private ImgOfDateRepository imgOfDateRepository;
    @Override
    public Page<ImgOfDay> findAll(Pageable pageable, Sort sort) {
        pageable= PageRequest.of(pageable.getPageNumber(), 3,sort);
        return imgOfDateRepository.findAll(pageable);
    }

    @Override
    public Optional<ImgOfDay> findById(Long id) {
        return imgOfDateRepository.findById(id);
    }

    @Override
    public void save(ImgOfDay customer) {
        imgOfDateRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        imgOfDateRepository.deleteById(id);
    }
}
