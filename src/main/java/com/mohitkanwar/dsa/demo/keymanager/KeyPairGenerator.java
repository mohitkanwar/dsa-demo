package com.mohitkanwar.dsa.demo.keymanager;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyPairGenerator {
    public KeyPair generate() throws NoSuchAlgorithmException {
        java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024, new SecureRandom());
        KeyPair dsaKeyPair = kpg.generateKeyPair();
        return dsaKeyPair;
    }
    public KeyPair old() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8Wb6MD4pCtZ3Z+fq0sC+pM+c0/IetEg1x/lT44jXvqF1+9ytdcA1FO8V6jzJ2/fUEDN/2V0qNpqepTRXwDn6vc16CSGroMr3DVAKDyE7Xkv1ztZWEe+OAMQ3FO7j6Ty3bCDkIGNEV/uMro1GRdgb8/1gsf6jatQ+iV9tuBJgyjkxIl5wzNv6RGlz4P/3GA+vPvuubAhbgTJIT6/WpGDz4P9sAwLCqBEshw5+ItVbVBmYB18je09TFfTqfam6jbD0Sg228UASn+yXNXnhJ0BPOSaX3FR5XDG1/Kncq820n0lMRCTRYcCFmblRceGf9WaXCaPbMjU/ug1VIbK0nfcTyQIDAQAB";
        String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK4QAjPHzCzEOT7aHFBsG4iTg6utujFxom/H78UOqXFmSmMLJDLhUHw8TGgyRGEUQ8B3RQXe5beRwVZnZxLJ5kMUY20PqnQNdWZm46tGvQFO/VAbKVncjqwz/Ab8Qrc0fJK0ubLXTTTvQpyoqM5z82o/RWtSGCRuWwO1o4rZhoi1AgMBAAECgYAfNT8T1h2BJEBoSLZdY/iuzNYFhK02urtHQ+d1IxsVuiOZrPB1T+j8kVoYr3SLnFTGcAv30L5Koq8xpPH50CnArf9xJ7lDm+UdR0Bspt8XiOXcBJeiGFYBUT6k8OY3ZeJ8l8dcYYfF7YS4Xctw2Vig+OnRXATMdFJVEBOu1k2XsQJBAPe01INg6to4R+GbgjG82FlZ2cL6DpdJSt7iJ5kTat2xVcwHZZASwCihdzUB7uyk6nzoFs0lGXB3XljHejEL3jECQQCz4/QskZ8BV5jmW/usBW3SgRRC8HkmFMEV1UdCp1efVHvy2wdchYSXmXlzSSHoFX4TRjmLoQhdI+RnnIrLiR3FAkAZOLdevTKMj6h6B0yFZfYdevGaUb3El7jg4uQnSPvboN/ci3BC8DXSrUYnBpBeVhhuKW+Q6dMiSXU40u7VKaExAkEAh9DrYVrwecrxHbsE4HOY3v2lloSIcz/oJ9vG2YQOm7TlgA3uGOSVnv+4ulnUx6yya0rx14HVFr0qjS+beuAjIQJBAOrcTyvRXwpc5bMbSm5txTKQ+Aw37kIKoKuYIGz7ATlKTQXApo8qm9yXa2LPX61DcJseS4P3rJeyV280+JXqgSs==";
//        String privateKeyString = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKRaWzSmY9Xz7KRIKhFAbhZTultPjcjK8CE4JnjEcIDpzRyAJS+vlsm6Wb2aMyCpILwVquyA6aWIGnrpFs5WC/7Sdx7zp5sMxyky/yEgGyjvSGpSXUkdhj+qqnQg96FLEs/Jw9eayaYqsgo1CCnLlterA9yL0FNJ3wZv4XOcVj0fAgMBAAECgYAUX/yX8FtxdhtLhS7B6MI9E7AyCxDBaHc7MbeDQpx36YQ7bkot4+TGVCCKot0ycAUrjBFz3x9tcra7BL6GYfXRM88h7coMjqkGt/U8MwaXogQkcOpgO/D6yrck/VSjmuPpwv5x1sJkrzJIrPVFXA7pCwzDh5JDmnGzc9mjJwjmUQJBAPTdSoSL4qhsnXWE2nnNYXGyf/8e/fExFejkOU2uYF5Besg0pbEIa6V82TLH1RkT31GgrjbWpxj37wDx8eLngMMCQQCr08BoQtKQapfO/4MTXOzBzJRbOIs134cIe4VRkJo8gjP0wpzGT3TorsHTtCXapUJawkchI5WmeWFo2fxrj8x1AkEAtHomYmt4NAtaQzQYk439NIAMN03wfcVgELemRMsx3EcG6GlldoZuURskO3luZ31uLAvyXBj6MD0Nu/SYBFX9YQJAWeUTwbhMD1AlEh/thIDWQOH2L+9aLZo/PDnbWvvrJYL9Ca2TddD2GhHryAV01HonR/JiYj0Kuyi/xKpe/CskTQJAIgZNkABOU00IfZ1bQbdAzyYUHJjVEzx39ZHdprx6hycCoOri1EV42XKyxRqLpIoExrYSWW8MyPawkLNIc6ViCA==";

        byte[] publicbyteKey = Base64.decodeBase64(publicKeyString.getBytes(StandardCharsets.UTF_8));
        byte[] privatebyteKey = Base64.decodeBase64(privateKeyString.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec publicKey = new X509EncodedKeySpec(publicbyteKey);
        PKCS8EncodedKeySpec privateKey = new PKCS8EncodedKeySpec(privatebyteKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        KeyPair keyPair = new KeyPair(kf.generatePublic(publicKey),kf.generatePrivate(privateKey));
        return keyPair;
    }
}
