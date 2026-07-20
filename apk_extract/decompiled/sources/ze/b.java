package ze;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import k3.u8;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11321b = new b(new IdentityHashMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f11322a;

    public b(IdentityHashMap identityHashMap) {
        this.f11322a = identityHashMap;
    }

    public final n6.a a() {
        n6.a aVar = new n6.a(6);
        aVar.f8122b = this;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        IdentityHashMap identityHashMap = this.f11322a;
        int size = identityHashMap.size();
        IdentityHashMap identityHashMap2 = ((b) obj).f11322a;
        if (size != identityHashMap2.size()) {
            return false;
        }
        for (Map.Entry entry : identityHashMap.entrySet()) {
            if (!identityHashMap2.containsKey(entry.getKey()) || !u8.a(entry.getValue(), identityHashMap2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.f11322a.entrySet()) {
            iHashCode += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return iHashCode;
    }

    public final String toString() {
        return this.f11322a.toString();
    }
}
