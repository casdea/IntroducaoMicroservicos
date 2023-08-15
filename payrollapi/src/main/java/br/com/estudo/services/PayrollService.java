package br.com.estudo.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.Payroll;
import br.com.estudo.feignClients.UsuarioFeign;
import br.com.estudo.services.exception.ObjectNotFoundException;
import feign.FeignException;

@Service
public class PayrollService {

	@Autowired
    private Environment env;
	
	@Autowired
    private UsuarioFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        //log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = feign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                        );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}