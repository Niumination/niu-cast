package yg;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import li.g0;
import li.l0;
import li.r1;
import oh.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements g0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final bd.b f11216h = new bd.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zg.a f11217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zg.a f11218j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.r f11222d;
    public final r1 e = l0.c();

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(q.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(q.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f11217i = new zg.a("WebSockets", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(List.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            kTypeTypeOf2 = Reflection.typeOf(List.class, companion.invariant(Reflection.typeOf(k0.class, companion.getSTAR())));
        } catch (Throwable unused2) {
        }
        f11218j = new zg.a("WebSocket extensions", new ih.a(orCreateKotlinClass2, kTypeTypeOf2));
    }

    public q(long j8, long j10, long j11, dj.r rVar) {
        this.f11219a = j8;
        this.f11220b = j10;
        this.f11221c = j11;
        this.f11222d = rVar;
        if (j8 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (j11 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.e;
    }
}
