package ru.eltech.csa.siths.service.base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractObjectMessageDigestService {
	
	protected MessageDigest messageDigest;

	public AbstractObjectMessageDigestService(String algorithm) throws NoSuchAlgorithmException {
		this.messageDigest = MessageDigest.getInstance(algorithm);
		messageDigest.reset();
	}

	public AbstractObjectMessageDigestService(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

	public AbstractObjectMessageDigestService() {
		
	}

	public void setAlgorithm(String algorithm) throws NoSuchAlgorithmException {
		this.messageDigest = MessageDigest.getInstance(algorithm);
		messageDigest.reset();
	}

	public String getAlgorithm() {
		return this.messageDigest.getAlgorithm();
	}

	public void setMessageDigest(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

	public MessageDigest getMessageDigest() {
		return this.messageDigest;
	}

}