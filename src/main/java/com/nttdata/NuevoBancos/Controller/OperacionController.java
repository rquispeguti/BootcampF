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
    CuentaRepository cuentaRepository;
    CuentaServices cuentaServices;
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
    public void regRetiro(@RequestBody Operacion operacion){
        operacionRepository.save(operacion);
        Cuenta data = cuentaRepository.findById(operacion.getOperId()).orElse(null);
        if(data!=null)
        {
            data.setSaldo(data.getSaldo() - operacion.getMonto());
            data.setCliId(data.getCliId());
        }
    }

    @PostMapping("/Operacion/Transferencia")
    public void regTransferencia(@RequestBody Operacion operacion){
        operacionRepository.save(operacion);
        Cuenta data = cuentaRepository.findById(operacion.getOperId()).orElse(null);
        if(data!=null)
        {
            data.setSaldo(data.getSaldo() + operacion.getMonto());
            data.setCliId(data.getCliId());
        }

        Cuenta data1 = cuentaRepository.findById(operacion.getOperId()).orElse(null);
        if(data!=null)
        {
            data1.setSaldo(data.getSaldo() - operacion.getMonto());
            data1.setCliId(data.getCliId());
        }
    }

    @GetMapping("/Operación/Consultar/{id}")
    public Operacion getHistorico(@PathVariable Integer id){
        return operacionRepository.findById(id).orElse(null);
    }

}
