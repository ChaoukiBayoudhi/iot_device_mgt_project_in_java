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
@EqualsAndHashCode(of = "id")
//@RequiredArgsConstructor
//@Data // generates getters, setters, no args constructor,
// required args constructor,redefine toString, equals and hashCode methods
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true, chain = true)
public class IoTDevice {
    @NonNull
    final String id;
    @NonNull
    String type;
    boolean connected;
    @NonNull
    String manufacturer;
    @NonNull
    String firmwareVersion;
    @NonNull
    String model;
    @NonNull
    String location;
    boolean active;
    int batteryLevel;
    long lastSeen;
    static final long MAX_DEVICE_ID_LENGTH = 20;
    static final long MIN_DEVICE_ID_LENGTH = 3;
    static int countDevice;

    public IoTDevice(@NonNull String id, @NonNull String type, boolean connected, @NonNull String manufacturer, @NonNull String firmwareVersion, @NonNull String model, @NonNull String location, boolean active, int batteryLevel, long lastSeen) {
//        if (id.trim().length() < MIN_DEVICE_ID_LENGTH||id.trim().length()>MAX_DEVICE_ID_LENGTH)
//            if(!(id.trim().matches("^[a-zA-Z0-9]+$")))
        //or
        if(!(id.trim().matches("^[a-zA-Z0-9]{3,20}$")))
                throw new IllegalArgumentException("Error verify the length and the format of the id.");
        this.id = id;
        this.type = type;
        this.connected = connected;
        this.manufacturer = manufacturer;
        if(firmwareVersion.trim().matches("^[0-9]+\\.[0-9]+\\.[0-9]+$"))
            throw new IllegalArgumentException("Error ! Verify the format of the version (X.Y.Z)");
        this.firmwareVersion = firmwareVersion;
        this.model = model;
        this.location = location;
        this.active = active;
        if(batteryLevel<0 || batteryLevel>100)
            throw new IllegalArgumentException("Error ! Verify the percent value.");
        this.batteryLevel = batteryLevel;
        this.lastSeen = lastSeen;
    }
    //required args constructor
    public IoTDevice(@NonNull String id, @NonNull String type,  @NonNull String manufacturer, @NonNull String firmwareVersion, @NonNull String model, @NonNull String location) {
        if(!(id.trim().matches("^[a-zA-Z0-9]{3,20}$")))
            throw new IllegalArgumentException("Error verify the length and the format of the id.");
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        if(firmwareVersion.trim().matches("^[0-9]+\\.[0-9]+\\.[0-9]+$"))
            throw new IllegalArgumentException("Error ! Verify the format of the version (X.Y.Z)");
        this.firmwareVersion = firmwareVersion;
        this.model = model;
        this.location = location;
    }

    //methods
    public boolean connect() throws Exception{
        if(!connected) {
            IO.println("Connecting new Device ...");
            Thread.sleep(5000);
            IO.println("Device [id ="+id+", firmware version ="+firmwareVersion+ ", model = "+model+"] is connected successfully.");
            connected=true;
            return true;
        }
        return false;

    }
    public boolean connect(int timeout) throws  Exception{
        long startTime=System.currentTimeMillis();
        if(!connected) {
            IO.println("Try Connecting new Device ...");
            Thread.sleep(5000);
            long endTime = System.currentTimeMillis();
            if (endTime - startTime < timeout) {
                IO.println("Device [id =" + id + ", firmware version =" + firmwareVersion + ", model = " + model + "] is connected successfully.");
                connected = true;
            } else {
                IO.println("Timeout ! The device is not connected.");
                connected = false;
            }
        }
            return connected;

    }
    public boolean connect(String protocol, int timeout) throws Exception{
        long startTime=System.currentTimeMillis();
        if(!connected) {
            IO.println("Try Connecting new Device ...");
            Thread.sleep(5000);
            long endTime = System.currentTimeMillis();
            if (endTime - startTime < timeout) {
                IO.println("Device [id =" + id + ", firmware version =" + firmwareVersion + ", model = " + model + "] is connected successfully on the protocol "+ protocol);
                connected = true;
            } else {
                IO.println("Timeout ! The device is not connected.");
                connected = false;
            }
        }
        return connected;

    }

    public void disconnect(){
        if(connected) {
            connected = false;
            IO.println("Device [id =" + id + ", firmware version =" + firmwareVersion + ", model = " + model + "] is disconnected.");
        }
        else
            IO.println("Already disconnected.");
    }

    public boolean toggleConnection()throws Exception
    {
        if(connected)
            disconnect();
        else
            connect();
        return connected;

    }

    public boolean reconnect(int maxRetries){

    }

}
