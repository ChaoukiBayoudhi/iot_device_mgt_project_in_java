package tn.sesame.iot;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
//@Builder
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
@Accessors(fluent = true,chain=true)
public class IoTDevice {
     long id;
     static long lastId=0;
     @NonNull
     String type;
     boolean connected;
     @NonNull
     String manufacturer;
     @NonNull
     String firmwareVersion;
     @NonNull
     String model;
     int batteryLevel;
     long lastSeen;
     @NonNull
     String location;
     boolean active;
     static final int MAX_DEVICE_ID_LENGTH=20;
     static final int MIN_DEVICE_ID_LENGTH=3;
     static int deviceCount;

    public IoTDevice() {
        id=++lastId;
    }

    public IoTDevice(String type, boolean connected, String manufacturer, String firmwareVersion, String model, int batteryLevel, long lastSeen, String location, boolean active) {
        id=++lastId;
        //this();//call the no ags constructor
        this.type = type;
        this.connected = connected;
        this.manufacturer = manufacturer;
        this.firmwareVersion = firmwareVersion;
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.lastSeen = lastSeen;
        this.location = location;
        this.active = active;
    }

    //methods
    public boolean connect(int timeout) throws Exception{
        long startTime=System.currentTimeMillis();
        IO.println("connecting a new device (firmwareVersion = "+ firmwareVersion+", model = "+model);
        Thread.sleep(500);
        connected=true;
        long endTime=System.currentTimeMillis();
        long time=endTime-startTime;
        if(time<timeout)
        {
            IO.println("Connection successfully establish");
            return true;
        }
        return false;
    }
    public boolean connect(String protocol, int timeout) throws Exception
    {
        long startTime=System.currentTimeMillis();
        IO.println("connecting a new device (firmwareVersion = "+ firmwareVersion+", model = "+model+")");
        Thread.sleep(500);
        connected=true;
        long endTime=System.currentTimeMillis();
        long time=endTime-startTime;
        if(time<timeout)
        {
            IO.println("Connection successfully establish using the protocol" + protocol);
            return true;
        }
        return false;
    }

    public void disconnect()throws Exception
    {
        IO.println("disconnecting device ...");
        Thread.sleep(100);
        connected=false;
        IO.println("device (firmwareVersion = "+ firmwareVersion+ ", model = "+model+")");
    }

}
