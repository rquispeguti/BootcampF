package com.nttdata.NuevoBancos.Services;

import com.nttdata.NuevoBancos.Model.Cuenta;
import com.nttdata.NuevoBancos.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServices {

    @Autowired
    CuentaRepository cuentaRepository;

    public Cuenta saveOrUpdate(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerCuentaPornrocta(String nrocta) {
        return cuentaRepository.findBynrocta(nrocta);
    }

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Integer id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void deleteById(Integer id) {
        cuentaRepository.deleteById(id);
    }


}
