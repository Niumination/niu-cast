package zf;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.bb;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import m3.c6;
import m3.e6;
import m3.i6;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final r0 f11508k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n0 f11512d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f11514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f0 f11515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s0 f11516j;

    static {
        Intrinsics.checkNotNullParameter(new q(), "<this>");
        Intrinsics.checkNotNullParameter("http://localhost", "urlString");
        Intrinsics.checkNotNullParameter("http://localhost", "urlString");
        f11508k = m0.b(new j0(), "http://localhost").b();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00ef  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    public j0() throws CharacterCodingException {
        int i8;
        List pathSegments = CollectionsKt.emptyList();
        d0.f11496b.getClass();
        m parameters = m.f11519c;
        Intrinsics.checkNotNullParameter("", "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter("", "fragment");
        this.f11509a = "";
        final boolean z2 = false;
        this.f11510b = false;
        this.f11511c = 0;
        this.f11512d = null;
        this.e = null;
        this.f = null;
        Set set = d.f11492a;
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter("", "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "newEncoder(...)");
        int length = "".length();
        Intrinsics.checkNotNullParameter(charsetEncoderNewEncoder, "<this>");
        Intrinsics.checkNotNullParameter("", "input");
        wi.a aVar = new wi.a();
        bb.b(charsetEncoderNewEncoder, aVar, "", 0, length);
        d.f(aVar, new Function1() { // from class: zf.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Byte b9 = (Byte) obj;
                byte bByteValue = b9.byteValue();
                StringBuilder sb3 = sb2;
                if (bByteValue == 32) {
                    if (z2) {
                        sb3.append('+');
                    } else {
                        sb3.append("%20");
                    }
                } else if (d.f11492a.contains(b9) || (!z2 && d.f11494c.contains(b9))) {
                    sb3.append((char) bByteValue);
                } else {
                    sb3.append(d.g(bByteValue));
                }
                return Unit.INSTANCE;
            }
        });
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.f11513g = string;
        List<??> list = pathSegments;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
        for (?? input : list) {
            Intrinsics.checkNotNullParameter(input, "<this>");
            Intrinsics.checkNotNullParameter(input, "<this>");
            StringBuilder sb3 = new StringBuilder();
            Charset charset2 = Charsets.UTF_8;
            ?? r14 = z2;
            while (r14 < input.length()) {
                char cCharAt = input.charAt(r14);
                if (d.f11493b.contains(Character.valueOf(cCharAt))) {
                    sb3.append(cCharAt);
                    i8 = r14 + 1;
                } else if (d.f11495d.contains(Character.valueOf(cCharAt))) {
                    sb3.append(cCharAt);
                    i8 = r14 + 1;
                } else {
                    int i9 = CharsKt.isSurrogate(cCharAt) ? 2 : 1;
                    CharsetEncoder charsetEncoderNewEncoder2 = charset2.newEncoder();
                    Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder2, "newEncoder(...)");
                    int i10 = i9 + r14;
                    Intrinsics.checkNotNullParameter(charsetEncoderNewEncoder2, "<this>");
                    Intrinsics.checkNotNullParameter(input, "input");
                    wi.a aVar2 = new wi.a();
                    bb.b(charsetEncoderNewEncoder2, aVar2, input, r14, i10);
                    d.f(aVar2, new sb.a(sb3, 11));
                    i8 = i10;
                }
                r14 = i8;
            }
            String string2 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            arrayList.add(string2);
            z2 = false;
        }
        this.f11514h = arrayList;
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        f0 f0VarA = c6.a();
        for (String str : parameters.names()) {
            List listB = parameters.b(str);
            listB = listB == null ? CollectionsKt.emptyList() : listB;
            String strE = d.e(str, false);
            List<String> list2 = listB;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.i(list2));
            for (String str2 : list2) {
                Intrinsics.checkNotNullParameter(str2, "<this>");
                arrayList2.add(d.e(str2, true));
            }
            f0VarA.c(strE, arrayList2);
        }
        this.f11515i = f0VarA;
        this.f11516j = new s0(f0VarA);
    }

    public final void a() {
        if (this.f11509a.length() <= 0 && !Intrinsics.areEqual(c().f11526a, "file")) {
            r0 r0Var = f11508k;
            this.f11509a = r0Var.f11537a;
            if (this.f11512d == null) {
                this.f11512d = r0Var.f11543i;
            }
            if (this.f11511c == 0) {
                f(r0Var.f11538b);
            }
        }
    }

    public final r0 b() {
        a();
        n0 n0Var = this.f11512d;
        String str = this.f11509a;
        int i8 = this.f11511c;
        List list = this.f11514h;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d.c((String) it.next(), 0, 0, 7));
        }
        d0 d0VarA = i6.a(this.f11516j.f11550a);
        String strD = d.d(this.f11513g, 0, 0, false, 15);
        String str2 = this.e;
        String strC = str2 != null ? d.c(str2, 0, 0, 7) : null;
        String str3 = this.f;
        String strC2 = str3 != null ? d.c(str3, 0, 0, 7) : null;
        boolean z2 = this.f11510b;
        a();
        StringBuilder sb2 = new StringBuilder(256);
        e6.a(this, sb2);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new r0(n0Var, str, i8, arrayList, d0VarA, strD, strC, strC2, z2, string);
    }

    public final n0 c() {
        n0 n0Var = this.f11512d;
        if (n0Var != null) {
            return n0Var;
        }
        n0 n0Var2 = n0.f11524c;
        return n0.f11524c;
    }

    public final void d(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f11514h = list;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11509a = str;
    }

    public final void f(int i8) {
        if (i8 < 0 || i8 >= 65536) {
            throw new IllegalArgumentException(a1.a.o(i8, "Port must be between 0 and 65535, or 0 if not set. Provided: ").toString());
        }
        this.f11511c = i8;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(256);
        e6.a(this, sb2);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
