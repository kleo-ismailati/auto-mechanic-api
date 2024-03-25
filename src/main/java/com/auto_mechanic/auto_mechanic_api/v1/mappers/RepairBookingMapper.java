package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairBookingEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.*;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.RepairBookingListItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.RepairForRepairBookingListItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.RepairBookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import com.auto_mechanic.auto_mechanic_api.v1.models.RepairBooking;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RepairBookingMapper {

    private final RepairMapper repairMapper;


    public RepairBookingMapper(RepairMapper repairMapper) {
        this.repairMapper = repairMapper;
    }

    public RepairBooking toNewEntity(NewRepairBookingDto repairBookingDto, Client client, Auto auto) {

        RepairBooking repairBookingEntity = new RepairBooking();

        repairBookingEntity.setDate(LocalDateTime.now());
        repairBookingEntity.setStatus(RepairStatusEnum.toBeDone);
        repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
        repairBookingEntity.setClient(client);
        repairBookingEntity.setAuto(auto);
        repairBookingEntity.setRefID(String.valueOf(UUID.randomUUID()));
        repairBookingEntity.setRepairs(repairMapper.toNewEntityList(repairBookingDto.getRepairs(), repairBookingEntity));

        return repairBookingEntity;

    }

    public RepairBookingGuestViewDto toGuestViewDto(RepairBooking repairBooking) {

        RepairBookingGuestViewDto rbGuestViewDto = new RepairBookingGuestViewDto();

        this.setBaseDtoValues(rbGuestViewDto, repairBooking);

        return rbGuestViewDto;
    }

    public RepairBookingListItemDto toRBListItemDto(RepairBooking repairBooking) {

        RepairBookingListItemDto repairBookingListItemDto = new RepairBookingListItemDto();

        repairBookingListItemDto.setId(repairBooking.getId());
        this.setBaseDtoValues(repairBookingListItemDto, repairBooking);

        return repairBookingListItemDto;
    }

    public RepairBookingDto toViewDto(RepairBooking repairBooking) {

        RepairBookingDto repairBookingDto = new RepairBookingDto();

        repairBookingDto.setId(repairBooking.getId());
        this.setBaseDtoValues(repairBookingDto, repairBooking);

        return repairBookingDto;
    }

    public RepairBookingPageDto toViewPage(Page<RepairBooking> repairBookings) {

        RepairBookingPageDto repairBookingPageDto = new RepairBookingPageDto();

        List<RepairBookingListItemDto> repairBookingDtoList = new ArrayList<>();

        for (RepairBooking repairBooking : repairBookings) {
            repairBookingDtoList.add(toRBListItemDto(repairBooking));
        }

        repairBookingPageDto.setResult(repairBookingDtoList);
        repairBookingPageDto.setPageNo(repairBookings.getNumber());
        repairBookingPageDto.setSize(repairBookings.getSize());
        repairBookingPageDto.setTotal(repairBookings.getTotalPages());

        return repairBookingPageDto;
    }

    public RepairBooking updateEntity(RepairBookingEditDto repairBookingDto, RepairBooking repairBookingEntity) {

        if (repairBookingDto.getStatus() != null) {
            repairBookingEntity.setStatus(repairBookingDto.getStatus());
        }

        return repairBookingEntity;
    }

    private void setBaseDtoValues(RepairBookingBaseDto repairBookingBaseDto, RepairBooking repairBooking) {

        repairBookingBaseDto.setDate(repairBooking.getDate());
        repairBookingBaseDto.setStatus(repairBooking.getStatus());
        repairBookingBaseDto.setFirstName(repairBooking.getClient().getFirstName());
        repairBookingBaseDto.setLastName(repairBooking.getClient().getLastName());
        repairBookingBaseDto.setAutoModel(repairBooking.getAuto().getAutoModel());
        repairBookingBaseDto.setAutoType(repairBooking.getAuto().getAutoType());

        if (repairBookingBaseDto instanceof RepairBookingGuestViewDto) {
            List<RepairGuestViewDto> repairs = repairMapper.toGuestViewDtoList(repairBooking.getRepairs());

            ((RepairBookingGuestViewDto) repairBookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (RepairGuestViewDto repair : repairs) {
                total += repair.getRepairCost();
            }

            repairBookingBaseDto.setTotalPrice(total);
        } else if (repairBookingBaseDto instanceof RepairBookingListItemDto) {
            List<RepairForRepairBookingListItemDto> repairs = repairMapper.toRBListItemDtoList(repairBooking.getRepairs());
            ((RepairBookingListItemDto) repairBookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (RepairForRepairBookingListItemDto repair : repairs) {
                total += repair.getRepairCost();
            }

            repairBookingBaseDto.setTotalPrice(total);
        } else if (repairBookingBaseDto instanceof RepairBookingDto) {
            List<RepairForRepairBookingDto> repairs = repairMapper.toViewDtoList(repairBooking.getRepairs());
            ((RepairBookingDto) repairBookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (RepairForRepairBookingDto repair : repairs) {
                total += repair.getRepairCost();
            }

            repairBookingBaseDto.setTotalPrice(total);
        }


    }


}
