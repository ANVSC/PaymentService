package com.sumendra.PaymentService.service;

import com.sumendra.PaymentService.model.PaymentRequest;
import com.sumendra.PaymentService.model.PaymentResponse;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
