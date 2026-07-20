package ug;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import zf.i0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10440a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(d.class);
        try {
            kTypeTypeOf = Reflection.typeOf(d.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10440a = new zg.a("MutableOriginConnectionPointKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final i0 a(vg.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.c().i().d(f10440a) == null) {
            return cVar.g();
        }
        throw new ClassCastException();
    }
}
