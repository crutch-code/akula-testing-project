package gcg.akula.controller;

import gcg.akula.service.ConstantsService;
import gcg.akula.service.UtilsService;
import gcg.akula.service.response.ResponseService;
import jakarta.inject.Inject;

public class BaseController {

    @Inject
    ResponseService response;

    @Inject
    ConstantsService constants;

    @Inject
    UtilsService utils;
}
