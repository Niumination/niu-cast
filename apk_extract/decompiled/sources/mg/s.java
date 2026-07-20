package mg;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8076a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ih.a.class);
        try {
            kTypeTypeOf = Reflection.typeOf(ih.a.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8076a = new zg.a("ReceiveType", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final ih.a a(r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        return (ih.a) rVar.i().b(f8076a);
    }
}
