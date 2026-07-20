package zf;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n0 f11524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n0 f11525d;
    public static final LinkedHashMap e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11527b;

    static {
        n0 n0Var = new n0("http", 80);
        f11524c = n0Var;
        n0 n0Var2 = new n0("https", 443);
        n0 n0Var3 = new n0("ws", 80);
        f11525d = n0Var3;
        List listListOf = CollectionsKt.listOf((Object[]) new n0[]{n0Var, n0Var2, n0Var3, new n0("wss", 443), new n0("socks", 1080)});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.i(listListOf)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(((n0) obj).f11526a, obj);
        }
        e = linkedHashMap;
    }

    public n0(String name, int i8) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f11526a = name;
        this.f11527b = i8;
        for (int i9 = 0; i9 < name.length(); i9++) {
            char cCharAt = name.charAt(i9);
            if (Character.toLowerCase(cCharAt) != cCharAt) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return Intrinsics.areEqual(this.f11526a, n0Var.f11526a) && this.f11527b == n0Var.f11527b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11527b) + (this.f11526a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("URLProtocol(name=");
        sb2.append(this.f11526a);
        sb2.append(", defaultPort=");
        return a1.a.r(sb2, this.f11527b, ')');
    }
}
