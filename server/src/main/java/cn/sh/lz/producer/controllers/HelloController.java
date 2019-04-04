package cn.sh.lz.producer.controllers;

import cn.sh.lz.producer.entities.output.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Link at 14:29 on 4/4/19.
 */
@RestController
public class HelloController {
    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String serviceInstanceId;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    @ResponseBody
    public Greeting hello() {
        return new Greeting(counter.incrementAndGet(), String.format(template, serviceInstanceId));
    }
}
