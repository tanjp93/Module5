package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.SmartPhone;
import ra.repository.ISmartPhoneRepository;

import java.util.Optional;

@Service
public class SmartphoneServiceIMPL implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAllByProducerContaining(String producer) {
        return iSmartPhoneRepository.findAllByProducerContaining(producer);
    }

    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iSmartPhoneRepository.deleteById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }
}
