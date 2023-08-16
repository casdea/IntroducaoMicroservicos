package br.com.estudo.payroll.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.estudo.payroll.domain.Payroll;
import br.com.estudo.payroll.feignclient.UsuarioFeign;
import br.com.estudo.payroll.services.exception.ObjectNotFoundException;
import feign.FeignException;

@Service
public class PayrollService {

	//@Autowired
    //private Environment env;
	
    private UsuarioFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        //log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var usuario = feign.findById(workerId).getBody();
            if (Objects.nonNull(usuario)) {
                return new Payroll(
                		usuario.getName(),
                        payroll.getDescription(),
                        usuario.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * usuario.getHourlyPrice()
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