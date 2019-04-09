package cn.sh.lz.producer.controllers;

import cn.sh.lz.producer.entities.output.Greeting;
import cn.sh.lz.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/msg")
    public String msg() {
        return producerService.msg();
    }

    @GetMapping("/hello")
    public Greeting hello() {
        return producerService.hello();
    }
}
