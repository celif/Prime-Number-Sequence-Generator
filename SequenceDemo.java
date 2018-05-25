public class SequenceDemo
{
    public static void main(String[] args)
    {
        // perform input validation
        if (args.length != 2)
        {
            System.out.println("2 command-line arguments are required");
            System.exit(1);
        }

        if (!PrimeSequence.isInteger(args[0]) || !PrimeSequence.isInteger(args[1]))
        {
            System.out.println("Input is not an integer");
            System.exit(1);
        }

        int startNumber = Integer.parseInt(args[0]);
        int numberOfPrimes = Integer.parseInt(args[1]);

        if (startNumber < 1 || numberOfPrimes < 1)
        {
            System.out.println("Both numbers be 1 or greater");
            System.exit(1);
        }
        PrimeSequence primeSequence = new PrimeSequence(startNumber);

        // array where number of times each digit [0-9] appears is stored
        int lastDigitsArray[] = new int[10];
        int nextPrimeNumber = 0;
        int lastDigit = 0;

        System.out.print("Printing a sequence of " + numberOfPrimes + " prime numbers:");

        // generate table of primes
        for (int i = 0; i < (numberOfPrimes); i++)
        {
            if (primeSequence.isRowEnd(i, numberOfPrimes))
            {
                System.out.println();
            }

            nextPrimeNumber = primeSequence.next();

            // The last digit of a number can be obtained by: number % 10
            lastDigit = nextPrimeNumber % 10;

            lastDigitsArray[lastDigit]++;

            System.out.printf("%3d ", nextPrimeNumber);
        }
        System.out.println("\n\nLast Digit Histogram:");

        final int DIGITS = 10;
        float percentageTotal = 0;

        // generate histogram
        for (int i = 0; i < DIGITS; i++)
        {
            System.out.print("[" + i + "]");

            for (int j = 0; j < lastDigitsArray[i]; j++)
            {
                System.out.print("*");
            }

            // To find percentage: (Occurences of digit / Number of primes) * 100
            float primePercentage = ((float)lastDigitsArray[i] / numberOfPrimes) * 100;

            System.out.print(" (" + lastDigitsArray[i] + ", " +
                            Math.round(primePercentage) + "%)\n");

            percentageTotal += (primePercentage);
        }
        System.out.print("\nTotal(actual count, %) (" + numberOfPrimes + ", " +
                        (int)percentageTotal + "%)\n" + "Scaled as %, *= 1%\n");
    }
}
