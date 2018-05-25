package sequencedemo;
public class PrimeSequence implements Sequence
{
    private int firstNumber;

    public PrimeSequence(int firstNumber)
    {
        // Set instance variable firstNumber to parameter firstNumber
        this.firstNumber = firstNumber;
    }

    /**
     * Implementation of next() method.
     * @return the next prime number.
     */
    public int next()
    {
        do
        {
            // move to next prime number
            firstNumber++;

        } while(!(isPrime(firstNumber)));

        return firstNumber;
    }

    /**
     * Determine if numberToCheck is a prime number.
     * @param numberToCheck
     * @return true if prime, false otherwise.
     */
    public boolean isPrime(int numberToCheck)
    {
        final int FIRST_PRIME = 2;

        for (int i = FIRST_PRIME; (i < numberToCheck); i++)
        {
            if ((numberToCheck % i == 0))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Determine if given input string is an integer.
     * @param inputString
     * @return true if parameter is an integer,
     *         false otherwise.
     */
    public static boolean isInteger(String inputString)
    {
        for (int i = 0; i < inputString.length(); i++)
        {
            final int ZERO_IN_UNICODE = 48;
            final int NINE_IN_UNICODE = 57;

            // return false if current character is not a digit 0-9 
            if (inputString.charAt(i) < ZERO_IN_UNICODE || inputString.charAt(i) > NINE_IN_UNICODE)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Determine if row is "square" and no greater than 10.
     * @param currentPrime
     * @param numberOfPrimes
     * @return true if end of row is reached and is "square",
     *         false if row continues.
     */
    public boolean isRowEnd(int currentPrime, int numberOfPrimes)
    {
        double roundedSquareRoot = Math.ceil((Math.sqrt(numberOfPrimes)));

        // return true if current entry is divisible by 10 and roundedSquareRoot is at least 10
        if (currentPrime % 10 == 0 && roundedSquareRoot >= 10)
        {
            return true;

        }
        if (currentPrime % roundedSquareRoot == 0 && roundedSquareRoot >= 10)
        {
            return false;
        }
        // return true if currentPrime is divisible by roundedSquareRoot 
        else if (currentPrime % roundedSquareRoot == 0)
        {
            return true;
        }

        return false;
    }
}
