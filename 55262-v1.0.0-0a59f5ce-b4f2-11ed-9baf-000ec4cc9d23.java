/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE482_Comparing_instead_of_Assigning__basic_05.java
Label Definition File: CWE482_Comparing_instead_of_Assigning__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 482 Comparing instead of Assigning
* Sinks:
*    GoodSink: Assigning
*    BadSink : Comparing instead of assigning
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE482_Comparing_instead_of_Assigning;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE482_Comparing_instead_of_Assigning__basic_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        if (private_t)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = false;
            if((isZero == (i == 0)) == true) /* FLAW: should be (isZero = (i == 0)) */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = false;

            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = false;
            if((isZero == (i == 0)) == true) /* FLAW: should be (isZero = (i == 0)) */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = false;

            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = false;
            if((isZero = (i == 0)) == true) /* FIX: correct assignment */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */

            boolean isZero = false;

            if((isZero == (i == 0)) == true) /* FLAW: should be (isZero = (i == 0)) */
            {
                IO.writeLine("i is 0");
            }

            IO.writeLine("isZero is: " + isZero);

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
