package fp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f6229b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f6230c = new g(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, i.g<?, ?>> f6231a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6233b;

        public a(Object obj, int i10) {
            this.f6232a = obj;
            this.f6233b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6232a == aVar.f6232a && this.f6233b == aVar.f6233b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f6232a) * 65535) + this.f6233b;
        }
    }

    public g() {
        this.f6231a = new HashMap();
    }

    public static g c() {
        return f6230c;
    }

    public static g d() {
        return new g();
    }

    public final void a(i.g<?, ?> gVar) {
        this.f6231a.put(new a(gVar.b(), gVar.d()), gVar);
    }

    public <ContainingType extends q> i.g<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (i.g) this.f6231a.get(new a(containingtype, i10));
    }

    public g(boolean z10) {
        this.f6231a = Collections.emptyMap();
    }
}
