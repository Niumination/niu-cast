package pf;

import k3.pc;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zg.a f8841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qf.c f8842c;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(lf.a.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(lf.a.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8840a = new zg.a("UploadProgressListenerAttributeKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(lf.a.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(lf.a.class);
        } catch (Throwable unused2) {
        }
        f8841b = new zg.a("DownloadProgressListenerAttributeKey", new ih.a(orCreateKotlinClass2, kTypeTypeOf2));
        ag.b body = new ag.b(21);
        Intrinsics.checkNotNullParameter("BodyProgress", "name");
        Intrinsics.checkNotNullParameter(body, "body");
        f8842c = pc.a("BodyProgress", new ob.c(9), body);
    }
}
