package agarere.io.rentACar.webApi.controllers;

import agarere.io.rentACar.business.abstracts.ModelService;
import agarere.io.rentACar.business.requests.CreateModelRequest;
import agarere.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping
    List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }
}
