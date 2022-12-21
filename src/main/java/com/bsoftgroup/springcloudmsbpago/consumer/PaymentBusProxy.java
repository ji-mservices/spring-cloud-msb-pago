package com.bsoftgroup.springcloudmsbpago.consumer;

import com.bsoftgroup.springcloudmsbpago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmsbpago.bean.TransactionBean;
import com.bsoftgroup.springcloudmsbpago.interfaces.PaymentBusProxyInterface;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentBusProxy implements PaymentBusProxyInterface {

	private static final String URL = "http://localhost:8085/mspago/billing/pay";

	@Override
	public TransactionBean paymentService(BillingServiceBean billingServiceBean) {
		TransactionBean tx = null;
		HttpEntity<BillingServiceBean> requestEntity = new HttpEntity<>(billingServiceBean, null);
		ResponseEntity<TransactionBean> responseEntity = new RestTemplate().exchange(URL, HttpMethod.PUT, requestEntity,
				TransactionBean.class);
		if (responseEntity.hasBody()) {
			tx = responseEntity.getBody();
		}
		return tx;
	}

}
