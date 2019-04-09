package cn.sh.lz.producer.clients;

import cn.sh.lz.producer.entities.output.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Link at 14:39 on 4/4/19.
 */
@FeignClient(name = "producer", fallback = ProducerClient.ProducerClientFallBack.class)
public interface ProducerClient {
    @GetMapping(value = "/msg")
    String productMsg();

    @GetMapping(value = "/hello")
    Greeting productHello();

    @Component
    static class ProducerClientFallBack implements ProducerClient {
        @Override
        public String productMsg() {
            return "服务降级!";
        }

        @Override
        public Greeting productHello() {
            return new Greeting(-1L, "服务降级!");
        }
    }
}
