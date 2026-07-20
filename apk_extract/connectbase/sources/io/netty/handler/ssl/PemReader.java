package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class PemReader {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PemReader.class);
    private static final Pattern CERT_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
    private static final Pattern CERT_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
    private static final Pattern KEY_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
    private static final Pattern KEY_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
    private static final Pattern BODY = Pattern.compile("[a-z0-9+/=][a-z0-9+/=\\r\\n]*", 2);

    private PemReader() {
    }

    private static KeyException keyNotFoundException() {
        return new KeyException("could not find a PKCS #8 private key in input stream (see https://netty.io/wiki/sslcontextbuilder-and-private-key.html for more information)");
    }

    public static ByteBuf[] readCertificates(File file) throws CertificateException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return readCertificates(fileInputStream);
            } finally {
                safeClose(fileInputStream);
            }
        } catch (FileNotFoundException unused) {
            throw new CertificateException("could not find certificate file: " + file);
        }
    }

    private static String readContent(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 < 0) {
                    return byteArrayOutputStream.toString(CharsetUtil.US_ASCII.name());
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } finally {
            safeClose(byteArrayOutputStream);
        }
    }

    public static ByteBuf readPrivateKey(File file) throws KeyException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return readPrivateKey(fileInputStream);
            } finally {
                safeClose(fileInputStream);
            }
        } catch (FileNotFoundException unused) {
            throw new KeyException("could not find key file: " + file);
        }
    }

    private static void safeClose(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e10) {
            logger.warn("Failed to close a stream.", (Throwable) e10);
        }
    }

    private static void safeClose(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e10) {
            logger.warn("Failed to close a stream.", (Throwable) e10);
        }
    }

    public static ByteBuf[] readCertificates(InputStream inputStream) throws CertificateException {
        try {
            String content = readContent(inputStream);
            ArrayList arrayList = new ArrayList();
            Matcher matcher = CERT_HEADER.matcher(content);
            int iEnd = 0;
            while (matcher.find(iEnd)) {
                matcher.usePattern(BODY);
                if (!matcher.find()) {
                    break;
                }
                ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(matcher.group(0), CharsetUtil.US_ASCII);
                matcher.usePattern(CERT_FOOTER);
                if (!matcher.find()) {
                    break;
                }
                ByteBuf byteBufDecode = Base64.decode(byteBufCopiedBuffer);
                byteBufCopiedBuffer.release();
                arrayList.add(byteBufDecode);
                iEnd = matcher.end();
                matcher.usePattern(CERT_HEADER);
            }
            if (!arrayList.isEmpty()) {
                return (ByteBuf[]) arrayList.toArray(new ByteBuf[0]);
            }
            throw new CertificateException("found no certificates in input stream");
        } catch (IOException e10) {
            throw new CertificateException("failed to read certificate input stream", e10);
        }
    }

    public static ByteBuf readPrivateKey(InputStream inputStream) throws KeyException {
        try {
            Matcher matcher = KEY_HEADER.matcher(readContent(inputStream));
            if (matcher.find()) {
                matcher.usePattern(BODY);
                if (matcher.find()) {
                    ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(matcher.group(0), CharsetUtil.US_ASCII);
                    matcher.usePattern(KEY_FOOTER);
                    if (matcher.find()) {
                        ByteBuf byteBufDecode = Base64.decode(byteBufCopiedBuffer);
                        byteBufCopiedBuffer.release();
                        return byteBufDecode;
                    }
                    throw keyNotFoundException();
                }
                throw keyNotFoundException();
            }
            throw keyNotFoundException();
        } catch (IOException e10) {
            throw new KeyException("failed to read key input stream", e10);
        }
    }
}
