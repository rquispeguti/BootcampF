package com.nttdata.NuevoBancos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    private Integer cliId;
    private String nombre;
    private String apellido;
    private String email;

}
