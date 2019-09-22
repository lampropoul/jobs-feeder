package org.lampropoul.jobsfeeder.helpers;

import org.jetbrains.annotations.NotNull;
import org.lampropoul.jobsfeeder.errors.ErrorCode;
import org.lampropoul.jobsfeeder.model.BaseObject;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.data.mongodb.repository.MongoRepository;

public class ControllersHelper<FeederRepo extends MongoRepository<FeederModel, Long>, FeederModel extends BaseObject> {

    public Response<FeederModel> saveAndGenerateResponse(@NotNull FeederRepo feederRepo, @NotNull FeederModel feederModel, SequenceGeneratorService sequenceGeneratorService) {
        Response<FeederModel> response = new Response<>();
        Long id = (feederModel.getId() != null) ? feederModel.getId() : 0L;
        if (feederRepo.existsById(id)) {
            response.setError(ErrorCode.EXISTS.toString());
        } else {
            feederModel.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
            response.setObject(feederRepo.save(feederModel));
        }
        return response;
    }
}
