package com.bsoftgroup.springcloudmsbpago.interfaces;

import com.bsoftgroup.springcloudmsbpago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmsbpago.bean.TransactionBean;

public interface PaymentBusProxyInterface {

    public TransactionBean paymentService(BillingServiceBean billingServiceBean);

}
