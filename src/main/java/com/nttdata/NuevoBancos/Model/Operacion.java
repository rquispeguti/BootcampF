package com.nttdata.NuevoBancos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Operacion {

    @Id
    private Integer operId;
    private Double monto;
    private String fecha;
    private String ctaOri;
    private String ctaDes;
    private String tipo;


    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCtaOri() {
        return ctaOri;
    }

    public void setCtaOri(String ctaOri) {
        this.ctaOri = ctaOri;
    }

    public String getCtaDes() {
        return ctaDes;
    }

    public void setCtaDes(String ctaDes) {
        this.ctaDes = ctaDes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
