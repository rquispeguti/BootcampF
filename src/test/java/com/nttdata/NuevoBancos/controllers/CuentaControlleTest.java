package com.nttdata.NuevoBancos.controllers;

import com.nttdata.NuevoBancos.Controller.CuentaController;
import com.nttdata.NuevoBancos.Model.Cuenta;
import com.nttdata.NuevoBancos.Repository.CuentaRepository;
import com.nttdata.NuevoBancos.Services.CuentaServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.core.IsInstanceOf.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CuentaControlleTest {


   @Mock
    private CuentaRepository cuentaRepository;
    private CuentaServices cuentaServices;
    private CuentaController cuentaController;

    WebTestClient count;

    @BeforeEach
    void setUp(){
        count = WebTestClient.bindToController(new CuentaController(cuentaRepository)).build();
    }

    @Test
    @DisplayName("when add product return ok")
    void whenAddCuentaReturnOk() {
        Cuenta cuenta = new Cuenta();
        cuenta.setCtaId(10);
        cuenta.setNrocta("555");
        cuenta.setSaldo(100.00);
        cuenta.setCliId("1");

        Mockito.when(cuentaServices.save(any(Cuenta.class))).thenReturn(Mono.just(cuenta));

        Mono<Cuenta> resultado = cuentaServices.save(cuenta);

        StepVerifier.create(resultado)
                .expectNext(cuenta).verifyComplete();

        count.post().uri("/Cuenta/Agregar")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(cuenta), Cuenta.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Cuenta.class)
                .consumeWith(response -> {
                    Cuenta cuentas = response.getResponseBody();
                    assertEquals(cuentas.getCtaId(), "1");

                });
    }



}
