import java.util.*;

public class OTPGenerators {

    public static int generateOTP() {
       
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> otpSet = new HashSet<>();
        
        for (int otp : otps) {
            
            if (!otpSet.add(otp)) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("Generated OTP #" + (i + 1) + ": " + otps[i]);
        }

      
        if (areOTPsUnique(otps)) {
            System.out.println("\nAll generated OTPs are unique.");
        } else {
            System.out.println("\nSome OTPs are duplicate.");
        }
    }
}
