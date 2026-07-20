package uk;

import ik.y0;
import kn.l0;
import kn.w;
import lm.a1;
import lm.k;
import os.l;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final s f16294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final Object f16295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16296c;

    public c(@l s sVar, @l Object obj, boolean z10) {
        l0.p(sVar, "typeInfo");
        l0.p(obj, "value");
        this.f16294a = sVar;
        this.f16295b = obj;
        this.f16296c = z10;
    }

    @k(message = "Use typeInfo instead as it provides type parameter information", replaceWith = @a1(expression = "typeInfo.jvmErasure", imports = {"kotlin.reflect.jvm.jvmErasure"}))
    public static /* synthetic */ void c() {
    }

    public final boolean a() {
        return this.f16296c;
    }

    @l
    public final un.d<?> b() {
        return wn.d.b(this.f16294a);
    }

    @l
    public final s d() {
        return this.f16294a;
    }

    @l
    public final Object e() {
        return this.f16295b;
    }

    public /* synthetic */ c(s sVar, Object obj, boolean z10, int i10, w wVar) {
        this(sVar, obj, (i10 & 4) != 0 ? false : z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @k(message = "Use typeOf to pass KType instead")
    public c(@l un.d<?> dVar, @l Object obj) {
        this(vn.g.d(dVar), obj, false);
        l0.p(dVar, y0.a.f8215h);
        l0.p(obj, "value");
    }
}
