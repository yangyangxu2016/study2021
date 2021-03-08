package com.example.demo.resposrity;

import lombok.Data;

import java.util.Date;

/**
 * todo
 * date：2021/3/8  4:08 下午
 *
 * @author xuyy
 */
@Data
public class CustomerTicket {

    private Long id;
    private Long accountId;
    private String orderNumber;
    private String description;
    private Date createdTime;

}
