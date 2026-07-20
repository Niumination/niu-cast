package df;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4443a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f4444b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static List a(X509Certificate x509Certificate, int i8) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i8 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public static boolean b(String str, X509Certificate x509Certificate) {
        String str2;
        String str3;
        char[] cArr;
        char c9;
        int i8;
        char c10;
        if (f4444b.matcher(str).matches()) {
            List listA = a(x509Certificate, 7);
            int size = listA.size();
            for (int i9 = 0; i9 < size; i9++) {
                if (str.equalsIgnoreCase((String) listA.get(i9))) {
                    return true;
                }
            }
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int i10 = 2;
        List listA2 = a(x509Certificate, 2);
        int size2 = listA2.size();
        int i11 = 0;
        boolean z2 = false;
        while (i11 < size2) {
            if (c(lowerCase, (String) listA2.get(i11))) {
                return true;
            }
            i11++;
            z2 = true;
        }
        if (!z2) {
            d dVar = new d(x509Certificate.getSubjectX500Principal());
            dVar.f4440c = 0;
            dVar.f4441d = 0;
            dVar.e = 0;
            dVar.f = 0;
            String str4 = dVar.f4438a;
            dVar.f4442g = str4.toCharArray();
            String strC = dVar.c();
            if (strC == null) {
                str3 = null;
            } else {
                while (true) {
                    int i12 = dVar.f4440c;
                    int i13 = dVar.f4439b;
                    if (i12 == i13) {
                        break;
                    }
                    char c11 = dVar.f4442g[i12];
                    char c12 = '\\';
                    if (c11 == '\"') {
                        int i14 = i12 + 1;
                        dVar.f4440c = i14;
                        dVar.f4441d = i14;
                        dVar.e = i14;
                        while (true) {
                            int i15 = dVar.f4440c;
                            if (i15 == i13) {
                                throw new IllegalStateException("Unexpected end of DN: ".concat(str4));
                            }
                            char[] cArr2 = dVar.f4442g;
                            char c13 = cArr2[i15];
                            if (c13 == '\"') {
                                dVar.f4440c = i15 + 1;
                                while (true) {
                                    int i16 = dVar.f4440c;
                                    if (i16 >= i13 || dVar.f4442g[i16] != ' ') {
                                        break;
                                    }
                                    dVar.f4440c = i16 + 1;
                                }
                                char[] cArr3 = dVar.f4442g;
                                int i17 = dVar.f4441d;
                                str2 = new String(cArr3, i17, dVar.e - i17);
                                break;
                            }
                            if (c13 == '\\') {
                                cArr2[dVar.e] = dVar.b();
                            } else {
                                cArr2[dVar.e] = c13;
                            }
                            dVar.f4440c++;
                            dVar.e++;
                            i10 = 2;
                        }
                    } else if (c11 == '#') {
                        if (i12 + 4 >= i13) {
                            throw new IllegalStateException("Unexpected end of DN: ".concat(str4));
                        }
                        dVar.f4441d = i12;
                        dVar.f4440c = i12 + 1;
                        while (true) {
                            int i18 = dVar.f4440c;
                            if (i18 == i13 || (c9 = (cArr = dVar.f4442g)[i18]) == '+' || c9 == ',' || c9 == ';') {
                                dVar.e = i18;
                                break;
                            }
                            if (c9 == ' ') {
                                dVar.e = i18;
                                dVar.f4440c = i18 + 1;
                                while (true) {
                                    int i19 = dVar.f4440c;
                                    if (i19 >= i13 || dVar.f4442g[i19] != ' ') {
                                        break;
                                    }
                                    dVar.f4440c = i19 + 1;
                                }
                            } else {
                                if (c9 >= 'A' && c9 <= 'F') {
                                    cArr[i18] = (char) (c9 + ' ');
                                }
                                dVar.f4440c = i18 + 1;
                            }
                        }
                        int i20 = dVar.e;
                        int i21 = dVar.f4441d;
                        int i22 = i20 - i21;
                        if (i22 < 5 || (i22 & 1) == 0) {
                            throw new IllegalStateException("Unexpected end of DN: ".concat(str4));
                        }
                        int i23 = i22 / 2;
                        byte[] bArr = new byte[i23];
                        int i24 = i21 + 1;
                        for (int i25 = 0; i25 < i23; i25++) {
                            bArr[i25] = (byte) dVar.a(i24);
                            i24 += i10;
                        }
                        str2 = new String(dVar.f4442g, dVar.f4441d, i22);
                    } else if (c11 == '+' || c11 == ',' || c11 == ';') {
                        str2 = "";
                    } else {
                        dVar.f4441d = i12;
                        dVar.e = i12;
                        while (true) {
                            int i26 = dVar.f4440c;
                            if (i26 >= i13) {
                                char[] cArr4 = dVar.f4442g;
                                int i27 = dVar.f4441d;
                                str2 = new String(cArr4, i27, dVar.e - i27);
                                break;
                            }
                            char[] cArr5 = dVar.f4442g;
                            char c14 = cArr5[i26];
                            if (c14 != ' ') {
                                if (c14 != ';') {
                                    if (c14 == c12) {
                                        int i28 = dVar.e;
                                        dVar.e = i28 + 1;
                                        cArr5[i28] = dVar.b();
                                        dVar.f4440c++;
                                    } else if (c14 != '+' && c14 != ',') {
                                        int i29 = dVar.e;
                                        dVar.e = i29 + 1;
                                        cArr5[i29] = c14;
                                        dVar.f4440c = i26 + 1;
                                    }
                                    c12 = '\\';
                                }
                                int i30 = dVar.f4441d;
                                str2 = new String(cArr5, i30, dVar.e - i30);
                                break;
                            }
                            int i31 = dVar.e;
                            dVar.f = i31;
                            dVar.f4440c = i26 + 1;
                            dVar.e = i31 + 1;
                            cArr5[i31] = ' ';
                            while (true) {
                                i8 = dVar.f4440c;
                                if (i8 >= i13) {
                                    break;
                                }
                                char[] cArr6 = dVar.f4442g;
                                if (cArr6[i8] != ' ') {
                                    break;
                                }
                                int i32 = dVar.e;
                                dVar.e = i32 + 1;
                                cArr6[i32] = ' ';
                                dVar.f4440c = i8 + 1;
                            }
                            if (i8 == i13 || (c10 = dVar.f4442g[i8]) == ',' || c10 == '+' || c10 == ';') {
                                char[] cArr7 = dVar.f4442g;
                                int i33 = dVar.f4441d;
                                str2 = new String(cArr7, i33, dVar.f - i33);
                                break;
                            }
                            c12 = '\\';
                        }
                    }
                    if ("cn".equalsIgnoreCase(strC)) {
                        str3 = str2;
                    } else {
                        int i34 = dVar.f4440c;
                        if (i34 >= i13) {
                            break;
                        }
                        char c15 = dVar.f4442g[i34];
                        if (c15 != ',' && c15 != ';' && c15 != '+') {
                            throw new IllegalStateException("Malformed DN: ".concat(str4));
                        }
                        dVar.f4440c = i34 + 1;
                        strC = dVar.c();
                        if (strC == null) {
                            throw new IllegalStateException("Malformed DN: ".concat(str4));
                        }
                    }
                }
                str3 = null;
            }
            if (str3 != null) {
                return c(lowerCase, str3);
            }
        }
        return false;
    }

    public static boolean c(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str.concat(".");
            }
            if (!str2.endsWith(".")) {
                str2 = str2.concat(".");
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains(vj.e.ANY_MARKER)) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return b(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
