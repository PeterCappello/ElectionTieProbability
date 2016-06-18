package electiontieprobability;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author Peter Cappello
 */
public class ElectionTieProbability 
{
    static final BigDecimal one  = new BigDecimal( 1.0 );
    static final BigDecimal four = new BigDecimal( 4.0 );
    
    public static void main( String[] args )
    {
//        System.out.println( "1 << 1: " +  (1 << 1) );
//        System.out.println( "1 << 2: " +  (1 << 2) );
//        System.out.println( "1 << 10: " +  (1 << 10) );
//        System.out.println( "( (double) ( 1 << 1 ) ): " +  (( (double) ( 1 << 1 ) )) );
//        System.out.println( "( (double) ( 1 << 2 ) ): " +  (( (double) ( 1 << 2 ) )) );
//        System.out.println( "( (double) ( 1 << 10 ) ): " +  (( (double) ( 1 << 10 ) )) );
//        System.out.println( "comb( 2,1): " +  comb(2, 1) );
//        System.out.println( "comb( 4,2): " +  comb(4, 2) );
//        System.out.println( "comb( 6,3): " +  comb(6, 3) );
//        System.out.println( "comb( 8,4): " +  comb(8, 4) );
//        System.out.println( "comb( 10,5): " +  comb(10, 5) );
//        System.out.println( "tie( 2): " +  tie( 2 ) );
//        System.out.println( "tie( 4): " +  tie( 4 ) );
//        System.out.println( "tie( 6): " +  tie( 6 ) );
//        System.out.println( "tie( 8): " +  tie( 8 ) );
//        System.out.println( "tie( 10): " + tie( 10 ) );
//        System.out.println( "tie( 20): " + tie( 20 ) );
//        System.out.println( "tie( 30): " + tie( 30 ) );
//        System.out.println( "tie( 40): " + tie( 40 ) );
        System.out.println( "probabilityOfTie( 2 ): " + probabilityOfTie( 2 ) );
        System.out.println( "probabilityOfTie( 4 ): " + probabilityOfTie( 4 ) );
        System.out.println( "probabilityOfTie( 6 ): " + probabilityOfTie( 6 ) );
        System.out.println( "probabilityOfTie( 16 ): " + probabilityOfTie( 16 ) );
        System.out.println( "probabilityOfTie( 100 ): " + probabilityOfTie( 100 ) );
        System.out.println( "probabilityOfTie( 1000 ): " + probabilityOfTie( 1000 ) );
        System.out.println( "probabilityOfTie( 10000 ): " + probabilityOfTie( 10000 ) );
        System.out.println( "tieProbability( 2 ): " + tieProbability( 2 ) );
        System.out.println( "tieProbability( 4 ): " + tieProbability( 4 ) );
        System.out.println( "tieProbability( 6 ): " + tieProbability( 6 ) );
        System.out.println( "tieProbability( 16 ): " + tieProbability( 16 ) );
        System.out.println( "tieProbability( 100 ): " + tieProbability( 100 ).doubleValue() );
        System.out.println( "tieProbability( 1,000 ): " + tieProbability( 1000 ).doubleValue() );
        System.out.println( "tieProbability( 10,000 ): " + tieProbability( 10000 ).doubleValue() );
        System.out.println( "tieProbability( 100,000 ): " + tieProbability( 100000 ).doubleValue() );
        System.out.println( "tieProbability( 1000,000 ): " + tieProbability( 1000000 ).doubleValue() );
    }
    
    static BigDecimal tieProbability( int n ) { return tieP( n ); }

    
    static BigDecimal tieP( int n )
    {
        BigInteger numeratorOfNumerator   = BigInteger.ONE;
        BigInteger denominatorOfNumerator = BigInteger.ONE;
        BigInteger denominator            = BigInteger.ONE;
        BigInteger bigIntegerI            = BigInteger.ONE;
        final int halfway = n / 2;
        for ( int i = 2; i <= halfway; i++ )
        {
            bigIntegerI = bigIntegerI.add( BigInteger.ONE );
            denominatorOfNumerator = denominatorOfNumerator.multiply( bigIntegerI );
        }
        for ( int i = 1; i <= halfway; i++ )
        {
            bigIntegerI = bigIntegerI.add( BigInteger.ONE );
            numeratorOfNumerator = numeratorOfNumerator.multiply( bigIntegerI );
        }
        BigDecimal decimalNumeratorOfNumerator   = new BigDecimal( numeratorOfNumerator );
        BigDecimal decimalDenominatorOfNumerator = new BigDecimal( denominatorOfNumerator );
        BigDecimal numerator = decimalNumeratorOfNumerator.divide( decimalDenominatorOfNumerator, 16, RoundingMode.HALF_UP );
        return numerator.divide( new BigDecimal( denominator.shiftLeft( n ) ) );
    }
    
    //    static BigDecimal tieProbability( int n ) { return tieP( new BigDecimal( n ), n/2, one ); }

//    static BigDecimal tieP( BigDecimal n, int i , BigDecimal p )
//    {
//        for ( ; i > 0; i-- )
//        {
//            BigDecimal bigI = new BigDecimal( i );
//            p = p.multiply( n.subtract( bigI.subtract( one ) ) ).divide( bigI.multiply( four ), 4096, RoundingMode.HALF_UP );
//        }
//        return p;
//    }
    
//    static BigDecimal tieP( BigDecimal n, int i , BigDecimal p )
//    {
//        for ( ; i > 0; i-- )
//        {
//            BigDecimal bigI = new BigDecimal( i );
//            p = p.multiply( n.subtract( bigI.subtract( one ) ) ).divide( bigI.multiply( four ), 4096, RoundingMode.HALF_UP );
//        }
//        return p;
//    }
    
    static double probabilityOfTie( int n ) { return pTie( n, n/2, 1.0 ); }
    
    static double pTie( double n, int i , double p )
    {
        return ( i == 0 ) ? p : pTie( n - 1.0, i - 1, p * n / ( 4.0 * i ) );
    }
    
    
    
//    static BigDecimal tieProbability( int n ) { return tieP( new BigDecimal( n ), n/2, one ); }
//    
//    static BigDecimal tieP( BigDecimal n, int i , BigDecimal p )
//    {
//        BigDecimal bigI = new BigDecimal( i );
//        return ( i == 0 ) 
//                ? p 
//                : tieP( 
//                        n.subtract( one ), 
//                        i - 1, 
//                        p.multiply( n ).divide( bigI.multiply( four ), 128, RoundingMode.HALF_UP ) 
//                );
//    }
    
    /**
     * The probability that in an election between 2 choices
     * where the probability of a voter choosing 1 is as likely as choosing 
     * the other that the vote is a tie.
     * Assumes n is even
     * @param n
     * @return 
     */
    static double tie( int n )
    {
        assert n % 2 == 0;
        return comb( n, n / 2 ) / ( (double) ( 1 << n ) );      
    }
    
    static long comb( int n, int i )
    {
        assert n >= i;
        return ( i == 0 ) ? 1 : n * comb( n - 1, i - 1 ) / i;
    }
}
