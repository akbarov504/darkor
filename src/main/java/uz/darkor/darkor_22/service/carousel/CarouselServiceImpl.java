package uz.darkor.darkor_22.service.carousel;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselLocalizedDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;
import uz.darkor.darkor_22.entity.home.Carousel;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.carousel.CarouselMapper;
import uz.darkor.darkor_22.repository.carousel.CarouselRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarouselServiceImpl extends AbstractService<CarouselMapper, CarouselRepository>{
    final FileRepository fileRepository;

    public CarouselServiceImpl(CarouselMapper mapper, CarouselRepository repository, FileRepository fileRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
    }



    @PostMapping
    public CarouselLocalizedDTO create(CarouselCreateDTO DTO,String lang) {
        Carousel carousel = new Carousel(
                fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")),
                DTO.getLinkUz(),
                DTO.getLinkRu(),
                DTO.getLinkEn()
        );
        repository.save(carousel);
        return mapper.toGetDTO(carousel).getLocalizationDto(lang);

    }


    public CarouselLocalizedDTO update(CarouselUpdateDTO DTO,String lang) {

        Carousel carousel = repository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Not null"));
        carousel.setGalleryEn(fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        carousel.setGalleryRu(fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        carousel.setGalleryUz( fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        carousel.setLinkEn(DTO.getLinkEn());
        carousel.setLinkRu(DTO.getLinkRu());
        carousel.setLinkUz(DTO.getLinkUz());
        repository.save(carousel);

        return mapper.toGetDTO(carousel).getLocalizationDto(lang);

    }


    public Boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public CarouselLocalizedDTO getCarousel(Long id, String language) {
        Carousel carousel = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hech  nima topilmadi"));
        return mapper.toGetDTO(carousel).getLocalizationDto(language);
    }

    public List<CarouselLocalizedDTO> listMy(CarouselCriteria criteria, String language) {
        List<CarouselLocalizedDTO> carouselGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Carousel> courses = repository.findAll(request).stream().toList();
        for (Carousel c : courses) {
            carouselGetDTOS.add(mapper.toGetDTO(c).getLocalizationDto(language));
        }
        return carouselGetDTOS;
    }
}
