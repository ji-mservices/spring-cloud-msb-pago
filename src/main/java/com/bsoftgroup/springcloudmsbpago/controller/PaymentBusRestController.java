package com.bsoftgroup.springcloudmsbpago.controller;

import com.bsoftgroup.springcloudmsbpago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmsbpago.bean.TransactionBean;
import com.bsoftgroup.springcloudmsbpago.interfaces.PaymentBusFeignInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentBusRestController {

//	@Autowired
//	private PaymentBusProxyInterface paymentBusProxyInterface;

    @Autowired
    private PaymentBusFeignInterface paymentBusFeignInterface;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@PutMapping(path = "/billing/pay")
//	public TransactionBean paymentService(@RequestBody BillingServiceBean billingServiceBean) {
//		TransactionBean tx = paymentBusProxyInterface.paymentService(billingServiceBean);
//		return tx;
//	}

    @PutMapping("/billing/pay/feign")
    @HystrixCommand(fallbackMethod = "paymentServiceFeignHystrix")
    public TransactionBean paymentServiceFeign(@RequestBody BillingServiceBean billingServiceBean) {
        TransactionBean tx = paymentBusFeignInterface.paymentService(billingServiceBean);
        logger.info("BUS -  {}", tx);
        return tx;
    }

    public TransactionBean paymentServiceFeignHystrix(@RequestBody BillingServiceBean billingServiceBean) {
        TransactionBean tx = new TransactionBean("454", "Transaction in process", null);
        return tx;
    }

}
