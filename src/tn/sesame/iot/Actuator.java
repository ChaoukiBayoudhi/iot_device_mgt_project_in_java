package tn.sesame.iot;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class Actuator {
    long id;
    String command;
    boolean active;
}
