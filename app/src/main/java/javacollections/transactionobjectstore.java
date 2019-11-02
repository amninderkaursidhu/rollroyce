package javacollections;

import java.util.ArrayList;

public class transactionobjectstore {


    private static transactionobjectstore transactionsingleton = new transactionobjectstore( );

    final  public ArrayList<Transaction>  carrentdetails = new ArrayList();
    final  public ArrayList<Transaction>  returncarrentdetails = new ArrayList();
    private transactionobjectstore() { }

    /* Static 'instance' method */
    public static transactionobjectstore getInstance( ) {
        return transactionsingleton;
    }
}
