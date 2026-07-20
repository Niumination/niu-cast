package m3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class d6 {
    public static final void a(zf.f0 f0Var, String str, int i8, int i9, int i10, boolean z2) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (i9 == -1) {
            int iD = d(i8, i10, str);
            int iC = c(iD, i10, str);
            if (iC > iD) {
                if (z2) {
                    strSubstring3 = zf.d.d(str, iD, iC, false, 12);
                } else {
                    strSubstring3 = str.substring(iD, iC);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                }
                f0Var.c(strSubstring3, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        int iD2 = d(i8, i9, str);
        int iC2 = c(iD2, i9, str);
        if (iC2 > iD2) {
            if (z2) {
                strSubstring = zf.d.d(str, iD2, iC2, false, 12);
            } else {
                strSubstring = str.substring(iD2, iC2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            }
            int iD3 = d(i9 + 1, i10, str);
            int iC3 = c(iD3, i10, str);
            if (z2) {
                strSubstring2 = zf.d.d(str, iD3, iC3, true, 8);
            } else {
                strSubstring2 = str.substring(iD3, iC3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            }
            f0Var.d(strSubstring, strSubstring2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    public static zf.d0 b(int i8, int i9, String query) {
        int i10 = 0;
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        boolean z2 = (i9 & 8) != 0;
        Intrinsics.checkNotNullParameter(query, "query");
        if (i8 > StringsKt.getLastIndex(query)) {
            zf.d0.f11496b.getClass();
            return zf.m.f11519c;
        }
        zf.q qVar = zf.d0.f11496b;
        zf.f0 f0VarA = c6.a();
        int lastIndex = StringsKt.getLastIndex(query);
        int i11 = i8;
        int i12 = -1;
        if (i8 <= lastIndex) {
            while (true) {
                if (i10 != 1000) {
                    char cCharAt = query.charAt(i8);
                    if (cCharAt == '&') {
                        a(f0VarA, query, i11, i12, i8, z2);
                        i10++;
                        i11 = i8 + 1;
                        i12 = -1;
                    } else if (cCharAt == '=' && i12 == -1) {
                        i12 = i8;
                    }
                    if (i8 == lastIndex) {
                        break;
                    }
                    i8++;
                }
            }
            if (i10 != 1000) {
                a(f0VarA, query, i11, i12, query.length(), z2);
            }
        } else if (i10 != 1000) {
            a(f0VarA, query, i11, i12, query.length(), z2);
        }
        return f0VarA.build();
    }

    public static final int c(int i8, int i9, String str) {
        while (i9 > i8 && CharsKt.isWhitespace(str.charAt(i9 - 1))) {
            i9--;
        }
        return i9;
    }

    public static final int d(int i8, int i9, String str) {
        while (i8 < i9 && CharsKt.isWhitespace(str.charAt(i8))) {
            i8++;
        }
        return i8;
    }
}
