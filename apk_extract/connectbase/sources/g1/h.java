package g1;

import c1.t;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
@t1.f("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t<String, String> f6365a = new t() { // from class: g1.g
        @Override // c1.t
        public final Object apply(Object obj) {
            return this.f6364a.b((String) obj);
        }
    };

    public final t<String, String> a() {
        return this.f6365a;
    }

    public abstract String b(String string);
}
