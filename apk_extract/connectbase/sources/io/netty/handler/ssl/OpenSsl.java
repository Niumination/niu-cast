package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import ks.g;
import n1.e;

/* JADX INFO: loaded from: classes3.dex */
public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    private static final Set<String> CLIENT_DEFAULT_PROTOCOLS;
    static final List<String> DEFAULT_CIPHERS;
    private static final String[] DEFAULT_NAMED_GROUPS;
    static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
    static final String EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
    private static final boolean IS_BORINGSSL;
    static final boolean JAVAX_CERTIFICATE_CREATION_SUPPORTED;
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final String[] NAMED_GROUPS;
    private static final Set<String> SERVER_DEFAULT_PROTOCOLS;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger;

    /* JADX WARN: Code duplicated, block: B:132:0x028b A[Catch: all -> 0x028f, TRY_ENTER, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0296 A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x029d A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02a4 A[Catch: all -> 0x028f, TRY_LEAVE, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02af A[Catch: all -> 0x02f4, TryCatch #15 {all -> 0x02f4, blocks: (B:129:0x0284, B:144:0x02a7, B:146:0x02af, B:148:0x02c9), top: B:260:0x0284 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x02c9 A[Catch: all -> 0x02f4, TRY_LEAVE, TryCatch #15 {all -> 0x02f4, blocks: (B:129:0x0284, B:144:0x02a7, B:146:0x02af, B:148:0x02c9), top: B:260:0x0284 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x02dd A[Catch: all -> 0x02e5, TryCatch #5 {all -> 0x02e5, blocks: (B:150:0x02d3, B:152:0x02dd, B:157:0x02ee, B:156:0x02ea, B:160:0x02f9, B:166:0x031c, B:168:0x032a, B:170:0x0349, B:169:0x0336), top: B:250:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02ea A[Catch: all -> 0x02e5, TryCatch #5 {all -> 0x02e5, blocks: (B:150:0x02d3, B:152:0x02dd, B:157:0x02ee, B:156:0x02ea, B:160:0x02f9, B:166:0x031c, B:168:0x032a, B:170:0x0349, B:169:0x0336), top: B:250:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x031c A[Catch: all -> 0x02e5, TRY_ENTER, TryCatch #5 {all -> 0x02e5, blocks: (B:150:0x02d3, B:152:0x02dd, B:157:0x02ee, B:156:0x02ea, B:160:0x02f9, B:166:0x031c, B:168:0x032a, B:170:0x0349, B:169:0x0336), top: B:250:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x032a A[Catch: all -> 0x02e5, TryCatch #5 {all -> 0x02e5, blocks: (B:150:0x02d3, B:152:0x02dd, B:157:0x02ee, B:156:0x02ea, B:160:0x02f9, B:166:0x031c, B:168:0x032a, B:170:0x0349, B:169:0x0336), top: B:250:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0336 A[Catch: all -> 0x02e5, TryCatch #5 {all -> 0x02e5, blocks: (B:150:0x02d3, B:152:0x02dd, B:157:0x02ee, B:156:0x02ea, B:160:0x02f9, B:166:0x031c, B:168:0x032a, B:170:0x0349, B:169:0x0336), top: B:250:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0352  */
    /* JADX WARN: Code duplicated, block: B:186:0x0378 A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x037f A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0386 A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x038d A[Catch: all -> 0x028f, TryCatch #27 {all -> 0x028f, blocks: (B:132:0x028b, B:137:0x0296, B:140:0x029d, B:143:0x02a4, B:184:0x0371, B:186:0x0378, B:189:0x037f, B:192:0x0386, B:195:0x038d, B:196:0x0390), top: B:276:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:218:0x0438  */
    /* JADX WARN: Code duplicated, block: B:221:0x0445  */
    /* JADX WARN: Code duplicated, block: B:224:0x0453  */
    /* JADX WARN: Code duplicated, block: B:227:0x0462  */
    /* JADX WARN: Code duplicated, block: B:230:0x0471  */
    /* JADX WARN: Code duplicated, block: B:232:0x0478  */
    /* JADX WARN: Code duplicated, block: B:235:0x048b  */
    /* JADX WARN: Code duplicated, block: B:238:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:264:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x0301 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x03e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0199 A[Catch: all -> 0x0183, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x0183, blocks: (B:62:0x016a, B:64:0x016e, B:66:0x0174, B:69:0x017c, B:74:0x0190, B:78:0x0199), top: B:270:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01eb A[Catch: all -> 0x01fb, TRY_LEAVE, TryCatch #19 {all -> 0x01fb, blocks: (B:86:0x01e5, B:88:0x01eb), top: B:266:0x01e5 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01fd A[DONT_INVERT] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v50, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v51 */
    /* JADX WARN: Type inference failed for: r12v52 */
    /* JADX WARN: Type inference failed for: r12v53 */
    /* JADX WARN: Type inference failed for: r12v54 */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v56 */
    /* JADX WARN: Type inference failed for: r12v57 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    static {
        Throwable th2;
        ?? r10;
        boolean z10;
        ?? r12;
        ?? r13;
        ?? r11;
        LinkedHashSet linkedHashSet;
        List<String> listUnmodifiableList;
        LinkedHashSet linkedHashSet2;
        boolean z11;
        Set<String> setUnmodifiableSet;
        InternalLogger internalLogger;
        boolean z12;
        boolean z13;
        ?? HasNext;
        boolean z14;
        ?? r14;
        long jNewSSL;
        ?? r15;
        long bio;
        long x509Chain;
        long privateKey;
        String[] ciphers;
        int length;
        int i10;
        boolean z15;
        PemPrivateKey pemPrivateKeyValueOf;
        long j10;
        boolean z16;
        boolean z17;
        long bio2;
        boolean z18;
        boolean z19;
        boolean z20;
        String str;
        boolean z21;
        String[] strArrSplit;
        LinkedHashSet linkedHashSet3;
        LinkedHashSet linkedHashSet4;
        LinkedHashSet linkedHashSet5;
        int length2;
        boolean z22;
        String[] strArr;
        String[] strArr2;
        String str2;
        String openSsl;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean zContains;
        boolean z27;
        String str3;
        String str4 = "io.netty.handler.ssl.openssl.useKeyManagerFactory";
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) OpenSsl.class);
        logger = internalLoggerFactory;
        DEFAULT_NAMED_GROUPS = new String[]{"x25519", "secp256r1", "secp384r1", "secp521r1"};
        int i11 = 0;
        if (SystemPropertyUtil.getBoolean("io.netty.handler.ssl.noOpenSsl", false)) {
            e = new UnsupportedOperationException("OpenSSL was explicit disabled with -Dio.netty.handler.ssl.noOpenSsl=true");
            internalLoggerFactory.debug("netty-tcnative explicit disabled; OpenSslEngine will be unavailable.", e);
        } else {
            try {
                Class.forName("io.netty.internal.tcnative.SSLContext", false, PlatformDependent.getClassLoader(OpenSsl.class));
                e = null;
            } catch (ClassNotFoundException e10) {
                e = e10;
                logger.debug("netty-tcnative not in the classpath; OpenSslEngine will be unavailable.");
            }
            if (e == null) {
                try {
                    loadTcNative();
                    th2 = e;
                } catch (Throwable th3) {
                    th2 = th3;
                    logger.debug("Failed to load netty-tcnative; OpenSslEngine will be unavailable, unless the application has already loaded the symbols by some other means. See https://netty.io/wiki/forked-tomcat-native.html for more information.", th2);
                }
                try {
                    String str5 = SystemPropertyUtil.get("io.netty.handler.ssl.openssl.engine", null);
                    if (str5 == null) {
                        logger.debug("Initialize netty-tcnative using engine: 'default'");
                    } else {
                        logger.debug("Initialize netty-tcnative using engine: '{}'", str5);
                    }
                    initializeTcNative(str5);
                    e = null;
                } catch (Throwable th4) {
                    if (th2 == null) {
                        th2 = th4;
                    }
                    logger.debug("Failed to initialize netty-tcnative; OpenSslEngine will be unavailable. See https://netty.io/wiki/forked-tomcat-native.html for more information.", th4);
                    e = th2;
                }
            }
        }
        UNAVAILABILITY_CAUSE = e;
        CLIENT_DEFAULT_PROTOCOLS = protocols("jdk.tls.client.protocols");
        SERVER_DEFAULT_PROTOCOLS = protocols("jdk.tls.server.protocols");
        if (e != null) {
            DEFAULT_CIPHERS = Collections.emptyList();
            AVAILABLE_OPENSSL_CIPHER_SUITES = Collections.emptySet();
            AVAILABLE_JAVA_CIPHER_SUITES = Collections.emptySet();
            AVAILABLE_CIPHER_SUITES = Collections.emptySet();
            SUPPORTS_KEYMANAGER_FACTORY = false;
            USE_KEYMANAGER_FACTORY = false;
            SUPPORTED_PROTOCOLS_SET = Collections.emptySet();
            SUPPORTS_OCSP = false;
            TLSV13_SUPPORTED = false;
            IS_BORINGSSL = false;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
            NAMED_GROUPS = DEFAULT_NAMED_GROUPS;
            JAVAX_CERTIFICATE_CREATION_SUPPORTED = false;
            return;
        }
        logger.debug("netty-tcnative using native library: {}", SSL.versionString());
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet6 = new LinkedHashSet(128);
        String[] strArr3 = DEFAULT_NAMED_GROUPS;
        String[] strArr4 = new String[strArr3.length];
        for (int i12 = 0; i12 < strArr3.length; i12++) {
            strArr4[i12] = GroupsConverter.toOpenSsl(strArr3[i12]);
        }
        boolean zEquals = "BoringSSL".equals(versionString());
        IS_BORINGSSL = zEquals;
        if (zEquals) {
            String[] strArr5 = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256};
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = strArr5;
            StringBuilder sb2 = new StringBuilder(128);
            for (String str6 : strArr5) {
                sb2.append(str6);
                HasNext = ":";
                sb2.append(":");
            }
            sb2.setLength(sb2.length() - 1);
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = sb2.toString();
        } else {
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
        }
        try {
            long jMake = SSLContext.make(63, 1);
            try {
                if (SslProvider.isTlsv13Supported(SslProvider.JDK)) {
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        Iterator<String> it = SslUtils.TLSV13_CIPHERS.iterator();
                        while (true) {
                            HasNext = it.hasNext();
                            if (HasNext == 0) {
                                break;
                            }
                            String openSsl2 = CipherSuiteConverter.toOpenSsl(it.next(), IS_BORINGSSL);
                            if (openSsl2 != null) {
                                sb3.append(openSsl2);
                                sb3.append(e.f11184d);
                            }
                        }
                        if (sb3.length() == 0) {
                            z14 = false;
                        } else {
                            sb3.setLength(sb3.length() - 1);
                            SSLContext.setCipherSuite(jMake, sb3.toString(), true);
                            z14 = true;
                        }
                        z10 = z14;
                        r14 = HasNext;
                    } catch (Exception unused) {
                        z10 = false;
                        r14 = HasNext;
                    } catch (Throwable th5) {
                        th = th5;
                        r10 = 0;
                        z10 = false;
                        r12 = 0;
                        try {
                            SSLContext.free(jMake);
                            throw th;
                        } catch (Exception e11) {
                            e = e11;
                            logger.warn("Failed to get the list of available OpenSSL cipher suites.", (Throwable) e);
                            r11 = r10;
                            r13 = r12;
                            NAMED_GROUPS = strArr3;
                            Set<String> setUnmodifiableSet2 = Collections.unmodifiableSet(linkedHashSet6);
                            AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet2;
                            linkedHashSet = new LinkedHashSet(setUnmodifiableSet2.size() * 2);
                            for (String str7 : setUnmodifiableSet2) {
                                if (SslUtils.isTLSv13Cipher(str7)) {
                                    linkedHashSet.add(str7);
                                } else {
                                    linkedHashSet.add(CipherSuiteConverter.toJava(str7, "TLS"));
                                    linkedHashSet.add(CipherSuiteConverter.toJava(str7, "SSL"));
                                }
                            }
                            SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                            SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                            SslUtils.addIfSupported(linkedHashSet, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                            SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet);
                            listUnmodifiableList = Collections.unmodifiableList(arrayList);
                            DEFAULT_CIPHERS = listUnmodifiableList;
                            Set<String> setUnmodifiableSet3 = Collections.unmodifiableSet(linkedHashSet);
                            AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet3;
                            Set<String> set = AVAILABLE_OPENSSL_CIPHER_SUITES;
                            LinkedHashSet linkedHashSet7 = new LinkedHashSet(setUnmodifiableSet3.size() + set.size());
                            linkedHashSet7.addAll(set);
                            linkedHashSet7.addAll(setUnmodifiableSet3);
                            AVAILABLE_CIPHER_SUITES = linkedHashSet7;
                            SUPPORTS_KEYMANAGER_FACTORY = r13;
                            USE_KEYMANAGER_FACTORY = r11;
                            linkedHashSet2 = new LinkedHashSet(6);
                            linkedHashSet2.add(SslProtocols.SSL_v2_HELLO);
                            if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                                linkedHashSet2.add(SslProtocols.SSL_v2);
                            }
                            if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                                linkedHashSet2.add(SslProtocols.SSL_v3);
                            }
                            if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                                linkedHashSet2.add(SslProtocols.TLS_v1);
                            }
                            if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                                linkedHashSet2.add(SslProtocols.TLS_v1_1);
                            }
                            if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                                linkedHashSet2.add(SslProtocols.TLS_v1_2);
                            }
                            if (z10) {
                                z11 = true;
                                TLSV13_SUPPORTED = false;
                            } else {
                                z11 = true;
                                TLSV13_SUPPORTED = false;
                            }
                            setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet2);
                            SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet;
                            SUPPORTS_OCSP = doesSupportOcsp();
                            internalLogger = logger;
                            if (internalLogger.isDebugEnabled()) {
                                internalLogger.debug("Supported protocols (OpenSSL): {} ", setUnmodifiableSet);
                                internalLogger.debug("Default cipher suites (OpenSSL): {}", listUnmodifiableList);
                            }
                            X509Certificate.getInstance(CERT.getBytes(CharsetUtil.US_ASCII));
                            z12 = z11;
                            JAVAX_CERTIFICATE_CREATION_SUPPORTED = z12;
                        }
                    }
                    try {
                        SSLContext.setCipherSuite(jMake, "ALL", false);
                        jNewSSL = SSL.newSSL(jMake, true);
                        try {
                            try {
                                ciphers = SSL.getCiphers(jNewSSL);
                                length = ciphers.length;
                                for (i10 = 0; i10 < length; i10++) {
                                    try {
                                        str3 = ciphers[i10];
                                        if (str3 != null && !str3.isEmpty() && !linkedHashSet6.contains(str3) && (z10 || !SslUtils.isTLSv13Cipher(str3))) {
                                            linkedHashSet6.add(str3);
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        r15 = 0;
                                        bio = 0;
                                        x509Chain = 0;
                                        privateKey = 0;
                                        SSL.freeSSL(jNewSSL);
                                        if (bio != 0) {
                                            SSL.freeBIO(bio);
                                        }
                                        if (r15 != 0) {
                                            SSL.freeBIO((long) r15);
                                        }
                                        if (x509Chain != 0) {
                                            SSL.freeX509Chain(x509Chain);
                                        }
                                        if (privateKey != 0) {
                                            SSL.freePrivateKey(privateKey);
                                        }
                                        throw th;
                                    }
                                }
                                z15 = IS_BORINGSSL;
                                r15 = str3;
                                if (z15) {
                                    Collections.addAll(linkedHashSet6, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                                    Collections.addAll(linkedHashSet6, "AEAD-AES128-GCM-SHA256", "AEAD-AES256-GCM-SHA384", "AEAD-CHACHA20-POLY1305-SHA256");
                                    r15 = "AEAD-CHACHA20-POLY1305-SHA256";
                                }
                                try {
                                    pemPrivateKeyValueOf = PemPrivateKey.valueOf(KEY.getBytes(CharsetUtil.US_ASCII));
                                    try {
                                        SSLContext.setCertificateCallback(jMake, (CertificateCallback) null);
                                        bio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, selfSignedCertificate());
                                        try {
                                            x509Chain = SSL.parseX509Chain(bio);
                                            try {
                                                bio2 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemPrivateKeyValueOf.retain());
                                                try {
                                                    privateKey = SSL.parsePrivateKey(bio2, (String) null);
                                                    try {
                                                        SSL.setKeyMaterial(jNewSSL, x509Chain, privateKey);
                                                        try {
                                                            zContains = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                                                            if (z15) {
                                                                if (zContains) {
                                                                    try {
                                                                        logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and will be ignored when using BoringSSL");
                                                                    } catch (Throwable unused2) {
                                                                        z25 = true;
                                                                        logger.debug("Failed to get useKeyManagerFactory system property.");
                                                                        z26 = z25;
                                                                    }
                                                                }
                                                                z27 = true;
                                                                z26 = z27;
                                                                pemPrivateKeyValueOf.release();
                                                                r12 = 1;
                                                                bio2 = bio2;
                                                                z20 = z26;
                                                                SSL.freeSSL(jNewSSL);
                                                                if (bio != 0) {
                                                                    SSL.freeBIO(bio);
                                                                }
                                                                if (bio2 != 0) {
                                                                    SSL.freeBIO(bio2);
                                                                }
                                                                if (x509Chain != 0) {
                                                                    SSL.freeX509Chain(x509Chain);
                                                                }
                                                                if (privateKey != 0) {
                                                                    SSL.freePrivateKey(privateKey);
                                                                }
                                                                str = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                                                                if (str != null) {
                                                                    strArrSplit = str.split(g.f9491d);
                                                                    linkedHashSet3 = new LinkedHashSet(strArrSplit.length);
                                                                    linkedHashSet4 = new LinkedHashSet(strArrSplit.length);
                                                                    linkedHashSet5 = new LinkedHashSet();
                                                                    length2 = strArrSplit.length;
                                                                    while (i11 < length2) {
                                                                        z20 = z20;
                                                                        str2 = strArrSplit[i11];
                                                                        String[] strArr6 = strArrSplit;
                                                                        openSsl = GroupsConverter.toOpenSsl(str2);
                                                                        z22 = z20;
                                                                        if (SSLContext.setCurvesList(jMake, new String[]{openSsl})) {
                                                                            linkedHashSet4.add(openSsl);
                                                                            linkedHashSet3.add(str2);
                                                                        } else {
                                                                            linkedHashSet5.add(str2);
                                                                        }
                                                                        i11++;
                                                                        strArrSplit = strArr6;
                                                                        z20 = z22 ? 1 : 0;
                                                                    }
                                                                    z20 = z20;
                                                                    z22 = z20;
                                                                    if (linkedHashSet3.isEmpty()) {
                                                                        logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet5.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                                                        z21 = z22;
                                                                    } else {
                                                                        strArr = EmptyArrays.EMPTY_STRINGS;
                                                                        strArr2 = (String[]) linkedHashSet3.toArray(strArr);
                                                                        if (linkedHashSet5.isEmpty()) {
                                                                            logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr2));
                                                                        } else {
                                                                            logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr2), Arrays.toString(linkedHashSet5.toArray(strArr)));
                                                                        }
                                                                        strArr4 = (String[]) linkedHashSet4.toArray(strArr);
                                                                        z21 = z22;
                                                                    }
                                                                } else {
                                                                    z21 = z20 ? 1 : 0;
                                                                }
                                                                strArr3 = strArr4;
                                                                SSLContext.free(jMake);
                                                                r11 = z21;
                                                                r13 = r12;
                                                            } else {
                                                                z27 = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useKeyManagerFactory", true);
                                                                if (zContains) {
                                                                    try {
                                                                        logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and so will be ignored in the future");
                                                                    } catch (Throwable unused3) {
                                                                        z25 = z27;
                                                                        try {
                                                                            logger.debug("Failed to get useKeyManagerFactory system property.");
                                                                            z26 = z25;
                                                                        } catch (Error unused4) {
                                                                            z24 = true;
                                                                            z23 = z25;
                                                                            bio2 = bio2;
                                                                            z19 = z23;
                                                                            z18 = z24;
                                                                            try {
                                                                                logger.debug("KeyManagerFactory not supported.");
                                                                                pemPrivateKeyValueOf.release();
                                                                                z20 = z19;
                                                                                r12 = z18;
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                pemPrivateKeyValueOf.release();
                                                                                throw th;
                                                                            }
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                            pemPrivateKeyValueOf.release();
                                                                            throw th;
                                                                        }
                                                                    }
                                                                }
                                                                z26 = z27;
                                                                try {
                                                                    pemPrivateKeyValueOf.release();
                                                                    r12 = 1;
                                                                    bio2 = bio2;
                                                                    z20 = z26;
                                                                    try {
                                                                        SSL.freeSSL(jNewSSL);
                                                                        if (bio != 0) {
                                                                            SSL.freeBIO(bio);
                                                                        }
                                                                        if (bio2 != 0) {
                                                                            SSL.freeBIO(bio2);
                                                                        }
                                                                        if (x509Chain != 0) {
                                                                            SSL.freeX509Chain(x509Chain);
                                                                        }
                                                                        if (privateKey != 0) {
                                                                            SSL.freePrivateKey(privateKey);
                                                                        }
                                                                        str = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                                                                        if (str != null) {
                                                                            strArrSplit = str.split(g.f9491d);
                                                                            linkedHashSet3 = new LinkedHashSet(strArrSplit.length);
                                                                            linkedHashSet4 = new LinkedHashSet(strArrSplit.length);
                                                                            linkedHashSet5 = new LinkedHashSet();
                                                                            length2 = strArrSplit.length;
                                                                            while (i11 < length2) {
                                                                                z20 = z20;
                                                                                str2 = strArrSplit[i11];
                                                                                String[] strArr7 = strArrSplit;
                                                                                openSsl = GroupsConverter.toOpenSsl(str2);
                                                                                z22 = z20;
                                                                                try {
                                                                                    if (SSLContext.setCurvesList(jMake, new String[]{openSsl})) {
                                                                                        linkedHashSet4.add(openSsl);
                                                                                        linkedHashSet3.add(str2);
                                                                                    } else {
                                                                                        linkedHashSet5.add(str2);
                                                                                    }
                                                                                    i11++;
                                                                                    strArrSplit = strArr7;
                                                                                    z20 = z22 ? 1 : 0;
                                                                                } catch (Throwable th9) {
                                                                                    th = th9;
                                                                                    r10 = z22;
                                                                                    r12 = r12;
                                                                                    SSLContext.free(jMake);
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                            z20 = z20;
                                                                            z22 = z20;
                                                                            if (linkedHashSet3.isEmpty()) {
                                                                                try {
                                                                                    logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet5.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                                                                    z21 = z22;
                                                                                } catch (Throwable th10) {
                                                                                    th = th10;
                                                                                    strArr3 = strArr4;
                                                                                    r10 = z22;
                                                                                    r12 = r12;
                                                                                    SSLContext.free(jMake);
                                                                                    throw th;
                                                                                }
                                                                            } else {
                                                                                strArr = EmptyArrays.EMPTY_STRINGS;
                                                                                strArr2 = (String[]) linkedHashSet3.toArray(strArr);
                                                                                if (linkedHashSet5.isEmpty()) {
                                                                                    logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr2));
                                                                                } else {
                                                                                    logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr2), Arrays.toString(linkedHashSet5.toArray(strArr)));
                                                                                }
                                                                                strArr4 = (String[]) linkedHashSet4.toArray(strArr);
                                                                                z21 = z22;
                                                                            }
                                                                        } else {
                                                                            z21 = z20 ? 1 : 0;
                                                                        }
                                                                        strArr3 = strArr4;
                                                                        try {
                                                                            SSLContext.free(jMake);
                                                                            r11 = z21;
                                                                            r13 = r12;
                                                                        } catch (Exception e12) {
                                                                            e = e12;
                                                                            r10 = z21;
                                                                            logger.warn("Failed to get the list of available OpenSSL cipher suites.", (Throwable) e);
                                                                            r11 = r10;
                                                                            r13 = r12;
                                                                        }
                                                                    } catch (Throwable th11) {
                                                                        th = th11;
                                                                        r10 = z20;
                                                                        r12 = r12;
                                                                    }
                                                                } catch (Throwable th12) {
                                                                    th = th12;
                                                                    r15 = bio2;
                                                                    SSL.freeSSL(jNewSSL);
                                                                    if (bio != 0) {
                                                                        SSL.freeBIO(bio);
                                                                    }
                                                                    if (r15 != 0) {
                                                                        SSL.freeBIO((long) r15);
                                                                    }
                                                                    if (x509Chain != 0) {
                                                                        SSL.freeX509Chain(x509Chain);
                                                                    }
                                                                    if (privateKey != 0) {
                                                                        SSL.freePrivateKey(privateKey);
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable unused5) {
                                                            z25 = false;
                                                        }
                                                    } catch (Error unused6) {
                                                        z23 = false;
                                                        z24 = false;
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                    }
                                                } catch (Error unused7) {
                                                    z19 = false;
                                                    z18 = false;
                                                    privateKey = 0;
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                }
                                            } catch (Error unused8) {
                                                z19 = false;
                                                z18 = false;
                                                bio2 = 0;
                                                privateKey = 0;
                                            } catch (Throwable th15) {
                                                th = th15;
                                            }
                                        } catch (Error unused9) {
                                            z16 = false;
                                            z17 = false;
                                            bio2 = 0;
                                            x509Chain = 0;
                                            privateKey = x509Chain;
                                            z19 = z16;
                                            z18 = z17;
                                            logger.debug("KeyManagerFactory not supported.");
                                            pemPrivateKeyValueOf.release();
                                            z20 = z19;
                                            r12 = z18;
                                            SSL.freeSSL(jNewSSL);
                                            if (bio != 0) {
                                                SSL.freeBIO(bio);
                                            }
                                            if (bio2 != 0) {
                                                SSL.freeBIO(bio2);
                                            }
                                            if (x509Chain != 0) {
                                                SSL.freeX509Chain(x509Chain);
                                            }
                                            if (privateKey != 0) {
                                                SSL.freePrivateKey(privateKey);
                                            }
                                            str = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                                            if (str != null) {
                                                strArrSplit = str.split(g.f9491d);
                                                linkedHashSet3 = new LinkedHashSet(strArrSplit.length);
                                                linkedHashSet4 = new LinkedHashSet(strArrSplit.length);
                                                linkedHashSet5 = new LinkedHashSet();
                                                length2 = strArrSplit.length;
                                                while (i11 < length2) {
                                                    z20 = z20;
                                                    str2 = strArrSplit[i11];
                                                    String[] strArr8 = strArrSplit;
                                                    openSsl = GroupsConverter.toOpenSsl(str2);
                                                    z22 = z20;
                                                    if (SSLContext.setCurvesList(jMake, new String[]{openSsl})) {
                                                        linkedHashSet4.add(openSsl);
                                                        linkedHashSet3.add(str2);
                                                    } else {
                                                        linkedHashSet5.add(str2);
                                                    }
                                                    i11++;
                                                    strArrSplit = strArr8;
                                                    z20 = z22 ? 1 : 0;
                                                }
                                                z20 = z20;
                                                z22 = z20;
                                                if (linkedHashSet3.isEmpty()) {
                                                    logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet5.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                                    z21 = z22;
                                                } else {
                                                    strArr = EmptyArrays.EMPTY_STRINGS;
                                                    strArr2 = (String[]) linkedHashSet3.toArray(strArr);
                                                    if (linkedHashSet5.isEmpty()) {
                                                        logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr2));
                                                    } else {
                                                        logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr2), Arrays.toString(linkedHashSet5.toArray(strArr)));
                                                    }
                                                    strArr4 = (String[]) linkedHashSet4.toArray(strArr);
                                                    z21 = z22;
                                                }
                                            } else {
                                                z21 = z20 ? 1 : 0;
                                            }
                                            strArr3 = strArr4;
                                            SSLContext.free(jMake);
                                            r11 = z21;
                                            r13 = r12;
                                            NAMED_GROUPS = strArr3;
                                            Set<String> setUnmodifiableSet4 = Collections.unmodifiableSet(linkedHashSet6);
                                            AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet4;
                                            linkedHashSet = new LinkedHashSet(setUnmodifiableSet4.size() * 2);
                                            while (r0.hasNext()) {
                                                if (SslUtils.isTLSv13Cipher(str7)) {
                                                    linkedHashSet.add(CipherSuiteConverter.toJava(str7, "TLS"));
                                                    linkedHashSet.add(CipherSuiteConverter.toJava(str7, "SSL"));
                                                } else {
                                                    linkedHashSet.add(str7);
                                                }
                                            }
                                            SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                                            SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                                            SslUtils.addIfSupported(linkedHashSet, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                                            SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet);
                                            listUnmodifiableList = Collections.unmodifiableList(arrayList);
                                            DEFAULT_CIPHERS = listUnmodifiableList;
                                            Set<String> setUnmodifiableSet5 = Collections.unmodifiableSet(linkedHashSet);
                                            AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet5;
                                            Set<String> set2 = AVAILABLE_OPENSSL_CIPHER_SUITES;
                                            LinkedHashSet linkedHashSet8 = new LinkedHashSet(setUnmodifiableSet5.size() + set2.size());
                                            linkedHashSet8.addAll(set2);
                                            linkedHashSet8.addAll(setUnmodifiableSet5);
                                            AVAILABLE_CIPHER_SUITES = linkedHashSet8;
                                            SUPPORTS_KEYMANAGER_FACTORY = r13;
                                            USE_KEYMANAGER_FACTORY = r11;
                                            linkedHashSet2 = new LinkedHashSet(6);
                                            linkedHashSet2.add(SslProtocols.SSL_v2_HELLO);
                                            if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                                                linkedHashSet2.add(SslProtocols.SSL_v2);
                                            }
                                            if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                                                linkedHashSet2.add(SslProtocols.SSL_v3);
                                            }
                                            if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                                                linkedHashSet2.add(SslProtocols.TLS_v1);
                                            }
                                            if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                                                linkedHashSet2.add(SslProtocols.TLS_v1_1);
                                            }
                                            if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                                                linkedHashSet2.add(SslProtocols.TLS_v1_2);
                                            }
                                            if (z10) {
                                                z11 = true;
                                                TLSV13_SUPPORTED = false;
                                            } else {
                                                z11 = true;
                                                TLSV13_SUPPORTED = false;
                                            }
                                            setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet2);
                                            SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet;
                                            SUPPORTS_OCSP = doesSupportOcsp();
                                            internalLogger = logger;
                                            if (internalLogger.isDebugEnabled()) {
                                                internalLogger.debug("Supported protocols (OpenSSL): {} ", setUnmodifiableSet);
                                                internalLogger.debug("Default cipher suites (OpenSSL): {}", listUnmodifiableList);
                                            }
                                            X509Certificate.getInstance(CERT.getBytes(CharsetUtil.US_ASCII));
                                            z12 = z11;
                                            JAVAX_CERTIFICATE_CREATION_SUPPORTED = z12;
                                        } catch (Throwable th16) {
                                            th = th16;
                                            j10 = 0;
                                            pemPrivateKeyValueOf.release();
                                            throw th;
                                        }
                                    } catch (Error unused10) {
                                        z16 = false;
                                        z17 = false;
                                        bio2 = 0;
                                        bio = 0;
                                        x509Chain = 0;
                                    } catch (Throwable th17) {
                                        th = th17;
                                        j10 = 0;
                                    }
                                } catch (Throwable th18) {
                                    th = th18;
                                }
                            } catch (Throwable th19) {
                                th = th19;
                                r15 = 0;
                                bio = 0;
                                x509Chain = 0;
                                privateKey = 0;
                            }
                        } catch (Throwable th20) {
                            th = th20;
                            r10 = str4;
                            r12 = r14;
                        }
                    } catch (Throwable th21) {
                        th = th21;
                        z13 = false;
                        r12 = 0;
                        r10 = z13;
                        SSLContext.free(jMake);
                        throw th;
                    }
                } else {
                    z10 = false;
                    r14 = HasNext;
                    SSLContext.setCipherSuite(jMake, "ALL", false);
                    jNewSSL = SSL.newSSL(jMake, true);
                    ciphers = SSL.getCiphers(jNewSSL);
                    length = ciphers.length;
                    while (i10 < length) {
                        str3 = ciphers[i10];
                        if (str3 != null) {
                            linkedHashSet6.add(str3);
                        }
                    }
                    z15 = IS_BORINGSSL;
                    r15 = str3;
                    if (z15) {
                        Collections.addAll(linkedHashSet6, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                        Collections.addAll(linkedHashSet6, "AEAD-AES128-GCM-SHA256", "AEAD-AES256-GCM-SHA384", "AEAD-CHACHA20-POLY1305-SHA256");
                        r15 = "AEAD-CHACHA20-POLY1305-SHA256";
                    }
                    pemPrivateKeyValueOf = PemPrivateKey.valueOf(KEY.getBytes(CharsetUtil.US_ASCII));
                    SSLContext.setCertificateCallback(jMake, (CertificateCallback) null);
                    bio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, selfSignedCertificate());
                    x509Chain = SSL.parseX509Chain(bio);
                    bio2 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemPrivateKeyValueOf.retain());
                    privateKey = SSL.parsePrivateKey(bio2, (String) null);
                    SSL.setKeyMaterial(jNewSSL, x509Chain, privateKey);
                    zContains = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                    if (z15) {
                        z27 = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useKeyManagerFactory", true);
                        if (zContains) {
                            logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and so will be ignored in the future");
                        }
                        z26 = z27;
                        pemPrivateKeyValueOf.release();
                        r12 = 1;
                        bio2 = bio2;
                        z20 = z26;
                        SSL.freeSSL(jNewSSL);
                        if (bio != 0) {
                            SSL.freeBIO(bio);
                        }
                        if (bio2 != 0) {
                            SSL.freeBIO(bio2);
                        }
                        if (x509Chain != 0) {
                            SSL.freeX509Chain(x509Chain);
                        }
                        if (privateKey != 0) {
                            SSL.freePrivateKey(privateKey);
                        }
                        str = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                        if (str != null) {
                            strArrSplit = str.split(g.f9491d);
                            linkedHashSet3 = new LinkedHashSet(strArrSplit.length);
                            linkedHashSet4 = new LinkedHashSet(strArrSplit.length);
                            linkedHashSet5 = new LinkedHashSet();
                            length2 = strArrSplit.length;
                            while (i11 < length2) {
                                z20 = z20;
                                str2 = strArrSplit[i11];
                                String[] strArr9 = strArrSplit;
                                openSsl = GroupsConverter.toOpenSsl(str2);
                                z22 = z20;
                                if (SSLContext.setCurvesList(jMake, new String[]{openSsl})) {
                                    linkedHashSet4.add(openSsl);
                                    linkedHashSet3.add(str2);
                                } else {
                                    linkedHashSet5.add(str2);
                                }
                                i11++;
                                strArrSplit = strArr9;
                                z20 = z22 ? 1 : 0;
                            }
                            z20 = z20;
                            z22 = z20;
                            if (linkedHashSet3.isEmpty()) {
                                logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet5.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                z21 = z22;
                            } else {
                                strArr = EmptyArrays.EMPTY_STRINGS;
                                strArr2 = (String[]) linkedHashSet3.toArray(strArr);
                                if (linkedHashSet5.isEmpty()) {
                                    logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr2));
                                } else {
                                    logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr2), Arrays.toString(linkedHashSet5.toArray(strArr)));
                                }
                                strArr4 = (String[]) linkedHashSet4.toArray(strArr);
                                z21 = z22;
                            }
                        } else {
                            z21 = z20 ? 1 : 0;
                        }
                        strArr3 = strArr4;
                        SSLContext.free(jMake);
                        r11 = z21;
                        r13 = r12;
                    } else {
                        if (zContains) {
                            logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and will be ignored when using BoringSSL");
                        }
                        z27 = true;
                        z26 = z27;
                        pemPrivateKeyValueOf.release();
                        r12 = 1;
                        bio2 = bio2;
                        z20 = z26;
                        SSL.freeSSL(jNewSSL);
                        if (bio != 0) {
                            SSL.freeBIO(bio);
                        }
                        if (bio2 != 0) {
                            SSL.freeBIO(bio2);
                        }
                        if (x509Chain != 0) {
                            SSL.freeX509Chain(x509Chain);
                        }
                        if (privateKey != 0) {
                            SSL.freePrivateKey(privateKey);
                        }
                        str = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                        if (str != null) {
                            strArrSplit = str.split(g.f9491d);
                            linkedHashSet3 = new LinkedHashSet(strArrSplit.length);
                            linkedHashSet4 = new LinkedHashSet(strArrSplit.length);
                            linkedHashSet5 = new LinkedHashSet();
                            length2 = strArrSplit.length;
                            while (i11 < length2) {
                                z20 = z20;
                                str2 = strArrSplit[i11];
                                String[] strArr10 = strArrSplit;
                                openSsl = GroupsConverter.toOpenSsl(str2);
                                z22 = z20;
                                if (SSLContext.setCurvesList(jMake, new String[]{openSsl})) {
                                    linkedHashSet4.add(openSsl);
                                    linkedHashSet3.add(str2);
                                } else {
                                    linkedHashSet5.add(str2);
                                }
                                i11++;
                                strArrSplit = strArr10;
                                z20 = z22 ? 1 : 0;
                            }
                            z20 = z20;
                            z22 = z20;
                            if (linkedHashSet3.isEmpty()) {
                                logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet5.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                z21 = z22;
                            } else {
                                strArr = EmptyArrays.EMPTY_STRINGS;
                                strArr2 = (String[]) linkedHashSet3.toArray(strArr);
                                if (linkedHashSet5.isEmpty()) {
                                    logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr2));
                                } else {
                                    logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr2), Arrays.toString(linkedHashSet5.toArray(strArr)));
                                }
                                strArr4 = (String[]) linkedHashSet4.toArray(strArr);
                                z21 = z22;
                            }
                        } else {
                            z21 = z20 ? 1 : 0;
                        }
                        strArr3 = strArr4;
                        SSLContext.free(jMake);
                        r11 = z21;
                        r13 = r12;
                    }
                }
                NAMED_GROUPS = strArr3;
                Set<String> setUnmodifiableSet6 = Collections.unmodifiableSet(linkedHashSet6);
                AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet6;
                linkedHashSet = new LinkedHashSet(setUnmodifiableSet6.size() * 2);
                while (r0.hasNext()) {
                    if (SslUtils.isTLSv13Cipher(str7)) {
                        linkedHashSet.add(CipherSuiteConverter.toJava(str7, "TLS"));
                        linkedHashSet.add(CipherSuiteConverter.toJava(str7, "SSL"));
                    } else {
                        linkedHashSet.add(str7);
                    }
                }
                SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                SslUtils.addIfSupported(linkedHashSet, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                SslUtils.addIfSupported(linkedHashSet, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet);
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
                DEFAULT_CIPHERS = listUnmodifiableList;
                Set<String> setUnmodifiableSet7 = Collections.unmodifiableSet(linkedHashSet);
                AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet7;
                Set<String> set3 = AVAILABLE_OPENSSL_CIPHER_SUITES;
                LinkedHashSet linkedHashSet9 = new LinkedHashSet(setUnmodifiableSet7.size() + set3.size());
                linkedHashSet9.addAll(set3);
                linkedHashSet9.addAll(setUnmodifiableSet7);
                AVAILABLE_CIPHER_SUITES = linkedHashSet9;
                SUPPORTS_KEYMANAGER_FACTORY = r13;
                USE_KEYMANAGER_FACTORY = r11;
                linkedHashSet2 = new LinkedHashSet(6);
                linkedHashSet2.add(SslProtocols.SSL_v2_HELLO);
                if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                    linkedHashSet2.add(SslProtocols.SSL_v2);
                }
                if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                    linkedHashSet2.add(SslProtocols.SSL_v3);
                }
                if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                    linkedHashSet2.add(SslProtocols.TLS_v1);
                }
                if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                    linkedHashSet2.add(SslProtocols.TLS_v1_1);
                }
                if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                    linkedHashSet2.add(SslProtocols.TLS_v1_2);
                }
                if (z10 || !doesSupportProtocol(32, SSL.SSL_OP_NO_TLSv1_3)) {
                    z11 = true;
                    TLSV13_SUPPORTED = false;
                } else {
                    linkedHashSet2.add(SslProtocols.TLS_v1_3);
                    z11 = true;
                    TLSV13_SUPPORTED = true;
                }
                setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet2);
                SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet;
                SUPPORTS_OCSP = doesSupportOcsp();
                internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Supported protocols (OpenSSL): {} ", setUnmodifiableSet);
                    internalLogger.debug("Default cipher suites (OpenSSL): {}", listUnmodifiableList);
                }
                try {
                    X509Certificate.getInstance(CERT.getBytes(CharsetUtil.US_ASCII));
                    z12 = z11;
                } catch (CertificateException unused11) {
                    z12 = false;
                }
                JAVAX_CERTIFICATE_CREATION_SUPPORTED = z12;
            } catch (Throwable th22) {
                th = th22;
                z13 = false;
                z10 = false;
            }
        } catch (Exception e13) {
            e = e13;
            r10 = 0;
            z10 = false;
            r12 = 0;
        }
    }

    private OpenSsl() {
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static String checkTls13Ciphers(InternalLogger internalLogger, String str) {
        boolean z10;
        if (IS_BORINGSSL && !str.isEmpty()) {
            String[] strArr = EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
            HashSet hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
            String[] strArrSplit = str.split(":");
            int length = strArrSplit.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                }
                String str2 = strArrSplit[i10];
                if (hashSet.isEmpty() || (!hashSet.remove(str2) && !hashSet.remove(CipherSuiteConverter.toJava(str2, "TLS")))) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if ((!hashSet.isEmpty()) | z10) {
                if (internalLogger.isInfoEnabled()) {
                    StringBuilder sb2 = new StringBuilder(128);
                    for (String str3 : str.split(":")) {
                        sb2.append(CipherSuiteConverter.toJava(str3, "TLS"));
                        sb2.append(":");
                    }
                    sb2.setLength(sb2.length() - 1);
                    internalLogger.info("BoringSSL doesn't allow to enable or disable TLSv1.3 ciphers explicitly. Provided TLSv1.3 ciphers: '{}', default TLSv1.3 ciphers that will be used: '{}'.", sb2, EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING);
                }
                return EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
            }
        }
        return str;
    }

    public static String[] defaultProtocols(boolean z10) {
        Set<String> set = z10 ? CLIENT_DEFAULT_PROTOCOLS : SERVER_DEFAULT_PROTOCOLS;
        if (set == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(set.size());
        for (String str : set) {
            if (SUPPORTED_PROTOCOLS_SET.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    private static boolean doesSupportOcsp() throws Throwable {
        long jMake;
        if (version() < 268443648) {
            return false;
        }
        try {
            jMake = SSLContext.make(16, 1);
            try {
                SSLContext.enableOcsp(jMake, false);
                if (jMake != -1) {
                    SSLContext.free(jMake);
                }
                return true;
            } catch (Exception unused) {
                if (jMake == -1) {
                    return false;
                }
                SSLContext.free(jMake);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (jMake != -1) {
                    SSLContext.free(jMake);
                }
                throw th;
            }
        } catch (Exception unused2) {
            jMake = -1;
        } catch (Throwable th3) {
            th = th3;
            jMake = -1;
        }
    }

    private static boolean doesSupportProtocol(int i10, int i11) {
        if (i11 == 0) {
            return false;
        }
        try {
            long jMake = SSLContext.make(i10, 2);
            if (jMake == -1) {
                return true;
            }
            SSLContext.free(jMake);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ensureAvailability() {
        Throwable th2 = UNAVAILABILITY_CAUSE;
        if (th2 != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th2));
        }
    }

    private static boolean initializeTcNative(String str) throws Exception {
        return Library.initialize("provided", str);
    }

    @Deprecated
    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isBoringSSL() {
        return IS_BORINGSSL;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str, IS_BORINGSSL);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    public static boolean isOptionSupported(SslContextOption<?> sslContextOption) {
        if (!isAvailable()) {
            return false;
        }
        if (sslContextOption == OpenSslContextOption.USE_TASKS) {
            return true;
        }
        if (isBoringSSL()) {
            return sslContextOption == OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD || sslContextOption == OpenSslContextOption.PRIVATE_KEY_METHOD || sslContextOption == OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS || sslContextOption == OpenSslContextOption.TLS_FALSE_START || sslContextOption == OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES;
        }
        return false;
    }

    public static boolean isSessionCacheSupported() {
        return ((long) version()) >= 269484032;
    }

    public static boolean isTlsv13Supported() {
        return TLSV13_SUPPORTED;
    }

    private static void loadTcNative() throws Exception {
        String strNormalizedOs = PlatformDependent.normalizedOs();
        String strNormalizedArch = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet = new LinkedHashSet(5);
        if ("linux".equals(strNormalizedOs)) {
            Iterator<String> it = PlatformDependent.normalizedLinuxClassifiers().iterator();
            while (it.hasNext()) {
                linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch + "_" + it.next());
            }
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch);
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch + "_fedora");
        } else {
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch);
        }
        linkedHashSet.add("netty_tcnative_" + strNormalizedArch);
        linkedHashSet.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(PlatformDependent.getClassLoader(SSLContext.class), (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS));
    }

    public static long memoryAddress(ByteBuf byteBuf) {
        return byteBuf.hasMemoryAddress() ? byteBuf.memoryAddress() : Buffer.address(byteBuf.internalNioBuffer(0, byteBuf.readableBytes()));
    }

    private static Set<String> protocols(String str) {
        HashSet hashSet = null;
        String str2 = SystemPropertyUtil.get(str, null);
        if (str2 != null) {
            hashSet = new HashSet();
            for (String str3 : str2.split(g.f9491d)) {
                hashSet.add(str3.trim());
            }
        }
        return hashSet;
    }

    public static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }

    public static java.security.cert.X509Certificate selfSignedCertificate() throws java.security.cert.CertificateException {
        return (java.security.cert.X509Certificate) SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream(CERT.getBytes(CharsetUtil.US_ASCII)));
    }

    @Deprecated
    public static boolean supportsHostnameValidation() {
        return isAvailable();
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }
}
