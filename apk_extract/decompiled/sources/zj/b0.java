package zj;

import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f11621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11622d;
    public final boolean e;

    public /* synthetic */ b0(Method method, int i8, boolean z2, int i9) {
        this.f11620b = i9;
        this.f11621c = method;
        this.f11622d = i8;
        this.e = z2;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        switch (this.f11620b) {
            case 0:
                Map map = (Map) obj;
                int i8 = this.f11622d;
                Method method = this.f11621c;
                if (map == null) {
                    throw s.l(method, i8, "Field map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw s.l(method, i8, "Field map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw s.l(method, i8, h0.a.j("Field map contained null value for key '", str, "'."), new Object[0]);
                    }
                    String string = value.toString();
                    if (string == null) {
                        throw s.l(method, i8, "Field map value '" + value + "' converted to null by " + a.class.getName() + " for key '" + str + "'.", new Object[0]);
                    }
                    l0Var.a(str, string, this.e);
                }
                return;
            default:
                Map map2 = (Map) obj;
                int i9 = this.f11622d;
                Method method2 = this.f11621c;
                if (map2 == null) {
                    throw s.l(method2, i9, "Query map was null", new Object[0]);
                }
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    if (str2 == null) {
                        throw s.l(method2, i9, "Query map contained null key.", new Object[0]);
                    }
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        throw s.l(method2, i9, h0.a.j("Query map contained null value for key '", str2, "'."), new Object[0]);
                    }
                    String string2 = value2.toString();
                    if (string2 == null) {
                        throw s.l(method2, i9, "Query map value '" + value2 + "' converted to null by " + a.class.getName() + " for key '" + str2 + "'.", new Object[0]);
                    }
                    l0Var.d(str2, string2, this.e);
                }
                return;
        }
    }
}
