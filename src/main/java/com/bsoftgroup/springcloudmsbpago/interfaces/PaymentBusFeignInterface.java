package com.bsoftgroup.springcloudmsbpago.interfaces;

import com.bsoftgroup.springcloudmsbpago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmsbpago.bean.TransactionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="ms-pago", url="localhost:8085")
//@FeignClient(name="ms-pago")
@FeignClient(name = "apigateway")
@RibbonClient(name = "ms-pago")
public interface PaymentBusFeignInterface {

    @PutMapping(path = "/ms-pago/mspago/billing/pay")
    public TransactionBean paymentService(@RequestBody BillingServiceBean billingServiceBean);
}
