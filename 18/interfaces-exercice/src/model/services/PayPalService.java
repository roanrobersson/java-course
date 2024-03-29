package model.services;

public class PayPalService implements OnlinePaymentService {

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTLY_INTEREST = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		return amount * PayPalService.FEE_PERCENTAGE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * MONTLY_INTEREST * months;
	}

}
