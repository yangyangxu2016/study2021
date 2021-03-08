package com.example.demo.controller;

import com.example.demo.resposrity.CustomerTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * todo
 * date：2021/3/8  4:06 下午
 *
 * @author xuyy
 */
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @GetMapping(value = "/{id}")
    public CustomerTicket getCustomerTicketById(@PathVariable Long id) {
        CustomerTicket customerTicket = new CustomerTicket();
        customerTicket.setId(1L);
        customerTicket.setAccountId(100L);
        customerTicket.setOrderNumber("Order00001");
        customerTicket.setDescription("DemoOrder");
        customerTicket.setCreatedTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        return customerTicket;
    }
}
