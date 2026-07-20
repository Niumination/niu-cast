package ko;

import ik.y0;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends p implements uo.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final z f9404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Annotation[] f9405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final String f9406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9407d;

    public b0(@os.l z zVar, @os.l Annotation[] annotationArr, @os.m String str, boolean z10) {
        l0.p(zVar, y0.a.f8215h);
        l0.p(annotationArr, "reflectAnnotations");
        this.f9404a = zVar;
        this.f9405b = annotationArr;
        this.f9406c = str;
        this.f9407d = z10;
    }

    @Override // uo.d
    public boolean C() {
        return false;
    }

    @Override // uo.d
    @os.m
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public e d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return i.a(this.f9405b, cVar);
    }

    @os.l
    public List<e> O() {
        return i.b(this.f9405b);
    }

    @os.l
    public z P() {
        return this.f9404a;
    }

    @Override // uo.b0
    public boolean b() {
        return this.f9407d;
    }

    @Override // uo.d
    public Collection getAnnotations() {
        return i.b(this.f9405b);
    }

    @Override // uo.b0
    @os.m
    public dp.f getName() {
        String str = this.f9406c;
        if (str == null) {
            return null;
        }
        return dp.f.h(str);
    }

    @Override // uo.b0
    public uo.x getType() {
        return this.f9404a;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b0.class.getName());
        sb2.append(": ");
        sb2.append(this.f9407d ? "vararg " : "");
        sb2.append(getName());
        sb2.append(": ");
        sb2.append(this.f9404a);
        return sb2.toString();
    }
}
