package kl;

import fl.t0;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f9269b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f9270c = 's';

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f9271d = 'm';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f9272e = 'h';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char f9273f = 'd';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char f9274g = 'M';

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f9275h = 'Y';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f9276i = 'z';

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f9277j = '*';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f9278a;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public f(@l String str) {
        l0.p(str, "pattern");
        this.f9278a = str;
        if (str.length() <= 0) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.");
        }
    }

    public final void a(e eVar, char c10, String str) {
        if (c10 == 's') {
            eVar.f9263a = Integer.valueOf(Integer.parseInt(str));
            return;
        }
        if (c10 == 'm') {
            eVar.f9264b = Integer.valueOf(Integer.parseInt(str));
            return;
        }
        if (c10 == 'h') {
            eVar.f9265c = Integer.valueOf(Integer.parseInt(str));
            return;
        }
        if (c10 == 'd') {
            eVar.f9266d = Integer.valueOf(Integer.parseInt(str));
            return;
        }
        if (c10 == 'M') {
            eVar.k(h.Companion.b(str));
            return;
        }
        if (c10 == 'Y') {
            eVar.f9268f = Integer.valueOf(Integer.parseInt(str));
            return;
        }
        if (c10 == 'z') {
            if (!l0.g(str, "GMT")) {
                throw new IllegalStateException("Check failed.");
            }
        } else {
            if (c10 == '*') {
                return;
            }
            int i10 = 0;
            while (i10 < str.length()) {
                char cCharAt = str.charAt(i10);
                i10++;
                if (cCharAt != c10) {
                    throw new IllegalStateException("Check failed.");
                }
            }
        }
    }

    @l
    public final d b(@l String str) {
        l0.p(str, "dateString");
        e eVar = new e();
        char cCharAt = this.f9278a.charAt(0);
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i11 < this.f9278a.length()) {
            try {
                if (this.f9278a.charAt(i11) == cCharAt) {
                    i11++;
                } else {
                    int i13 = (i12 + i11) - i10;
                    String strSubstring = str.substring(i12, i13);
                    l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    a(eVar, cCharAt, strSubstring);
                    try {
                        cCharAt = this.f9278a.charAt(i11);
                        i10 = i11;
                        i11++;
                        i12 = i13;
                    } catch (Throwable unused) {
                        i12 = i13;
                        throw new g(str, i12, this.f9278a);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (i12 < str.length()) {
            String strSubstring2 = str.substring(i12);
            l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            a(eVar, cCharAt, strSubstring2);
        }
        return eVar.a();
    }
}
