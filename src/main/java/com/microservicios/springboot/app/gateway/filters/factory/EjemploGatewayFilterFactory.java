package com.microservicios.springboot.app.gateway.filters.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class EjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<Configuracion> {
   // Configuracion conf = new Configuracion();
    private final Logger logger = LoggerFactory.getLogger(EjemploGatewayFilterFactory.class);

    public EjemploGatewayFilterFactory() {
        super(Configuracion.class);
    }

    @Override
    public GatewayFilter apply(Configuracion config) {
        return ((exchange, chain) -> {
            logger.info("Ejecutando PRE Gateway filter factory :"+ config.getMensaje());

            return chain.filter(exchange).then(Mono.fromRunnable(()->{

                Optional.ofNullable(config.getCookieValor()).ifPresent(cookie->{
                    exchange.getResponse().addCookie(ResponseCookie.from(config.getCookieNombre(), cookie).build());
                });

                logger.info("Ejecutando POST Gateway filter factory :"+ config.getMensaje());
            }));

        });
    }
}
