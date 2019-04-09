package cn.sh.lz.producer.controllers;

import cn.sh.lz.producer.clients.ProducerClient;
import cn.sh.lz.producer.entities.output.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Link at 16:10 on 4/9/19.
 */
@RequestMapping("/feign/producer")
@RestController
public class FeignController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProducerClient producerClient;

    @GetMapping(value = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("producer");
    }

    @GetMapping(value = "/hello")
    public Greeting hello() {
        return producerClient.productHello();
    }

    @GetMapping(value = "/msg")
    public String msg() {
        return producerClient.productMsg();
    }
}
