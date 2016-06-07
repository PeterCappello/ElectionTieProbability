package electiontieprobability;

/**
 *
 * @author petercappello
 */
public class ElectionTieProbability 
{
    public static void main( String[] args )
    {
        System.out.println( "1 << 1: " +  (1 << 1) );
        System.out.println( "1 << 2: " +  (1 << 2) );
        System.out.println( "1 << 10: " +  (1 << 10) );
        System.out.println( "( (double) ( 1 << 1 ) ): " +  (( (double) ( 1 << 1 ) )) );
        System.out.println( "( (double) ( 1 << 2 ) ): " +  (( (double) ( 1 << 2 ) )) );
        System.out.println( "( (double) ( 1 << 10 ) ): " +  (( (double) ( 1 << 10 ) )) );
        System.out.println( "comb( 2,1): " +  comb(2, 1) );
        System.out.println( "comb( 4,2): " +  comb(4, 2) );
        System.out.println( "comb( 6,3): " +  comb(6, 3) );
        System.out.println( "comb( 8,4): " +  comb(8, 4) );
        System.out.println( "comb( 10,5): " +  comb(10, 5) );
        System.out.println( "tie( 2): " +  tie( 2 ) );
        System.out.println( "tie( 4): " +  tie( 4 ) );
        System.out.println( "tie( 6): " +  tie( 6 ) );
        System.out.println( "tie( 8): " +  tie( 8 ) );
        System.out.println( "tie( 10): " + tie( 10 ) );
        System.out.println( "tie( 20): " + tie( 20 ) );
        System.out.println( "tie( 30): " + tie( 30 ) );
        System.out.println( "tie( 40): " + tie( 40 ) ); // too big. Need to do BigDecimal.
    }
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
        if ( i == 0 ) return 1;
        return n * comb( n - 1, i - 1 ) / i;
    }
}
