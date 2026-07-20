package pf;

import java.util.ArrayList;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8879b = new b(7);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zg.a f8880c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8881a = new ArrayList();

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(y0.class);
        try {
            kTypeTypeOf = Reflection.typeOf(y0.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8880c = new zg.a("HttpSend", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }
}
