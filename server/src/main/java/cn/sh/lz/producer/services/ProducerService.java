package cn.sh.lz.producer.services;

import cn.sh.lz.producer.entities.output.Greeting;

/**
 * Created by Link at 15:20 on 4/9/19.
 */
public interface ProducerService {
    Greeting hello();

    String msg();
}
