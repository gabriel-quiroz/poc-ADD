package com.example.primerSSO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

// README: no se puede PreAuthorize porque no se pudieron crear roles en azure gratuito

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("admin")
    @ResponseBody
    // @PreAuthorize("hasAuthority('APPROLE_Admin')")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String admin() {
        return "endpoint protegido por el rol del usuario";
    }

    @GetMapping("otro")
    @ResponseBody
    public String otro() {
        return "endpoint libre sin necesidad de rol de usuario";
    }

    @GetMapping("logs")
    @ResponseBody
    // @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String logs() {

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "logs";
    }

}