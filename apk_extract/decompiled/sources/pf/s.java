package pf;

import k3.pc;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zg.a f8866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qf.c f8867c;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8865a = new zg.a("SkipSaveBody", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Unit.class);
        } catch (Throwable unused2) {
        }
        f8866b = new zg.a("ResponseBodySaved", new ih.a(orCreateKotlinClass2, kTypeTypeOf2));
        f8867c = pc.a("DoubleReceivePlugin", q.INSTANCE, new ag.b(23));
    }
}
