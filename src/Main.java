import tn.sesame.iot.IoTDevice;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    IoTDevice device1=new IoTDevice(1L,"printer");
    //device1.setType("printer");
    IO.println(device1);
    IO.println("id = "+ device1.getId()+ ", type = "+ device1.getType());
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
