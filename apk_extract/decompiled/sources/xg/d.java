package xg;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg.a f10934a;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f10934a = new zg.a("IgnoreTrailingSlashAttributeKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
        y0 body = new y0(17);
        Intrinsics.checkNotNullParameter("IgnoreTrailingSlash", "name");
        Intrinsics.checkNotNullParameter(body, "body");
        bb.s createConfiguration = new bb.s(23);
        Intrinsics.checkNotNullParameter("IgnoreTrailingSlash", "name");
        Intrinsics.checkNotNullParameter(createConfiguration, "createConfiguration");
        Intrinsics.checkNotNullParameter(body, "body");
        new qf.c("IgnoreTrailingSlash", new bh.a(2, createConfiguration), body);
    }
}
