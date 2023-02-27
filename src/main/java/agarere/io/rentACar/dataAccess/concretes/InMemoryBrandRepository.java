package agarere.io.rentACar.dataAccess.concretes;

import agarere.io.rentACar.dataAccess.abstracts.BrandRepository;
import agarere.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Bu sınıf bir dataAccess nesnesidir
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "BMW"));
        brands.add(new Brand(2, "Mercedes"));
        brands.add(new Brand(3, "Audi"));
        brands.add(new Brand(4, "Fiat"));
        brands.add(new Brand(5, "Renault"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }
}