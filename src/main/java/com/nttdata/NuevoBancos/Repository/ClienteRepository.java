package com.nttdata.NuevoBancos.Repository;

import com.nttdata.NuevoBancos.Model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClienteRepository extends MongoRepository <Cliente, Integer> {
}
