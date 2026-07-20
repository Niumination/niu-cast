package mf;

import java.util.Map;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import pf.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f8037a;

    static {
        KType kTypeMutableCollectionType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            kTypeMutableCollectionType = Reflection.mutableCollectionType(Reflection.typeOf(Map.class, companion.invariant(Reflection.typeOf(i.class, companion.getSTAR())), companion.invariant(Reflection.typeOf(Object.class))));
        } catch (Throwable unused) {
            kTypeMutableCollectionType = null;
        }
        f8037a = new zg.a("EngineCapabilities", new ih.a(orCreateKotlinClass, kTypeMutableCollectionType));
        SetsKt.setOf(z0.f8882a);
    }
}
