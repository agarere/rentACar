package agarere.io.rentACar.business.concretes;

import agarere.io.rentACar.business.abstracts.ModelService;
import agarere.io.rentACar.business.requests.CreateModelRequest;
import agarere.io.rentACar.business.responses.GetAllModelsResponse;
import agarere.io.rentACar.core.utilities.mappers.ModelMapperService;
import agarere.io.rentACar.dataAccess.abstracts.ModelRepository;
import agarere.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor // injection yapıcağım için neyi -> ModelRepository ve ModelMapperService
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }
}
