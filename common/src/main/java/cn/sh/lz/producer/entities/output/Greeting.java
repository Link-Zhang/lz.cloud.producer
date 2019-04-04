package cn.sh.lz.producer.entities.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Link at 15:19 on 4/4/19.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    @Getter
    @ApiModelProperty(notes = "The Greeting ID", example = "1", required = true)
    private long id;

    @Getter
    @ApiModelProperty(notes = "The Greeting Content", example = "Hello, Producer!", position = 1, required = true)
    private String content;
}
