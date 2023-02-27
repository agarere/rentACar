package agarere.io.rentACar.business.concretes;

import agarere.io.rentACar.business.abstracts.BrandService;
import agarere.io.rentACar.dataAccess.abstracts.BrandRepository;
import agarere.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        // iş kuralları
        return brandRepository.getAll();
    }
}
