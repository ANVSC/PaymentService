package com.sumendra.PaymentService.service;

import com.netflix.discovery.converters.Auto;
import com.sumendra.PaymentService.entity.TransactionDetails;
import com.sumendra.PaymentService.model.PaymentMode;
import com.sumendra.PaymentService.model.PaymentRequest;
import com.sumendra.PaymentService.model.PaymentResponse;
import com.sumendra.PaymentService.respository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest){
        log.info("Recording payment Details : {}", paymentRequest);
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction Completed");
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        log.info("Getting payment details using order ID : {}",orderId);
        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));
        log.info("Retrived Transactional Details : {}",transactionDetails );
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(transactionDetails.getId())
                .amount(transactionDetails.getAmount())
                .orderId(transactionDetails.getOrderId())
                .paymentDate(transactionDetails.getPaymentDate())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .status(transactionDetails.getPaymentStatus())
                .build();
        log.info("Returned Payement Resonse {}",paymentResponse );
        return paymentResponse;
    }

}
