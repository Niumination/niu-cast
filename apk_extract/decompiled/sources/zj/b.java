package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11619a;

    @Override // zj.i
    public final j a(Type type) {
        if (dj.h0.class.isAssignableFrom(s.g(type))) {
            return a.f11612d;
        }
        return null;
    }

    @Override // zj.i
    public final j b(Type type, Annotation[] annotationArr, q0 q0Var) {
        if (type == dj.m0.class) {
            return s.j(annotationArr, bk.w.class) ? a.e : a.f11611c;
        }
        if (type == Void.class) {
            return a.f11614i;
        }
        if (!this.f11619a || type != Unit.class) {
            return null;
        }
        try {
            return a.f11613h;
        } catch (NoClassDefFoundError unused) {
            this.f11619a = false;
            return null;
        }
    }
}
