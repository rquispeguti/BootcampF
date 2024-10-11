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

public class Cuenta {
    @Id
    private Integer ctaId;

    private String nrocta;
    private Double saldo;
    private String cliId;


    public Integer getCtaId() {
        return ctaId;
    }

    public void setCtaId(Integer ctaId) {
        this.ctaId = ctaId;
    }

    public String getNrocta() {
        return nrocta;
    }

    public void setNrocta(String nrocta) {
        this.nrocta = nrocta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCliId() {
        return cliId;
    }

    public void setCliId(String cliId) {
        this.cliId = cliId;
    }
}
