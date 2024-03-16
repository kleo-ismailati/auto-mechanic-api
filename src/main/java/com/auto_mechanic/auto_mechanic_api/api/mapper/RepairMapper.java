package com.auto_mechanic.auto_mechanic_api.api.mapper;

import com.auto_mechanic.auto_mechanic_api.api.dto.repair.RepairDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair.repair_edit.RepairEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.RepairForRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.new_repair_booking.NewRepairDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_guest.RepairGuestViewDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_list.RepairForRepairBookingListItemDto;
import com.auto_mechanic.auto_mechanic_api.api.model.Repair;
import com.auto_mechanic.auto_mechanic_api.api.model.RepairBooking;
import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepairMapper {

    public List<Repair> toNewEntityList(List<NewRepairDto> repairsDtoList, RepairBooking repairBooking) {

        List<Repair> repairEntityList = new ArrayList<>();

        for (NewRepairDto newRepairDto : repairsDtoList) {

            repairEntityList.add(toNewEntity(newRepairDto, repairBooking));
        }

        return repairEntityList;
    }

    public List<RepairForRepairBookingDto> toViewDtoList(List<Repair> repairs) {

        List<RepairForRepairBookingDto> repairForRepairBookingDtoList = new ArrayList<>();

        for (Repair repair : repairs) {

            repairForRepairBookingDtoList.add(toViewDto(repair));
        }

        return repairForRepairBookingDtoList;
    }

    public List<RepairForRepairBookingListItemDto> toRBListItemDtoList(List<Repair> repairs) {

        List<RepairForRepairBookingListItemDto> repairForRepairBookingListItemDtoList = new ArrayList<>();

        for (Repair repair : repairs) {

            repairForRepairBookingListItemDtoList.add(toRBListItemDto(repair));
        }

        return repairForRepairBookingListItemDtoList;
    }


    public Repair toNewEntity(NewRepairDto repairDto, RepairBooking repairBooking) {

        Repair repairEntity = new Repair();

        repairEntity.setRepairCost(repairDto.getRepairCost());
        repairEntity.setRepairDetails(repairDto.getRepairDetails().trim());
        repairEntity.setRepairType(repairDto.getRepairType().trim());
        repairEntity.setRepairStatus(RepairStatusEnum.toBeDone);
        repairEntity.setRepairBooking(repairBooking);

        return repairEntity;
    }

    public RepairForRepairBookingListItemDto toRBListItemDto(Repair repair) {

        RepairForRepairBookingListItemDto repairForRepairBookingListItemDto = new RepairForRepairBookingListItemDto();

        repairForRepairBookingListItemDto.setRepairCost(repair.getRepairCost());

        return repairForRepairBookingListItemDto;
    }

    public RepairForRepairBookingDto toViewDto(Repair repair) {

        RepairForRepairBookingDto repairForRepairBookingDto = new RepairForRepairBookingDto();

        repairForRepairBookingDto.setId(repair.getId());
        repairForRepairBookingDto.setRepairCost(repair.getRepairCost());
        repairForRepairBookingDto.setRepairDetails(repair.getRepairDetails());
        repairForRepairBookingDto.setRepairType(repair.getRepairType());
        repairForRepairBookingDto.setRepairStatus(repair.getRepairStatus());

        return repairForRepairBookingDto;
    }

    public Repair updateEntity(RepairEditDto repairDto, Repair repair) {

        if (repairDto.getRepairCost() != null) {
            repair.setRepairCost(repairDto.getRepairCost());
        }

        if (repairDto.getRepairDetails() != null) {
            repair.setRepairDetails(repairDto.getRepairDetails().trim());
        }

        if (repairDto.getRepairType() != null) {
            repair.setRepairType(repairDto.getRepairType().trim());
        }

        if (repairDto.getRepairStatus() != null) {
            repair.setRepairStatus(repairDto.getRepairStatus());
        }

        return repair;
    }

    public List<RepairGuestViewDto> toGuestViewDtoList(List<Repair> repairs) {

        List<RepairGuestViewDto> repairGuestViewDtoList = new ArrayList<>();

        for (Repair repair : repairs) {
            repairGuestViewDtoList.add(toGuestViewDto(repair));
        }

        return repairGuestViewDtoList;

    }

    public RepairGuestViewDto toGuestViewDto(Repair repair) {

        RepairGuestViewDto repairGuestViewDto = new RepairGuestViewDto();

        repairGuestViewDto.setRepairCost(repair.getRepairCost());
        repairGuestViewDto.setRepairDetails(repair.getRepairDetails());
        repairGuestViewDto.setRepairType(repair.getRepairType());
        repairGuestViewDto.setRepairStatus(repair.getRepairStatus());

        return repairGuestViewDto;
    }

    public RepairDto toDto(Repair repair) {
        RepairDto repairDto = new RepairDto();

        repairDto.setId(repair.getId());
        repairDto.setRepairCost(repair.getRepairCost());
        repairDto.setRepairDetails(repair.getRepairDetails());
        repairDto.setRepairType(repair.getRepairType());
        repairDto.setRepairStatus(repair.getRepairStatus());

        return repairDto;
    }
}
