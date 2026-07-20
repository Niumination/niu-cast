package vf;

import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10566a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(j.class);
        try {
            kTypeTypeOf = Reflection.typeOf(j.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10566a = new zg.a("ResponseAdapterAttributeKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }
}
