package uz.darkor.darkor_22.controller.system.partner;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;

import java.util.UUID;

public interface PartnerController extends GenericCUDController<PartnerCreateDTO, PartnerUpdateDTO, PartnerGetDTO, UUID>, GenericGLController<PartnerGetDTO, PartnerCriteria, UUID> {
}
