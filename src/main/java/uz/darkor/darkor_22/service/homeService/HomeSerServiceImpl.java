package uz.darkor.darkor_22.service.homeService;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceLocalizedDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.homeService.HomeServiceMapper;
import uz.darkor.darkor_22.repository.homeService.HomeServiceRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeSerServiceImpl extends AbstractService<HomeServiceMapper, HomeServiceRepository>  {
    final FileRepository fileRepository;

    public HomeSerServiceImpl(HomeServiceMapper mapper, HomeServiceRepository repository, FileRepository fileRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
    }


    public HomeServiceLocalizedDTO create(HomeServiceCreateDTO DTO, String lang) {
        HomeService homeService = new HomeService(
                fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                DTO.getTitleUz(),
                DTO.getTitleRU(),
                DTO.getTitleEn(),
                DTO.getDescriptionUZ(),
                DTO.getDescriptionRu(),
                DTO.getDescriptionEn()
        );
        repository.save(homeService);
        return mapper.toGetDTO(homeService).getLocalizationDto(lang);
    }


    public HomeServiceLocalizedDTO update(HomeServiceUpdateDTO DTO,String lang) {
        HomeService homeService = repository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Not Found"));
        homeService.setGalleryEn(fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        homeService.setGalleryRu(fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        homeService.setGalleryEn(fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        homeService.setTitleEn(DTO.getTitleEn());
        homeService.setTitleRU(DTO.getTitleRU());
        homeService.setTitleUz(DTO.getTitleUz());
        homeService.setDescriptionEn(DTO.getDescriptionEn());
        homeService.setDescriptionRu(DTO.getDescriptionRu());
        homeService.setDescriptionUZ(DTO.getDescriptionUZ());
        repository.save(homeService);

        return mapper.toGetDTO(homeService).getLocalizationDto(lang);
    }


    public Boolean delete(Long id) {

        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    public HomeServiceLocalizedDTO get(Long id, String language) {
        HomeService homeService = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));

        return mapper.toGetDTO(homeService).getLocalizationDto(language);
    }


    public List<HomeServiceLocalizedDTO> list(HomeServiceCriteria criteria, String language) {

        List<HomeServiceLocalizedDTO> homeServiceGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<HomeService> homeServices = repository.findAll(request).stream().toList();
        for (HomeService c : homeServices) {
            homeServiceGetDTOS.add(mapper.toGetDTO(c).getLocalizationDto(language));
        }
        return homeServiceGetDTOS;

    }

}
