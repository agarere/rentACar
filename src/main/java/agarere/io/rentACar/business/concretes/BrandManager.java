package agarere.io.rentACar.business.concretes;

import agarere.io.rentACar.business.abstracts.BrandService;
import agarere.io.rentACar.business.requests.CreateBrandRequest;
import agarere.io.rentACar.business.requests.UpdateBrandRequest;
import agarere.io.rentACar.business.responses.GetAllBrandsResponse;
import agarere.io.rentACar.business.responses.GetByIdBrandResponse;
import agarere.io.rentACar.core.utilities.mappers.ModelMapperService;
import agarere.io.rentACar.dataAccess.abstracts.BrandRepository;
import agarere.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // Bu sınıf bir business nesnesidir. İş kuralları burada yazılır.
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = modelMapperService
                .forResponse()
                .map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
        // note: Eğer id yoksa insert yapar, id varsa update yapar !
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
