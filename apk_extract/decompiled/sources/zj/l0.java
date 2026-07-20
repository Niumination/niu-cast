package zj;

import af.r5;
import java.util.ArrayList;
import java.util.regex.Pattern;
import k3.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f11644l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f11645m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.u f11647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dj.t f11649d;
    public final r5 e = new r5(1);
    public final dj.r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dj.x f11650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u6.a f11652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final tc.d f11653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public dj.h0 f11654k;

    public l0(String str, dj.u uVar, String str2, dj.s sVar, dj.x xVar, boolean z2, boolean z3, boolean z5) {
        this.f11646a = str;
        this.f11647b = uVar;
        this.f11648c = str2;
        this.f11650g = xVar;
        this.f11651h = z2;
        if (sVar != null) {
            this.f = sVar.g();
        } else {
            this.f = new dj.r(0);
        }
        if (z3) {
            this.f11653j = new tc.d(1);
            return;
        }
        if (z5) {
            u6.a aVar = new u6.a(5);
            this.f11652i = aVar;
            dj.x type = dj.z.f;
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.areEqual(type.f4643b, "multipart")) {
                aVar.f10379c = type;
            } else {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
        }
    }

    public final void a(String name, String value, boolean z2) {
        tc.d dVar = this.f11653j;
        if (z2) {
            dVar.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ((ArrayList) dVar.f10209a).add(dj.l.b(name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
            ((ArrayList) dVar.f10210b).add(dj.l.b(value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
            return;
        }
        dVar.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ((ArrayList) dVar.f10209a).add(dj.l.b(name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
        ((ArrayList) dVar.f10210b).add(dj.l.b(value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
    }

    public final void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f.a(str, str2);
            return;
        }
        try {
            Pattern pattern = dj.x.f4641d;
            this.f11650g = w1.a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(h0.a.i("Malformed content type: ", str2), e);
        }
    }

    public final void c(dj.s sVar, dj.h0 body) {
        u6.a aVar = this.f11652i;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(body, "body");
        if (sVar.e("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (sVar.e("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        dj.y part = new dj.y(sVar, body);
        Intrinsics.checkNotNullParameter(part, "part");
        ((ArrayList) aVar.f10380d).add(part);
    }

    public final void d(String name, String str, boolean z2) {
        String str2 = this.f11648c;
        if (str2 != null) {
            dj.u uVar = this.f11647b;
            dj.t tVarF = uVar.f(str2);
            this.f11649d = tVarF;
            if (tVarF == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + uVar + ", Relative: " + this.f11648c);
            }
            this.f11648c = null;
        }
        if (z2) {
            dj.t tVar = this.f11649d;
            tVar.getClass();
            Intrinsics.checkNotNullParameter(name, "encodedName");
            if (tVar.f4630g == null) {
                tVar.f4630g = new ArrayList();
            }
            ArrayList arrayList = tVar.f4630g;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(dj.l.b(name, 0, 0, " \"'<>#&=", true, false, true, false, 211));
            ArrayList arrayList2 = tVar.f4630g;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.add(str != null ? dj.l.b(str, 0, 0, " \"'<>#&=", true, false, true, false, 211) : null);
            return;
        }
        dj.t tVar2 = this.f11649d;
        tVar2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        if (tVar2.f4630g == null) {
            tVar2.f4630g = new ArrayList();
        }
        ArrayList arrayList3 = tVar2.f4630g;
        Intrinsics.checkNotNull(arrayList3);
        arrayList3.add(dj.l.b(name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219));
        ArrayList arrayList4 = tVar2.f4630g;
        Intrinsics.checkNotNull(arrayList4);
        arrayList4.add(str != null ? dj.l.b(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219) : null);
    }
}
