package cn.sh.lz.producer.controllers;

import cn.sh.lz.producer.client.ProducerClient;
import cn.sh.lz.producer.entities.output.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Link at 11:07 on 3/29/19.
 */
@RestController
@RequestMapping("/feign/producer")
public class FeignController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProducerClient producerClient;

    @GetMapping(value = "/hello/services")
    public List<ServiceInstance> helloServices() {
        return discoveryClient.getInstances("producer");
    }

    @GetMapping(value = "/hello")
    public Greeting hello() {
        return producerClient.serverHello();
    }
}
