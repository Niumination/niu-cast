package dj;

import af.r5;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f4527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f4528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f4530d;
    public final h0 e;
    public final Map f;

    public e0(u url, String method, s headers, h0 h0Var, Map tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f4528b = url;
        this.f4529c = method;
        this.f4530d = headers;
        this.e = h0Var;
        this.f = tags;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f4530d.e(name);
    }

    public final r5 b() {
        Intrinsics.checkNotNullParameter(this, "request");
        r5 r5Var = new r5(false);
        r5Var.f560h = new LinkedHashMap();
        r5Var.f557b = this.f4528b;
        r5Var.f558c = this.f4529c;
        r5Var.e = this.e;
        Map map = this.f;
        r5Var.f560h = map.isEmpty() ? new LinkedHashMap() : MapsKt.toMutableMap(map);
        r5Var.f559d = this.f4530d.g();
        return r5Var;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Request{method=");
        sb2.append(this.f4529c);
        sb2.append(", url=");
        sb2.append(this.f4528b);
        s sVar = this.f4530d;
        if (sVar.size() != 0) {
            sb2.append(", headers=[");
            int i8 = 0;
            for (Object obj : sVar) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i8 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                sb2.append(str2);
                i8 = i9;
            }
            sb2.append(']');
        }
        Map map = this.f;
        if (!map.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(map);
        }
        return a1.a.q(sb2, '}', "StringBuilder().apply(builderAction).toString()");
    }
}
