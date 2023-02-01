package com.microservicios.springboot.app.gateway.filters.factory;

import java.util.List;

public class Configuracion {
    private String Mensaje;
    private String CookieValor;
    private String CookieNombre;
    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getCookieValor() {
        return CookieValor;
    }

    public void setCookieValor(String cookieValor) {
        CookieValor = cookieValor;
    }

    public String getCookieNombre() {
        return CookieNombre;
    }

    public void setCookieNombre(String cookieNombre) {
        CookieNombre = cookieNombre;
    }



}