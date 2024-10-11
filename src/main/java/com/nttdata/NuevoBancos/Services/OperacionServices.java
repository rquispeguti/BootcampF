package com.nttdata.NuevoBancos.Services;

import com.nttdata.NuevoBancos.Model.Cuenta;
import com.nttdata.NuevoBancos.Model.Operacion;
import com.nttdata.NuevoBancos.Repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacionServices {

    @Autowired
    OperacionRepository operacionRepository;


    public Operacion saveOrUpdate(Operacion operacion) {
        return operacionRepository.save(operacion);
    }

}
