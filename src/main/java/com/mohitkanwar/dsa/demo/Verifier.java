package com.mohitkanwar.dsa.demo;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Verifier {
    public boolean verify(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes(UTF_8));

        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        return publicSignature.verify(signatureBytes);
    }
}
