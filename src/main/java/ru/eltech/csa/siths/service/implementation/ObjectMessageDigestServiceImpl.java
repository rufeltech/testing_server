package ru.eltech.csa.siths.service.implementation;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import ru.eltech.csa.siths.service.base.AbstractObjectMessageDigestService;
import ru.eltech.csa.siths.service.behaviour.ObjectMessageDigestService;

import ru.eltech.csa.siths.entity.node.Issue;

@Service
public class ObjectMessageDigestServiceImpl extends AbstractObjectMessageDigestService implements ObjectMessageDigestService  {

    public ObjectMessageDigestServiceImpl(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);
    }

    public ObjectMessageDigestServiceImpl(MessageDigest messageDigest) {
        super(messageDigest);
    }

    public ObjectMessageDigestServiceImpl() {

    }

    public String getObjectMessageDigest(Object object) {
        try {
            this.messageDigest.update( this.serialize(object) ); 
            StringBuffer stringBuffer = new StringBuffer();
            byte[] messageDigestBytes = this.messageDigest.digest();
            for (byte b : messageDigestBytes) {
                stringBuffer.append(String.format("%02x", b & 0xff));
            }
            return stringBuffer.toString();
        } catch (IOException e) {  
            return null;
        }
    }

    private byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream bAOStream = new ByteArrayOutputStream();
        ObjectOutputStream oOStream = new ObjectOutputStream(bAOStream);
        oOStream.writeObject(object);
        return bAOStream.toByteArray();
    }

}