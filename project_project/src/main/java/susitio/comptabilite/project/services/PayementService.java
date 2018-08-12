package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Payment;

import java.util.List;

public interface PayementService {
    public List<Payment> getPayments() ;
    public Payment getPaymentById(int id) ;
    public void addPayement(Payment payment) ;
    public void deletePayment(int id) ;
}
