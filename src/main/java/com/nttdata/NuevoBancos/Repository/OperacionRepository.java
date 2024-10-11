package com.nttdata.NuevoBancos.Repository;

import com.nttdata.NuevoBancos.Model.Operacion;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OperacionRepository extends MongoRepository <Operacion, Integer> {


}

