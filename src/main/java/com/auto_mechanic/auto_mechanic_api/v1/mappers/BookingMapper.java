package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.BookingCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.BookingUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingBaseDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingItemRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Booking;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingMapper {

    private final RepairMapper repairMapper;


    public BookingMapper(RepairMapper repairMapper) {
        this.repairMapper = repairMapper;
    }

    public Booking toNewEntity(BookingCreateDto bookingDto, Client client, Auto auto) {

        Booking bookingEntity = new Booking();

        bookingEntity.setDate(LocalDateTime.now());
        bookingEntity.setStatus(RepairStatusEnum.toBeDone);
        bookingEntity.setTotalPrice(bookingDto.getTotalPrice());
        bookingEntity.setClient(client);
        bookingEntity.setAuto(auto);
        bookingEntity.setRefID(String.valueOf(UUID.randomUUID()));
        bookingEntity.setRepairs(repairMapper.toNewEntityList(bookingDto.getRepairs(), bookingEntity));

        return bookingEntity;

    }

    public BookingSummaryDto toBookingSummaryDto(Booking booking) {

        BookingSummaryDto bookingSummaryDto = new BookingSummaryDto();

        this.setBaseDtoValues(bookingSummaryDto, booking);

        return bookingSummaryDto;
    }

    public BookingItemDto toBookingItemDto(Booking booking) {

        BookingItemDto bookingDto = new BookingItemDto();

        bookingDto.setId(booking.getId());
        this.setBaseDtoValues(bookingDto, booking);

        return bookingDto;
    }

    public BookingDto toDto(Booking booking) {

        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(booking.getId());
        this.setBaseDtoValues(bookingDto, booking);

        return bookingDto;
    }

    public BookingPageDto toBookingPageDto(Page<Booking> bookings) {

        BookingPageDto bookingPageDto = new BookingPageDto();

        List<BookingItemDto> bookingDtoList = new ArrayList<>();

        for (Booking booking : bookings) {
            bookingDtoList.add(toBookingItemDto(booking));
        }

        bookingPageDto.setResult(bookingDtoList);
        bookingPageDto.setPageNo(bookings.getNumber());
        bookingPageDto.setSize(bookings.getSize());
        bookingPageDto.setTotal(bookings.getTotalPages());

        return bookingPageDto;
    }

    public Booking updateEntity(BookingUpdateDto bookingDto, Booking bookingEntity) {

        if (bookingDto.getStatus() != null) {
            bookingEntity.setStatus(bookingDto.getStatus());
        }

        return bookingEntity;
    }

    private void setBaseDtoValues(BookingBaseDto bookingBaseDto, Booking booking) {

        bookingBaseDto.setDate(booking.getDate());
        bookingBaseDto.setStatus(booking.getStatus());
        bookingBaseDto.setFirstName(booking.getClient().getFirstName());
        bookingBaseDto.setLastName(booking.getClient().getLastName());
        bookingBaseDto.setAutoModel(booking.getAuto().getAutoModel());
        bookingBaseDto.setAutoType(booking.getAuto().getAutoType());

        if (bookingBaseDto instanceof BookingSummaryDto) {
            List<BookingSummaryRepairDto> repairs = repairMapper.toBookingSummaryRepairDtoList(booking.getRepairs());

            ((BookingSummaryDto) bookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (BookingSummaryRepairDto repair : repairs) {
                total += repair.getRepairCost();
            }

            bookingBaseDto.setTotalPrice(total);
        } else if (bookingBaseDto instanceof BookingItemDto) {
            List<BookingItemRepairDto> repairs = repairMapper.toBookingItemRepairDtoList(booking.getRepairs());
            ((BookingItemDto) bookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (BookingItemRepairDto repair : repairs) {
                total += repair.getRepairCost();
            }

            bookingBaseDto.setTotalPrice(total);
        } else if (bookingBaseDto instanceof BookingDto) {
            List<BookingRepairDto> repairs = repairMapper.toBookingRepairDtoList(booking.getRepairs());
            ((BookingDto) bookingBaseDto).setRepairs(repairs);

            long total = 0L;

            for (BookingRepairDto repair : repairs) {
                total += repair.getRepairCost();
            }

            bookingBaseDto.setTotalPrice(total);
        }


    }


}
