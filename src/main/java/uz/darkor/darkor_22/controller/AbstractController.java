package uz.darkor.darkor_22.controller;

import lombok.RequiredArgsConstructor;
import uz.darkor.darkor_22.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {
    protected final S service;
}
