package io.netty.handler.ssl.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
public final class SelfSignedCertificate {
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private final File privateKey;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelfSignedCertificate.class);
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
    private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);

    public SelfSignedCertificate() throws CertificateException {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    private static boolean isBouncyCastleAvailable() {
        try {
            Class.forName("org.bouncycastle.cert.X509v3CertificateBuilder");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String[] newSelfSignedCertificate(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws IOException, CertificateEncodingException {
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(privateKey.getEncoded());
        try {
            ByteBuf byteBufEncode = Base64.encode(byteBufWrappedBuffer, true);
            try {
                StringBuilder sb2 = new StringBuilder("-----BEGIN PRIVATE KEY-----\n");
                Charset charset = CharsetUtil.US_ASCII;
                sb2.append(byteBufEncode.toString(charset));
                sb2.append("\n-----END PRIVATE KEY-----\n");
                String string = sb2.toString();
                byteBufEncode.release();
                byteBufWrappedBuffer.release();
                String strReplaceAll = str.replaceAll("[^\\w.-]", "x");
                File fileCreateTempFile = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".key", null);
                fileCreateTempFile.deleteOnExit();
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    fileOutputStream.write(string.getBytes(charset));
                    fileOutputStream.close();
                    ByteBuf byteBufWrappedBuffer2 = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
                    try {
                        ByteBuf byteBufEncode2 = Base64.encode(byteBufWrappedBuffer2, true);
                        try {
                            String str2 = "-----BEGIN CERTIFICATE-----\n" + byteBufEncode2.toString(charset) + "\n-----END CERTIFICATE-----\n";
                            byteBufEncode2.release();
                            byteBufWrappedBuffer2.release();
                            File fileCreateTempFile2 = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".crt", null);
                            fileCreateTempFile2.deleteOnExit();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(fileCreateTempFile2);
                            try {
                                fileOutputStream2.write(str2.getBytes(charset));
                                fileOutputStream2.close();
                                return new String[]{fileCreateTempFile2.getPath(), fileCreateTempFile.getPath()};
                            } catch (Throwable th2) {
                                safeClose(fileCreateTempFile2, fileOutputStream2);
                                safeDelete(fileCreateTempFile2);
                                safeDelete(fileCreateTempFile);
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            byteBufEncode2.release();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        byteBufWrappedBuffer2.release();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    safeClose(fileCreateTempFile, fileOutputStream);
                    safeDelete(fileCreateTempFile);
                    throw th5;
                }
            } catch (Throwable th6) {
                byteBufEncode.release();
                throw th6;
            }
        } catch (Throwable th7) {
            byteBufWrappedBuffer.release();
            throw th7;
        }
    }

    private static void safeClose(File file, OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e10) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file: " + file, (Throwable) e10);
            }
        }
    }

    private static void safeDelete(File file) {
        if (file.delete()) {
            return;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to delete a file: " + file);
        }
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public File certificate() {
        return this.certificate;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    public PrivateKey key() {
        return this.key;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public SelfSignedCertificate(Date date, Date date2) throws CertificateException {
        this("localhost", date, date2, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date date, Date date2, String str, int i10) throws CertificateException {
        this("localhost", date, date2, str, i10);
    }

    public SelfSignedCertificate(String str) throws CertificateException {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String str, String str2, int i10) throws CertificateException {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2, i10);
    }

    public SelfSignedCertificate(String str, Date date, Date date2) throws CertificateException {
        this(str, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, date, date2, "RSA");
    }

    public SelfSignedCertificate(String str, Date date, Date date2, String str2, int i10) throws CertificateException {
        this(str, ThreadLocalInsecureRandom.current(), i10, date, date2, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i10) throws CertificateException {
        this(str, secureRandom, i10, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA");
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, String str2, int i10) throws CertificateException {
        this(str, secureRandom, i10, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i10, Date date, Date date2) throws CertificateException {
        this(str, secureRandom, i10, date, date2, "RSA");
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i10, Date date, Date date2, String str2) throws Throwable {
        String[] strArrGenerate;
        FileInputStream fileInputStream;
        Throwable th2;
        Exception e10;
        if (!"EC".equalsIgnoreCase(str2) && !"RSA".equalsIgnoreCase(str2)) {
            throw new IllegalArgumentException(a.a("Algorithm not valid: ", str2));
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str2);
            keyPairGenerator.initialize(i10, secureRandom);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            try {
                strArrGenerate = BouncyCastleSelfSignedCertGenerator.generate(str, keyPairGenerateKeyPair, secureRandom, date, date2, str2);
            } catch (Throwable th3) {
                if (!isBouncyCastleAvailable()) {
                    logger.debug("Failed to generate a self-signed X.509 certificate because BouncyCastle PKIX is not available in classpath");
                } else {
                    logger.debug("Failed to generate a self-signed X.509 certificate using Bouncy Castle:", th3);
                }
                try {
                    strArrGenerate = OpenJdkSelfSignedCertGenerator.generate(str, keyPairGenerateKeyPair, secureRandom, date, date2, str2);
                } catch (Throwable th4) {
                    logger.debug("Failed to generate a self-signed X.509 certificate using sun.security.x509:", th4);
                    CertificateException certificateException = new CertificateException("No provider succeeded to generate a self-signed certificate. See debug log for the root cause.", th4);
                    ThrowableUtil.addSuppressed(certificateException, th3);
                    throw certificateException;
                }
            }
            File file = new File(strArrGenerate[0]);
            this.certificate = file;
            this.privateKey = new File(strArrGenerate[1]);
            this.key = keyPairGenerateKeyPair.getPrivate();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        this.cert = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            if (logger.isWarnEnabled()) {
                                logger.warn("Failed to close a file: " + this.certificate, (Throwable) e11);
                            }
                        }
                    } catch (Exception e12) {
                        e10 = e12;
                        throw new CertificateEncodingException(e10);
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            if (logger.isWarnEnabled()) {
                                logger.warn("Failed to close a file: " + this.certificate, (Throwable) e13);
                            }
                        }
                    }
                    throw th2;
                }
            } catch (Exception e14) {
                fileInputStream = null;
                e10 = e14;
            } catch (Throwable th6) {
                fileInputStream = null;
                th2 = th6;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        } catch (NoSuchAlgorithmException e15) {
            throw new Error(e15);
        }
    }
}
