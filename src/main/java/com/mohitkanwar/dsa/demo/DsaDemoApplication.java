package com.mohitkanwar.dsa.demo;

import com.mohitkanwar.dsa.demo.keymanager.KeyPairGenerator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.TreeSet;

//@SpringBootApplication
public class DsaDemoApplication {

	public static void main(String[] args) throws Exception {
		//printAvailableAlgos();


		//SpringApplication.run(DsaDemoApplication.class, args);
		//KeyPair keypair = new KeyPairGenerator().generate();
		//KeyPair keypair = new KeyPairGenerator().old();
		//System.out.println("PRIVATEKEY");
		//System.out.println(Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));
		//System.out.println("PUBLICKEY");
		//System.out.println(Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
		//Signer signer = new Signer();
		Verifier verifier = new Verifier();
		//String signed = signer.sign("This is a super important string",keypair.getPrivate());
		//System.out.println("SIGNED");
		String signed = "itL+hFsORuICDaqJiKHMjq8cdUrxgRHR3KCI0BBcngi+G1hm0VEI9T8a8fBDlSOYJAg5G57wO8D9v4fRM4wAHwhQwI8r880nfYmpPa23uJer3XIoInvAKrCRKMC/GmW5kwbpt3milOwkm2F/T4V20ZTft7vgE5NaMxyHYE1ZUF6uAwUAxeg9IPidVh9Z7Tt985UjZK/AYW0Igp7V/tFc3DiA5D8TAm0CCu+Za47sL+u9ZW4Jiv+a7LJInackANjs6sRwFesPffQuRLBZX0W40oLyCeYehpoeiacFY7eh4aJXYsEf30qISV2LZQpQ5wDbryTu171C0ZbyR+tqx+fo2w==";
		//System.out.println(signed);
		String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsZXQ77WS9MZvf/UOeeGDv1TFFm61a1cw3ELNJt3F1hi+2xLzzESzPzKOs4XW11753/m/vGgxRE4Mfr0FVDT9iAMd7POKs3hcbazUOxNHnJfiw/eutjRPXeZuS3WoW10hNy/+AjgIbY3vMsKbIZQz4v1Vskex7hekFIliMN771kUlgDhOlPckUh2fubwefTg9C6pTyqoAXV/AkuPxEqRrGjGnuCa6YvNxyUiAloBUOfQqBx+5Y0NGPe9ckL8apAZNm2B8DCQ6Fw+jTz6+mDxzEjNqFXDnZ5uFVEPxmNd0psafMiHscv28l5BgiLbvUIR+SETaBIzo5xZx7ZOlRLI4/wIDAQAB";
		byte[] publicbyteKey = Base64.decodeBase64(publicKeyString.getBytes(StandardCharsets.UTF_8));
		X509EncodedKeySpec publicKey = new X509EncodedKeySpec(publicbyteKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");

		boolean result = verifier.verify("Nisarg--Tailor",signed, kf.generatePublic(publicKey));
		System.out.println(result);
	}

	private static void printAvailableAlgos() {
		TreeSet<String> algorithms = new TreeSet<>();
		for (Provider provider : Security.getProviders()){
			System.out.println(provider.getName());
			System.out.println("-------");
			for (Provider.Service service : provider.getServices()){
				if (service.getType().equals("Signature")){
					algorithms.add(service.getAlgorithm());
					System.out.println(service.getAlgorithm());
				}
			}
			System.out.println("===========");

		}
	}

}
