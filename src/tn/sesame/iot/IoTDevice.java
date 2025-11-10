package tn.sesame.iot;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
@Builder
//@AllArgsConstructor
@Getter
@Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@RequiredArgsConstructor
//@Data // generates getters, setters, no args constructor,
// required args constructor,redefine toString, equals and hashCode methods
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class IoTDevice {
     long id;
     static long lastId=0;
     String type;
     boolean connected;
     String manufacturer;
     String firmwareVersion;
     String model;
     int batteryLevel;
     long lastSeen;
     String location;
     boolean active;
     static final int MAX_DEVICE_ID_LENGTH=20;
     static final int MIN_DEVICE_ID_LENGTH=3;
     static int deviceCount;

    public IoTDevice() {
        id=++lastId;
    }




    //methods

}
