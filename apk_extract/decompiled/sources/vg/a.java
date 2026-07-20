package vg;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10585a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Long.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10585a = new zg.a("FormFieldLimit", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(d.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(d.class);
        } catch (Throwable unused2) {
        }
        ih.a type = new ih.a(orCreateKotlinClass2, kTypeTypeOf2);
        Intrinsics.checkNotNullParameter("DoubleReceivePreventionToken", "name");
        Intrinsics.checkNotNullParameter(type, "type");
        if (StringsKt.isBlank("DoubleReceivePreventionToken")) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }
}
