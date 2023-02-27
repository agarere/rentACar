package agarere.io.rentACar.business.abstracts;

import agarere.io.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
}
