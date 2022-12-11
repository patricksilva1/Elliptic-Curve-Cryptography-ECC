import java.util.Random;

public class App {
    public static void main(String[] args) {

        // These are all public data. The ECC and the generator point.
        ECC ecc = new ECC(3, 7);

        Point generator = new Point(-2, 1);

        Random random = new Random();

        // Elliptic Curve Diffie-Hellman Algorithm
        // Random number for Person A
        int a = random.nextInt(10000);

        // Random number for Person B
        int b = random.nextInt(10000);

        // Public keys with the double and add algorithm
        // These are points on elliptic curve
        Point personAPublicKey = ecc.doubleAndAdd(a, generator);
        Point personBPublicKey = ecc.doubleAndAdd(b, generator);

        // They can generate the same private key, they can use for symmetric encryption
        Point personASecretKey = ecc.doubleAndAdd(a, personBPublicKey);
        Point personBSecretKey = ecc.doubleAndAdd(b, personAPublicKey);

        // The minimal inconsistency about the value of secret keys is because we are using double instead of big decimal or big integer.
        System.out.println("Person A's Secret Key: " + personASecretKey);
        System.out.println("Person B's Secret Key: " + personBSecretKey);

        System.out.println("So here we find that these 2 keys are mathing, we find the secret key from the public key, this is working fine! ");
    }   
}
