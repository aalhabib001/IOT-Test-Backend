package xyz.fahimrahman.iottest.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class OnOffSwitchFeedback {
    boolean switch1;
    boolean switch2;
    boolean switch3;
    boolean switch1feedback;
    boolean switch2feedback;
    boolean switch3feedback;
}
