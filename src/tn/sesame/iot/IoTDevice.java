package tn.sesame.iot;

public class IoTDevice {
    private long id;
    private String type;
    private boolean connected;

    public IoTDevice(long id1, String type1) {
        id = id1;
        type = type1;
        connected=false;
    }
 //redefinition de constructeur
    public IoTDevice(long id, String type, boolean connected) {
        this.id = id;
        this.type = type;
        this.connected = connected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
