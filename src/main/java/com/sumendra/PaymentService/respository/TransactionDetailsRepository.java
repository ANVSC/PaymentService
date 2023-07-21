package com.sumendra.PaymentService.respository;

import com.sumendra.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
    public TransactionDetails findByOrderId(long OrderId);
}
