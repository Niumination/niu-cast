package ij;

import dj.j0;
import dj.k;
import dj.l;
import dj.s;
import dj.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import k3.b2;
import k3.t1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import qj.i;
import qj.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    static {
        j.Companion.getClass();
        i.b("\"\\");
        i.b("\t ,=");
    }

    public static final boolean a(j0 promisesBody) {
        Intrinsics.checkNotNullParameter(promisesBody, "$this$promisesBody");
        if (Intrinsics.areEqual(promisesBody.f4576a.f4529c, "HEAD")) {
            return false;
        }
        int i8 = promisesBody.f4579d;
        return (((i8 >= 100 && i8 < 200) || i8 == 204 || i8 == 304) && ej.b.k(promisesBody) == -1 && !StringsKt__StringsJVMKt.equals("chunked", j0.a(promisesBody, "Transfer-Encoding"), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0266 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x0268  */
    /* JADX WARN: Code duplicated, block: B:162:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v2 */
    public static final void b(l receiveHeaders, u url, s headers) {
        List listEmptyList;
        List cookies;
        List list;
        k kVar;
        long j8;
        String str;
        List list2;
        boolean z2;
        int i8 = 1;
        Intrinsics.checkNotNullParameter(receiveHeaders, "$this$receiveHeaders");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (receiveHeaders == l.f4603b) {
            return;
        }
        Pattern pattern = k.f4588j;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        headers.getClass();
        Intrinsics.checkNotNullParameter("Set-Cookie", "name");
        int size = headers.size();
        int i9 = 0;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (StringsKt__StringsJVMKt.equals("Set-Cookie", headers.f(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.h(i10));
            }
        }
        if (arrayList != null) {
            listEmptyList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listEmptyList, "Collections.unmodifiableList(result)");
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list3 = listEmptyList;
        int size2 = list3.size();
        int i11 = 0;
        ArrayList arrayList2 = null;
        while (i11 < size2) {
            String setCookie = (String) list3.get(i11);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            byte[] bArr = ej.b.f4964a;
            char c9 = ';';
            int iG = ej.b.g(setCookie, ';', i9, setCookie.length());
            int iG2 = ej.b.g(setCookie, '=', i9, iG);
            if (iG2 == iG) {
                list = list3;
            } else {
                String strY = ej.b.y(i9, iG2, setCookie);
                if (strY.length() == 0 || ej.b.m(strY) != -1) {
                    list = list3;
                    kVar = null;
                    i9 = 0;
                    break;
                }
                String strY2 = ej.b.y(iG2 + i8, iG, setCookie);
                if (ej.b.m(strY2) == -1) {
                    int i12 = iG + i8;
                    int length = setCookie.length();
                    boolean z3 = i8;
                    long j10 = -1;
                    long jB = 253402300799999L;
                    String str2 = null;
                    String str3 = null;
                    boolean z5 = false;
                    boolean z10 = false;
                    boolean z11 = false;
                    while (true) {
                        if (i12 >= length) {
                            list = list3;
                            if (j10 == Long.MIN_VALUE) {
                                j8 = Long.MIN_VALUE;
                            } else if (j10 != -1) {
                                long j11 = jCurrentTimeMillis + (j10 <= 9223372036854775L ? j10 * ((long) 1000) : Long.MAX_VALUE);
                                j8 = (j11 < jCurrentTimeMillis || j11 > 253402300799999L) ? 253402300799999L : j11;
                            } else {
                                j8 = jB;
                            }
                            String canParseAsIpAddress = url.e;
                            if (str2 == null) {
                                str2 = canParseAsIpAddress;
                            } else if (!Intrinsics.areEqual(canParseAsIpAddress, str2)) {
                                if (StringsKt__StringsJVMKt.endsWith$default(canParseAsIpAddress, str2, false, 2, null) && canParseAsIpAddress.charAt((canParseAsIpAddress.length() - str2.length()) - 1) == '.') {
                                    Intrinsics.checkNotNullParameter(canParseAsIpAddress, "$this$canParseAsIpAddress");
                                    if (!ej.b.f.matches(canParseAsIpAddress)) {
                                    }
                                }
                                i9 = 0;
                            }
                            if (canParseAsIpAddress.length() == str2.length() || PublicSuffixDatabase.f8569g.a(str2) != null) {
                                String strSubstring = "/";
                                if (str3 == null || !StringsKt__StringsJVMKt.startsWith$default(str3, "/", false, 2, null)) {
                                    String strB = url.b();
                                    i9 = 0;
                                    int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strB, '/', 0, false, 6, (Object) null);
                                    if (iLastIndexOf$default != 0) {
                                        if (strB == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        strSubstring = strB.substring(0, iLastIndexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    str = strSubstring;
                                } else {
                                    str = str3;
                                    i9 = 0;
                                }
                                kVar = new k(strY, strY2, j8, str2, str, z5, z10, z11, z3);
                                break;
                            }
                        } else {
                            int iG3 = ej.b.g(setCookie, c9, i12, length);
                            int iG4 = ej.b.g(setCookie, '=', i12, iG3);
                            String strY3 = ej.b.y(i12, iG4, setCookie);
                            String strY4 = iG4 < iG3 ? ej.b.y(iG4 + 1, iG3, setCookie) : "";
                            if (StringsKt__StringsJVMKt.equals(strY3, "expires", true)) {
                                try {
                                    jB = t1.b(strY4.length(), strY4);
                                    list2 = list3;
                                    z2 = true;
                                    z11 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                    list2 = list3;
                                    z2 = true;
                                }
                            } else {
                                if (StringsKt__StringsJVMKt.equals(strY3, "max-age", true)) {
                                    try {
                                        long j12 = Long.parseLong(strY4);
                                        list2 = list3;
                                        j10 = j12 > 0 ? j12 : Long.MIN_VALUE;
                                    } catch (NumberFormatException e) {
                                        list2 = list3;
                                        try {
                                            if (!new Regex("-?\\d+").matches(strY4)) {
                                                throw e;
                                            }
                                            j10 = StringsKt__StringsJVMKt.startsWith$default(strY4, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                        } catch (NumberFormatException | IllegalArgumentException unused2) {
                                            z2 = true;
                                        }
                                    }
                                    z2 = true;
                                    z11 = true;
                                } else {
                                    list2 = list3;
                                    if (StringsKt__StringsJVMKt.equals(strY3, "domain", true)) {
                                        if (StringsKt__StringsJVMKt.endsWith$default(strY4, ".", false, 2, null)) {
                                            throw new IllegalArgumentException("Failed requirement.");
                                        }
                                        String strB2 = b2.b(StringsKt__StringsKt.removePrefix(strY4, (CharSequence) "."));
                                        if (strB2 == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        str2 = strB2;
                                        z2 = true;
                                        z3 = 0;
                                    } else if (StringsKt__StringsJVMKt.equals(strY3, "path", true)) {
                                        str3 = strY4;
                                    } else if (StringsKt__StringsJVMKt.equals(strY3, "secure", true)) {
                                        z2 = true;
                                        z5 = true;
                                    } else if (StringsKt__StringsJVMKt.equals(strY3, "httponly", true)) {
                                        z2 = true;
                                        z10 = true;
                                    }
                                }
                                z2 = true;
                            }
                            i12 = iG3 + 1;
                            list3 = list2;
                            c9 = ';';
                            z3 = z3;
                        }
                    }
                } else {
                    list = list3;
                }
                kVar = null;
                i9 = 0;
                break;
                if (kVar == null) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(kVar);
                }
                i11++;
                i8 = 1;
                list3 = list;
            }
            kVar = null;
            if (kVar == null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(kVar);
            }
            i11++;
            i8 = 1;
            list3 = list;
        }
        if (arrayList2 != null) {
            cookies = Collections.unmodifiableList(arrayList2);
            Intrinsics.checkNotNullExpressionValue(cookies, "Collections.unmodifiableList(cookies)");
        } else {
            cookies = CollectionsKt.emptyList();
        }
        if (cookies.isEmpty()) {
            return;
        }
        receiveHeaders.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
    }
}
