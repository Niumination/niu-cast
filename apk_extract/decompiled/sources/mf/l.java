package mf;

import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import li.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f8038a = new f0("call-context");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zg.a f8039b;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(jf.e.class);
        try {
            kTypeTypeOf = Reflection.typeOf(jf.e.class, KTypeProjection.INSTANCE.getSTAR());
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8039b = new zg.a("client-config", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }
}
