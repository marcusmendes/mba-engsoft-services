package br.com.mba.engsoft.grpcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GRPCServiceApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(GRPCServiceApplication.class, args);
    }
}
