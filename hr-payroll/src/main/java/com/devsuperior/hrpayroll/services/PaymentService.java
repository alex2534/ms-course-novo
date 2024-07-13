package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feingclients.WorkerFeignClient;

@Service
public class PaymentService {
	
 
	@Autowired
	private  WorkerFeignClient workerFeingClient;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		//O getBody e usado porque eu recebo aqui um retorno do tipo ResponseEntity então eu preciso converter o valor para worker
		Worker worker = workerFeingClient.fidById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		 
	}
	
}
