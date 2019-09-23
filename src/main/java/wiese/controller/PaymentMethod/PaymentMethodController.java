package wiese.controller.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.service.impl.PaymentMethodServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

    @Autowired
    @Qualifier("PaymentMethodServiceImpl")
    private PaymentMethodServiceImpl paymentMethodService;

    @PostMapping("/create")
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.create(paymentMethod);
    }

    @PostMapping("/update")
    public PaymentMethod paymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.update(paymentMethod);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        paymentMethodService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PaymentMethod read(@PathVariable int id) {
        return paymentMethodService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<PaymentMethod> getAll() {
        return paymentMethodService.getAll();
    }

}
