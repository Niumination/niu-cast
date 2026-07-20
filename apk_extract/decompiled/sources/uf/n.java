package uf;

import java.util.List;
import k3.g2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import oh.k0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vj.b f10439b;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            kTypeTypeOf = Reflection.typeOf(List.class, companion.invariant(Reflection.typeOf(k0.class, companion.getSTAR())));
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10438a = new zg.a("Websocket extensions", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        f10439b = g2.a("io.ktor.client.plugins.websocket.WebSockets");
    }
}
