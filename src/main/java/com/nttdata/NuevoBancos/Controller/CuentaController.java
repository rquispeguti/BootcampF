package com.nttdata.NuevoBancos.Controller;

import com.nttdata.NuevoBancos.Model.Cliente;
import com.nttdata.NuevoBancos.Model.Cuenta;
import com.nttdata.NuevoBancos.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CuentaController {

    @Autowired
    CuentaRepository cuentaRepository;

    public CuentaController(CuentaRepository cuentaRepository) {
    }

    @PostMapping ("/Cuenta/Agregar")
    public  void addCuenta(@RequestBody Cuenta cuenta){
        cuentaRepository.save(cuenta);
    }

    @GetMapping("/Cuenta/Consultar/{id}")
    public Cuenta getCuenta(@PathVariable Integer id){
        return cuentaRepository.findById(id).orElse(null) ;
    }

    @GetMapping ("/Cuenta/ListarCuenta")
    public List<Cuenta> fetchCuenta(){
        return cuentaRepository.findAll();
    }

    @DeleteMapping  ("/Cuenta/Borrar/{id}")
    public void delCuenta(@PathVariable Integer id){
        cuentaRepository.deleteById(id);
    }
}
