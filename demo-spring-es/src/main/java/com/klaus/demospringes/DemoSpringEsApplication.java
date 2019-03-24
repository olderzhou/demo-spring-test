package com.klaus.demospringes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @author Klaus Mikaelson
 */
@SpringBootApplication
//@RestController
public class DemoSpringEsApplication {

//    @GetMapping()
//    public ResponseEntity<String> info() {
//        return ResponseEntity.ok("success");
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringEsApplication.class, args);
    }

}
