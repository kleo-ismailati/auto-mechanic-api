package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.RepairCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.RepairUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingItemRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.RepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.models.Booking;
import com.auto_mechanic.auto_mechanic_api.v1.models.Repair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepairMapper {

    public List<Repair> toNewEntityList(List<RepairCreateDto> repairsDtoList, Booking booking) {

        List<Repair> repairEntityList = new ArrayList<>();

        for (RepairCreateDto newRepairDto : repairsDtoList) {

            repairEntityList.add(toNewEntity(newRepairDto, booking));
        }

        return repairEntityList;
    }

    public List<BookingRepairDto> toBookingRepairDtoList(List<Repair> repairs) {

        List<BookingRepairDto> bookingRepairsDtoList = new ArrayList<>();

        for (Repair repair : repairs) {

            bookingRepairsDtoList.add(toBookingRepairDto(repair));
        }

        return bookingRepairsDtoList;
    }

    public List<BookingItemRepairDto> toBookingItemRepairDtoList(List<Repair> repairs) {

        List<BookingItemRepairDto> repairDtoList = new ArrayList<>();

        for (Repair repair : repairs) {

            repairDtoList.add(toBookingItemRepairDto(repair));
        }

        return repairDtoList;
    }


    public Repair toNewEntity(RepairCreateDto repairDto, Booking booking) {

        Repair repairEntity = new Repair();

        repairEntity.setRepairCost(repairDto.getRepairCost());
        repairEntity.setRepairDetails(repairDto.getRepairDetails().trim());
        repairEntity.setRepairType(repairDto.getRepairType().trim());
        repairEntity.setRepairStatus(RepairStatusEnum.toBeDone);
        repairEntity.setBooking(booking);

        return repairEntity;
    }

    public BookingItemRepairDto toBookingItemRepairDto(Repair repair) {

        BookingItemRepairDto repairDto = new BookingItemRepairDto();

        repairDto.setRepairCost(repair.getRepairCost());

        return repairDto;
    }

    public BookingRepairDto toBookingRepairDto(Repair repair) {

        BookingRepairDto bookingRepairDto = new BookingRepairDto();

        bookingRepairDto.setId(repair.getId());
        bookingRepairDto.setRepairCost(repair.getRepairCost());
        bookingRepairDto.setRepairDetails(repair.getRepairDetails());
        bookingRepairDto.setRepairType(repair.getRepairType());
        bookingRepairDto.setRepairStatus(repair.getRepairStatus());

        return bookingRepairDto;
    }

    public Repair updateEntity(RepairUpdateDto repairDto, Repair repair) {

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

    public List<BookingSummaryRepairDto> toBookingSummaryRepairDtoList(List<Repair> repairs) {

        List<BookingSummaryRepairDto> repairDtoList = new ArrayList<>();

        for (Repair repair : repairs) {
            repairDtoList.add(toBookingSummaryRepairDto(repair));
        }

        return repairDtoList;

    }

    public BookingSummaryRepairDto toBookingSummaryRepairDto(Repair repair) {

        BookingSummaryRepairDto repairDto = new BookingSummaryRepairDto();

        repairDto.setRepairCost(repair.getRepairCost());
        repairDto.setRepairDetails(repair.getRepairDetails());
        repairDto.setRepairType(repair.getRepairType());
        repairDto.setRepairStatus(repair.getRepairStatus());

        return repairDto;
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
