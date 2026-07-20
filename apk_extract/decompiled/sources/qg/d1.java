package qg;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements mg.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f9069a = new d1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zg.a f9070b;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(g1.class);
        try {
            kTypeTypeOf = Reflection.typeOf(g1.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f9070b = new zg.a("shutdown.url", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    @Override // mg.f
    public final zg.a getKey() {
        return f9070b;
    }

    @Override // mg.f
    public final Object m(hh.e eVar, Function1 configure) throws hh.c {
        t0 pipeline = (t0) eVar;
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(configure, "configure");
        b1 b1Var = new b1();
        configure.invoke(b1Var);
        g1 g1Var = new g1(b1Var.f9067a, b1Var.f9068b);
        pipeline.p(t0.f9114k, new c1(g1Var, null));
        return g1Var;
    }
}
