package pf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f8822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f8823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f8824c;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(a1.class);
        try {
            kTypeTypeOf = Reflection.typeOf(a1.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        ih.a type = new ih.a(orCreateKotlinClass, kTypeTypeOf);
        Intrinsics.checkNotNullParameter("TimeoutConfiguration", "name");
        Intrinsics.checkNotNullParameter(type, "type");
        if (StringsKt.isBlank("TimeoutConfiguration")) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    public a1() {
        this.f8822a = 0L;
        this.f8823b = 0L;
        this.f8824c = 0L;
        this.f8822a = null;
        this.f8823b = null;
        this.f8824c = null;
    }

    public static void a(Long l4) {
        if (l4 != null && l4.longValue() <= 0) {
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a1.class != obj.getClass()) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return Intrinsics.areEqual(this.f8822a, a1Var.f8822a) && Intrinsics.areEqual(this.f8823b, a1Var.f8823b) && Intrinsics.areEqual(this.f8824c, a1Var.f8824c);
    }

    public final int hashCode() {
        Long l4 = this.f8822a;
        int iHashCode = (l4 != null ? l4.hashCode() : 0) * 31;
        Long l8 = this.f8823b;
        int iHashCode2 = (iHashCode + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l10 = this.f8824c;
        return iHashCode2 + (l10 != null ? l10.hashCode() : 0);
    }
}
