package com.nttdata.NuevoBancos.Controller;


import com.nttdata.NuevoBancos.Model.Cliente;
import com.nttdata.NuevoBancos.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping ("/addCliente")
    public void addCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @GetMapping ("/Consultar/{id}")
    public Cliente getCliente(@PathVariable Integer id){
        return clienteRepository.findById(id).orElse(null) ;
    }

    @GetMapping ("/ListarCliente")
    public List<Cliente> fetchCliente(){
        return clienteRepository.findAll();
    }

    @PutMapping  ("/ActualizaCliente")
    public void actCliente(@RequestBody Cliente cliente){
        Cliente data=clienteRepository.findById(cliente.getCliId()).orElse(null);
       if(data!=null)
       {
           data.setCliId(cliente.getCliId());
           data.setNombre(cliente.getNombre());
           data.setApellido(cliente.getApellido());
           data.setEmail(cliente.getEmail());
       }
        clienteRepository.save(data);
    }

    @DeleteMapping  ("/borrarCliente/{id}")
    public void delCliente(@PathVariable Integer id){
        clienteRepository.deleteById(id);
    }

}
