package zj;

import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f11626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11627d;

    public /* synthetic */ d0(Method method, int i8, int i9) {
        this.f11625b = i9;
        this.f11626c = method;
        this.f11627d = i8;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        switch (this.f11625b) {
            case 0:
                Map map = (Map) obj;
                int i8 = this.f11627d;
                Method method = this.f11626c;
                if (map == null) {
                    throw s.l(method, i8, "Header map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw s.l(method, i8, "Header map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw s.l(method, i8, h0.a.j("Header map contained null value for key '", str, "'."), new Object[0]);
                    }
                    l0Var.b(str, value.toString());
                }
                return;
            case 1:
                dj.s headers = (dj.s) obj;
                if (headers == null) {
                    int i9 = this.f11627d;
                    throw s.l(this.f11626c, i9, "Headers parameter must not be null.", new Object[0]);
                }
                dj.r rVar = l0Var.f;
                rVar.getClass();
                Intrinsics.checkNotNullParameter(headers, "headers");
                int size = headers.size();
                for (int i10 = 0; i10 < size; i10++) {
                    rVar.b(headers.f(i10), headers.h(i10));
                }
                return;
            default:
                if (obj != null) {
                    l0Var.f11648c = obj.toString();
                    return;
                } else {
                    int i11 = this.f11627d;
                    throw s.l(this.f11626c, i11, "@Url parameter is null.", new Object[0]);
                }
        }
    }
}
