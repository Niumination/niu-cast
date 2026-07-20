package fo;

import eo.z0;
import java.util.Map;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f6158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<dp.f, jp.g<?>> f6159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f6160c;

    public d(@os.l f0 f0Var, @os.l Map<dp.f, jp.g<?>> map, @os.l z0 z0Var) {
        if (f0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (z0Var == null) {
            b(2);
        }
        this.f6158a = f0Var;
        this.f6159b = map;
        this.f6160c = z0Var;
    }

    public static /* synthetic */ void b(int i10) {
        String str = (i10 == 3 || i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "valueArguments";
        } else if (i10 == 2) {
            objArr[0] = "source";
        } else if (i10 == 3 || i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i10 == 3) {
            objArr[1] = "getType";
        } else if (i10 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // fo.c
    @os.l
    public Map<dp.f, jp.g<?>> a() {
        Map<dp.f, jp.g<?>> map = this.f6159b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // fo.c
    @os.m
    public dp.c e() {
        return c.a.a(this);
    }

    @Override // fo.c
    @os.l
    public z0 getSource() {
        z0 z0Var = this.f6160c;
        if (z0Var == null) {
            b(5);
        }
        return z0Var;
    }

    @Override // fo.c
    @os.l
    public f0 getType() {
        f0 f0Var = this.f6158a;
        if (f0Var == null) {
            b(3);
        }
        return f0Var;
    }

    public String toString() {
        return gp.c.f6767g.t(this, null);
    }
}
