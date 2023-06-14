Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
< p 5> a program in Java that performs encryption and decryption using the AES (Advanced Encryption Standard) algorithm:

java
------------------------------------------------------------------------------------------------------------------
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;
 class EncryptionDecryptionExample {
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String SECRET_KEY = "ThisIsASecretKey";

    public static void main(String[] args) {
        String originalString = "Hello, World!";

        // Encrypt the string
        String encryptedString = encrypt(originalString);
        System.out.println("Encrypted string: " + encryptedString);

        // Decrypt the string
        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted string: " + decryptedString);
    }

    public static String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptedString) {
        try {
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

--------------------------------------------------------------------------------------------
output

Encrypted string: sGcPScqj8Z6Y9c3thb0MZg==
Decrypted string: Hello, World!