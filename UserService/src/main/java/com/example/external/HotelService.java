package com.example.external;

import com.example.entities.Hotels;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    @GetMapping("/hotels/v1/get-single-hotel/{hotelId}")
    public Hotels getHotel(@PathVariable("hotelId") Integer hotelId);
}
