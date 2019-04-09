package cn.sh.lz.producer.services.impl;

import cn.sh.lz.producer.entities.output.Greeting;
import cn.sh.lz.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Link at 15:22 on 4/9/19.
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String serviceInstanceId;

    private static final String template = "Hello, %s!";
    
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting hello() {
        return new Greeting(counter.incrementAndGet(), String.format(template, serviceInstanceId));
    }

    @Override
    public String msg() {
        return "This is producer msg!";
    }
}
