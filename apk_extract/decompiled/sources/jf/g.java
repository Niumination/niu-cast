package jf;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mf.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f6269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f6270b;

    static {
        k kVarA;
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(f.class, f.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(...)");
        List list = CollectionsKt.toList(serviceLoaderLoad);
        f6269a = list;
        f fVar = (f) CollectionsKt.firstOrNull(list);
        if (fVar == null || (kVarA = fVar.a()) == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation in the classpath: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html");
        }
        f6270b = kVarA;
    }
}
