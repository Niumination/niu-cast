package wg;

import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10760a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ih.a.class);
        try {
            kTypeTypeOf = Reflection.typeOf(ih.a.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10760a = new zg.a("ResponseTypeAttributeKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }
}
