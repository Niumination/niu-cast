package mg;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import xg.n0;
import xg.o0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8062a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zg.h.class);
        try {
            kTypeTypeOf = Reflection.typeOf(zg.h.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8062a = new zg.a("ApplicationPluginRegistry", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final zg.h a(hh.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return (zg.h) eVar.f5397a.a(f8062a, new bb.s(22));
    }

    public static final Object b(hh.e eVar, f plugin, Function1 configure) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(configure, "configure");
        boolean z2 = eVar instanceof xg.u;
        zg.h hVarA = a(eVar);
        Object objD = hVarA.d(plugin.getKey());
        if (objD == null) {
            Object objM = plugin.m(eVar, configure);
            hVarA.e(plugin.getKey(), objM);
            return objM;
        }
        if (Intrinsics.areEqual(objD, plugin)) {
            return objD;
        }
        throw new n(a1.a.s(new StringBuilder("Please make sure that you use unique name for the plugin and don't install it twice. Conflicting application plugin is already installed with the same key as `"), plugin.getKey().f11583a, '`'));
    }

    public static final Object c(c cVar) {
        Object objD;
        bd.b plugin = yg.q.f11216h;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (cVar instanceof xg.u) {
            xg.u uVar = (xg.u) cVar;
            Intrinsics.checkNotNullParameter(uVar, "<this>");
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            xg.u uVar2 = uVar;
            while (true) {
                objD = d(uVar2, plugin);
                if (objD != null) {
                    break;
                }
                xg.u uVar3 = uVar2.q;
                if (uVar3 == null) {
                    if (!(uVar2 instanceof n0)) {
                        objD = null;
                        break;
                    }
                    objD = d(o0.a(uVar), plugin);
                    break;
                }
                Intrinsics.checkNotNull(uVar3);
                uVar2 = uVar3;
            }
        } else {
            objD = d(cVar, plugin);
        }
        if (objD != null) {
            return objD;
        }
        throw new p(yg.q.f11217i);
    }

    public static final Object d(c cVar, f plugin) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return a(cVar).d(plugin.getKey());
    }
}
