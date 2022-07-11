package uz.darkor.darkor_22.service;

import lombok.RequiredArgsConstructor;
import uz.darkor.darkor_22.mapper.BaseMapper;
import uz.darkor.darkor_22.repository.BaseRepository;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final M mapper;
    protected final R repository;
}
