package com.mohitkanwar.dsa.demo;

import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Signer {
    public String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA512withECDSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));

        byte[] signature = privateSignature.sign();

        return Base64.getEncoder().encodeToString(signature);
    }
}
