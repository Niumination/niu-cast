package zj;

import java.io.EOFException;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f11631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11633d;
    public final a e;
    public final boolean f;

    public f0(Method method, int i8, String str, boolean z2) {
        a aVar = a.f11610b;
        this.f11631b = method;
        this.f11632c = i8;
        Objects.requireNonNull(str, "name == null");
        this.f11633d = str;
        this.e = aVar;
        this.f = z2;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) throws EOFException {
        String strW;
        String str = this.f11633d;
        if (obj == null) {
            throw s.l(this.f11631b, this.f11632c, h0.a.j("Path parameter \"", str, "\" value must not be null."), new Object[0]);
        }
        this.e.getClass();
        String string = obj.toString();
        if (l0Var.f11648c == null) {
            throw new AssertionError();
        }
        int length = string.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                strW = string;
                break;
            }
            int iCodePointAt = string.codePointAt(iCharCount);
            boolean z2 = this.f;
            int i8 = 47;
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                qj.f fVar = new qj.f();
                fVar.l0(0, iCharCount, string);
                qj.f fVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = string.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != -1 || (!z2 && (iCodePointAt2 == i8 || iCodePointAt2 == 37))) {
                            if (fVar2 == null) {
                                fVar2 = new qj.f();
                            }
                            fVar2.n0(iCodePointAt2);
                            while (!fVar2.T()) {
                                byte b9 = fVar2.readByte();
                                int i9 = b9 & UByte.MAX_VALUE;
                                fVar.S(37);
                                char[] cArr = l0.f11644l;
                                fVar.S(cArr[(i9 >> 4) & 15]);
                                fVar.S(cArr[b9 & 15]);
                            }
                        } else {
                            fVar.n0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i8 = 47;
                }
                strW = fVar.w();
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strReplace = l0Var.f11648c.replace("{" + str + "}", strW);
        if (l0.f11645m.matcher(strReplace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): ".concat(string));
        }
        l0Var.f11648c = strReplace;
    }
}
