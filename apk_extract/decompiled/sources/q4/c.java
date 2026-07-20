package q4;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f8962b;

    public c(String str, Map map) {
        this.f8961a = str;
        this.f8962b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.emptyMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8961a.equals(cVar.f8961a) && this.f8962b.equals(cVar.f8962b);
    }

    public final int hashCode() {
        return this.f8962b.hashCode() + (this.f8961a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f8961a + ", properties=" + this.f8962b.values() + "}";
    }
}
