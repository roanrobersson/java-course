package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota  = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double totalValue = basicQuota + interest + fee;
			LocalDate dueDate = contract.getDate().plusMonths(i);
			contract.addInstallment(new Installment(dueDate, totalValue));
		}

	}
}
