package cn.sh.lz.producer.client;

import cn.sh.lz.producer.entities.output.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Link at 14:39 on 4/4/19.
 */
@FeignClient(name = "producer")
@Component
public interface ProducerClient {
    @RequestMapping(value = "/hello")
    Greeting serverHello();
}
