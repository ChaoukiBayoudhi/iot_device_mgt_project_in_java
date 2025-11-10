package tn.sesame.iot;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import tn.sesame.iot.enumerations.SensorMeasurementType;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class Sensor {
    long id;
     SensorMeasurementType measurementType;
     double value;

}
