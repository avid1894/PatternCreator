package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */

    public void PrintChar(char c, int n) // a function to print a particular char n number of times
    {
        for (int i=0; i<n; i++)
        {
            mOut.print(c);
        }
    }
    public void PrintFrame(int size) //For printing the frame alone
    {
        PrintMultipleChar('+', '-', '+', size*2);
        mOut.print('\n');
    }

    public void PrintMultipleChar(char left, char middle, char right, int n) //This function is to print 3 different characters
    {
        mOut.print(left);
        PrintChar(middle, n);
        mOut.print(right);

    }
    public int UpperHalf(int size) //Function to print the upper half of the pattern
    {
        int temp=0;
        for (int i = 0; i < size - 1; i++)
        {
            PrintMultipleChar('|', ' ', '/', (size - i - 1));


            if (i % 2 == 0)
            {
                PrintChar('=', i * 2);
            }
            else
            {
                PrintChar('-', i * 2);
            }

            PrintMultipleChar('\\', ' ', '|', size - i - 1);
            mOut.print('\n');


            if( i==size -2||size ==1)
                temp = i*2;
        }
        return temp; //sending the last printed number of - or = to CenterLine and LowerHalf functions.
    }

    public void CenterLine(int s, int size)//function to print only the middle line with <>
    {
        PrintMultipleChar('|', ' ', '<', 0);

        if(size%2!=0&&size!=1)
        {
        PrintChar('=',s+2);
        }

        else
        if(size%2==0&&size!=1)
        {
            PrintChar('-',s+2);
        }

        PrintMultipleChar('>', ' ', '|', 0);
        mOut.print('\n');
    }

    public void LowerHalf(int retval, int size) // function to print the lower half of the pattern
    {
        int temp =size;
        for(int i=0; i<temp-1;i++)
        {
            PrintMultipleChar('|', ' ', '\\',i+1);

            //checking for index being even and then checking if size is odd or not and then printing = or - accordingly

            if(  i%2==0)
            {
                if (size % 2 != 0)
                {
                    PrintChar('-', retval);
                }
                else
                {
                    PrintChar('=', retval);
                }

            }

            //checking for index being odd and then checking if size is odd or not and then printing = or - accordingly
            else
                if(i%2!=0)
            {
                if(size%2!=0)
                {
                    PrintChar('=', retval);
                }

                else
                {
                    PrintChar('-', retval);
                }

            }

            PrintMultipleChar('/', ' ', '|',i+1);
            mOut.print('\n');
            //subtracting the number of - or = after each iteration
            retval = retval - 2;
        }

    }
    public void process(int size)
    {
        int returnval=0;
        // TODO -- add your code here
        //Function calls
        PrintFrame(size);
        returnval=UpperHalf(size);
        CenterLine(returnval,size);
        LowerHalf(returnval,size);
        PrintFrame(size);
    }
}


