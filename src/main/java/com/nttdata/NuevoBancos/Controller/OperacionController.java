package com.nttdata.NuevoBancos.Controller;

import com.nttdata.NuevoBancos.Model.Cuenta;
import com.nttdata.NuevoBancos.Model.Operacion;
import com.nttdata.NuevoBancos.Repository.CuentaRepository;
import com.nttdata.NuevoBancos.Repository.OperacionRepository;
import com.nttdata.NuevoBancos.Services.CuentaServices;
import com.nttdata.NuevoBancos.Services.OperacionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Service
public class OperacionController {

    @Autowired
    OperacionRepository operacionRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    CuentaServices cuentaServices;

    @Autowired
    OperacionServices operacionServices;

    @PostMapping("/Operacion/Deposito")
    public ResponseEntity<Object> regDeposito(@RequestBody Operacion operacion){
        //operacionRepository.save(operacion);
        Optional<Cuenta> cuentaOptional = cuentaServices.obtenerCuentaPornrocta(operacion.getCtaOri());
        if (cuentaOptional.isEmpty()) {
            return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
        }
        Cuenta cuenta = cuentaOptional.get();
        cuenta.setSaldo(cuenta.getSaldo() + operacion.getMonto());
        cuentaServices.saveOrUpdate(cuenta);
        Operacion operacion1 = operacionServices.saveOrUpdate(operacion);
        return new ResponseEntity<>(operacion, HttpStatus.CREATED);
    }

    @PostMapping("/Operacion/Retiro")
    public ResponseEntity<Object> regRetiro(@RequestBody Operacion operacion){
        //operacionRepository.save(operacion);
        Optional<Cuenta> cuentaOptional = cuentaServices.obtenerCuentaPornrocta(operacion.getCtaOri());
        if (cuentaOptional.isEmpty()) {
            return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
        }
        Cuenta cuenta = cuentaOptional.get();
        cuenta.setSaldo(cuenta.getSaldo() - operacion.getMonto());
        cuentaServices.saveOrUpdate(cuenta);
        Operacion operacion1 = operacionServices.saveOrUpdate(operacion);
        return new ResponseEntity<>(operacion, HttpStatus.CREATED);
    }

    @PostMapping("/Operacion/Transferencia")
    public ResponseEntity<Object> regTransferencia(@RequestBody Operacion operacion){
        operacionRepository.save(operacion);
        Optional<Cuenta> cuentaOptional = cuentaServices.obtenerCuentaPornrocta(operacion.getCtaOri());
        Optional<Cuenta> cuentaOptional1 = cuentaServices.obtenerCuentaPornrocta(operacion.getCtaDes());
        if (cuentaOptional.isEmpty()) {
            return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
        }
        Cuenta cuenta = cuentaOptional.get();
        Cuenta cuenta1 = cuentaOptional1.get();
        cuenta.setSaldo(cuenta.getSaldo() - operacion.getMonto());
        cuenta1.setSaldo(cuenta1.getSaldo() + operacion.getMonto());
        cuentaServices.saveOrUpdate(cuenta);
        cuentaServices.saveOrUpdate(cuenta1);
        Operacion operacion1 = operacionServices.saveOrUpdate(operacion);
        return new ResponseEntity<>(operacion, HttpStatus.CREATED);
    }

    @GetMapping("/Operación/Consultar/{id}")
    public Optional<Cuenta> getHistorico(@PathVariable String id){
        Optional<Cuenta> cuentaOptional = cuentaServices.obtenerCuentaPornrocta(id);
        return cuentaOptional;
    }

    @GetMapping("/Operación/Consultar1/{id}")
    public Optional<Cuenta> getHistorico1(@PathVariable String id){
        Optional<Cuenta> cuentaOptional = cuentaServices.obtenerCuentaPornrocta(id);
        return cuentaOptional;
    }

}
