package cn.sh.lz.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 14:23 on 4/4/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "cn.sh.lz.producer.clients")
@ComponentScan(basePackages = "cn.sh.lz.producer")
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
