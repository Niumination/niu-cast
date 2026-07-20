package uf;

import dj.r;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final se.g f10434d = new se.g(5);
    public static final zg.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f10437c;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(m.class);
        try {
            kTypeTypeOf = Reflection.typeOf(m.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        e = new zg.a("Websocket", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public m(long j8, long j10, r extensionsConfig) {
        Intrinsics.checkNotNullParameter(extensionsConfig, "extensionsConfig");
        this.f10435a = j8;
        this.f10436b = j10;
        this.f10437c = extensionsConfig;
    }
}
