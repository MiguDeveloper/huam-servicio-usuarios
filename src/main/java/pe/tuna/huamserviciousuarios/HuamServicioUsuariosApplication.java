package pe.tuna.huamserviciousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"pe.tuna.commonsalumnos.models"})
public class HuamServicioUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuamServicioUsuariosApplication.class, args);
    }

}