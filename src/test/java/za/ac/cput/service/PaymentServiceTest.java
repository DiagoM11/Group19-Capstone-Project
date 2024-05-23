package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;
    private Booking booking = BookingFactory.buildBooking2("10-June-2024","15-June-2024",
            "11 Lowry Street, Cape Town, 8001", "10 Dorset Street, Cape Town, 8001"
            , 25000);

    private Payment payment = PaymentFactory.buildPayment("14521", booking,"Capitec", "20-May-2024", 18000,"Declined");

    @Test
    @Order(1)
    void save(){
        Payment saved = paymentService.save(payment);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    @Order(2)
    void read(){
        Payment read = paymentService.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println(read);

    }
    @Test
    @Order(4)
    @Disabled
    void delete(){
        paymentService.delete(payment.getPaymentId());
        System.out.println("Success: deleted payment");

    }


    @Test
    @Order(3)
    void getall(){
        System.out.println(paymentService.getall());
    }

}