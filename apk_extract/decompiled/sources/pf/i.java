package pf;

import k3.g2;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vj.b f8848b;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8847a = new zg.a("ValidateMark", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        f8848b = g2.a("io.ktor.client.plugins.DefaultResponseValidation");
    }
}
