package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

    @Test
    public  void Constructortest() {
        PrimeGenerator primenumbers = new PrimeGenerator(1,10);
        primenumbers.generatePrimes();

        Long[] expectprimes= {2L,3L,5L,7L};
        assertArrayEquals(expectprimes,primenumbers.getPrimes().toArray() ,"done with the primes");
    }
}