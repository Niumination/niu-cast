package zj;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import k3.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11628b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f11629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11630d;
    public final j e;
    public final Object f;

    public e0(Method method, int i8, dj.s sVar, j jVar) {
        this.f11629c = method;
        this.f11630d = i8;
        this.f = sVar;
        this.e = jVar;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        switch (this.f11628b) {
            case 0:
                if (obj == null) {
                    return;
                }
                try {
                    l0Var.c((dj.s) this.f, (dj.h0) this.e.convert(obj));
                    return;
                } catch (IOException e) {
                    throw s.l(this.f11629c, this.f11630d, "Unable to convert " + obj + " to RequestBody", e);
                }
            default:
                Map map = (Map) obj;
                int i8 = this.f11630d;
                Method method = this.f11629c;
                if (map == null) {
                    throw s.l(method, i8, "Part map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw s.l(method, i8, "Part map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw s.l(method, i8, h0.a.j("Part map contained null value for key '", str, "'."), new Object[0]);
                    }
                    l0Var.c(v1.c("Content-Disposition", h0.a.j("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", (String) this.f), (dj.h0) this.e.convert(value));
                }
                return;
        }
    }

    public e0(Method method, int i8, j jVar, String str) {
        this.f11629c = method;
        this.f11630d = i8;
        this.e = jVar;
        this.f = str;
    }
}
