import tn.sesame.iot.IoTDevice;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //use of the property chain of the annotation @Accessors
    IoTDevice device1=new IoTDevice()
            .model("model1")
                    .firmwareVersion("1.0.1")
                            .location("Tunisia")
                                    .type("type1")
                                            .manufacturer("manufacturer 1");
    //device1.setType("printer");
    IO.println(device1);
    IO.println("id = "+ device1.id()+ ", type = "+ device1.type());
    Scanner sc=new Scanner(System.in);
    IO.print("id = ");
    long id=sc.nextLong();
    IO.println("type = ");
    String type=sc.nextLine();
    //boolean connected=false;
    IO.println("Is the device connected (y/n)");
    char response=sc.next().charAt(0);
    /*if (response =='y')
        connected=true;

     */
    boolean connected= response == 'y';


    IoTDevice device2=new IoTDevice();
    IO.println(device2);
    IO.println(Long.MAX_VALUE);
}
