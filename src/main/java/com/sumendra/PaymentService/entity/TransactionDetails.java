package com.sumendra.PaymentService.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name="TRANSACTION_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="ORDER_ID")
    private long orderId;

    @Column(name="MODE")
    private String paymentMode;

    @Column(name="REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name="PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name="STATUS")
    private String paymentStatus;

    @Column(name="AMOUNT")
    private long amount;


}
