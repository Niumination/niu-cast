package zg;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractMap f11589b;

    public h(int i8) {
        this.f11588a = i8;
        switch (i8) {
            case 1:
                this.f11589b = new HashMap();
                break;
            default:
                this.f11589b = new ConcurrentHashMap();
                break;
        }
    }

    public final Object a(a key, Function0 block) {
        switch (this.f11588a) {
            case 0:
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(block, "block");
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f11589b;
                Object obj = concurrentHashMap.get(key);
                if (obj == null) {
                    Object objInvoke = block.invoke();
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
                    obj = objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
                }
                return obj;
            default:
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(block, "block");
                HashMap map = (HashMap) this.f11589b;
                Object obj2 = map.get(key);
                if (obj2 == null) {
                    Object objInvoke2 = block.invoke();
                    Object objPut = map.put(key, objInvoke2);
                    obj2 = objPut == null ? objInvoke2 : objPut;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of io.ktor.util.HashMapAttributes.computeIfAbsent");
                }
                return obj2;
        }
    }

    public final Object b(a key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object objD = d(key);
        if (objD != null) {
            return objD;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    public final Map c() {
        switch (this.f11588a) {
            case 0:
                return (ConcurrentHashMap) this.f11589b;
            default:
                return (HashMap) this.f11589b;
        }
    }

    public final Object d(a key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return c().get(key);
    }

    public final void e(a key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        c().put(key, value);
    }
}
