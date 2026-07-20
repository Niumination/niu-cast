package pf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8843a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zg.h.class);
        try {
            kTypeTypeOf = Reflection.typeOf(zg.h.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8843a = new zg.a("ApplicationPluginRegistry", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final Object a(jf.d dVar, e0 plugin) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        zg.h hVar = (zg.h) dVar.f6262k.d(f8843a);
        Object objD = hVar != null ? hVar.d(plugin.getKey()) : null;
        if (objD != null) {
            return objD;
        }
        throw new IllegalStateException("Plugin " + plugin + " is not installed. Consider using `install(" + plugin.getKey() + ")` in client config first.");
    }
}
