package com.nttdata.NuevoBancos.Repository;

import com.nttdata.NuevoBancos.Model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, Integer> {

    //Optional<Cuenta> obtenerCuentaPornrocta(String nrocta);

    Optional<Cuenta> findBynrocta(String nrocta);



}
