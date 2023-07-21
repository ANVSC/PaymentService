package com.sumendra.PaymentService.model;

import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class PaymentResponse {
    private long paymentId;

    private String status;

    private PaymentMode paymentMode;

    private long amount;

    private Instant paymentDate;

    private long orderId;


}
