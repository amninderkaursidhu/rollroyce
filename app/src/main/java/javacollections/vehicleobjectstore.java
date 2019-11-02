package javacollections;

import java.util.ArrayList;

public class vehicleobjectstore {

    private static vehicleobjectstore vehcilesingleton = new vehicleobjectstore( );

    final  public ArrayList<vehcile> vehcileslist = new ArrayList();
    private vehicleobjectstore() { }

    /* Static 'instance' method */
    public static vehicleobjectstore getInstance( ) {
        return vehcilesingleton;
    }
}
