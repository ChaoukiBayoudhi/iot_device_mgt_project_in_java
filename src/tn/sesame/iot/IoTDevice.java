package tn.sesame.iot;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class IoTDevice {
     long id;
     String type;
     boolean connected;
}
