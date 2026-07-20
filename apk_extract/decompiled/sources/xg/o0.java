package xg;

import k3.g2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vj.b f10980b;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
        try {
            kTypeTypeOf = Reflection.typeOf(zf.z.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10979a = new zg.a("RoutingFailureStatusCode", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        f10980b = g2.a("io.ktor.server.routing.Routing");
    }

    public static final mg.a a(u uVar) {
        mg.a aVarA;
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        if (uVar instanceof n0) {
            return ((n0) uVar).f10977v;
        }
        u uVar2 = uVar.q;
        if (uVar2 == null || (aVarA = a(uVar2)) == null) {
            throw new UnsupportedOperationException("Cannot retrieve application from unattached routing entry");
        }
        return aVarA;
    }
}
