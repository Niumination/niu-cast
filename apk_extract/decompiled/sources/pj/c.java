package pj;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import k3.b2;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import vj.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8916a = new c();

    public static List a(X509Certificate x509Certificate, int i8) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i8)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt.emptyList();
        }
    }

    public static boolean b(String str) {
        int i8;
        int length = str.length();
        int length2 = str.length();
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (length2 < 0) {
            throw new IllegalArgumentException(h0.a.h(length2, "endIndex < beginIndex: ", " < 0").toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbU = a1.a.u(length2, "endIndex > string.length: ", " > ");
            sbU.append(str.length());
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        long j8 = 0;
        int i9 = 0;
        while (i9 < length2) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < 128) {
                j8++;
            } else {
                if (cCharAt < 2048) {
                    i8 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i8 = 3;
                } else {
                    int i10 = i9 + 1;
                    char cCharAt2 = i10 < length2 ? str.charAt(i10) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j8++;
                        i9 = i10;
                    } else {
                        j8 += (long) 4;
                        i9 += 2;
                    }
                }
                j8 += (long) i8;
            }
            i9++;
        }
        return length == ((int) j8);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0104  */
    public static boolean c(String canParseAsIpAddress, X509Certificate certificate) {
        boolean zAreEqual;
        int length;
        Intrinsics.checkNotNullParameter(canParseAsIpAddress, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        byte[] bArr = ej.b.f4964a;
        Intrinsics.checkNotNullParameter(canParseAsIpAddress, "$this$canParseAsIpAddress");
        if (ej.b.f.matches(canParseAsIpAddress)) {
            String strB = b2.b(canParseAsIpAddress);
            List listA = a(certificate, 7);
            if (!(listA instanceof Collection) || !listA.isEmpty()) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(strB, b2.b((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            if (b(canParseAsIpAddress)) {
                Locale locale = Locale.US;
                canParseAsIpAddress = a1.a.t(locale, "Locale.US", canParseAsIpAddress, locale, "(this as java.lang.String).toLowerCase(locale)");
            }
            List<String> listA2 = a(certificate, 2);
            if (!(listA2 instanceof Collection) || !listA2.isEmpty()) {
                for (String strT : listA2) {
                    if (canParseAsIpAddress == null || canParseAsIpAddress.length() == 0 || StringsKt__StringsJVMKt.startsWith$default(canParseAsIpAddress, ".", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(canParseAsIpAddress, "..", false, 2, null) || strT == null || strT.length() == 0 || StringsKt__StringsJVMKt.startsWith$default(strT, ".", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(strT, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else {
                        String strConcat = !StringsKt__StringsJVMKt.endsWith$default(canParseAsIpAddress, ".", false, 2, null) ? canParseAsIpAddress.concat(".") : canParseAsIpAddress;
                        if (!StringsKt__StringsJVMKt.endsWith$default(strT, ".", false, 2, null)) {
                            strT = strT.concat(".");
                        }
                        if (b(strT)) {
                            Locale locale2 = Locale.US;
                            strT = a1.a.t(locale2, "Locale.US", strT, locale2, "(this as java.lang.String).toLowerCase(locale)");
                        }
                        if (!StringsKt__StringsKt.contains$default(strT, e.ANY_MARKER, false, 2, (Object) null)) {
                            zAreEqual = Intrinsics.areEqual(strConcat, strT);
                        } else if (!StringsKt__StringsJVMKt.startsWith$default(strT, "*.", false, 2, null) || StringsKt__StringsKt.indexOf$default((CharSequence) strT, '*', 1, false, 4, (Object) null) != -1 || strConcat.length() < strT.length() || Intrinsics.areEqual("*.", strT)) {
                            zAreEqual = false;
                        } else {
                            String strSubstring = strT.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            if (StringsKt__StringsJVMKt.endsWith$default(strConcat, strSubstring, false, 2, null) && ((length = strConcat.length() - strSubstring.length()) <= 0 || StringsKt__StringsKt.lastIndexOf$default((CharSequence) strConcat, '.', length - 1, false, 4, (Object) null) == -1)) {
                                zAreEqual = true;
                            } else {
                                zAreEqual = false;
                            }
                        }
                    }
                    if (zAreEqual) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (!b(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return c(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
