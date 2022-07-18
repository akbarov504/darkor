package uz.darkor.darkor_22.service.system.partner;

import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface PartnerService extends GenericCUDService<PartnerCreateDTO, PartnerUpdateDTO, PartnerGetDTO, UUID>, GenericGLService<PartnerGetDTO, PartnerCriteria, UUID> {
}
