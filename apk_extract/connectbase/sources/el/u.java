package el;

import ik.y0;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class u<S> implements r<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<S> f4549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m<S> f4550b;

    public u(@os.l un.d<S> dVar, @os.l m<S> mVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(mVar, "serializer");
        this.f4549a = dVar;
        this.f4550b = mVar;
    }

    @Override // el.r
    @os.m
    public Object a(@os.l dk.b bVar, @os.l S s10, @os.l um.d<? super String> dVar) {
        return this.f4550b.serialize(s10);
    }

    @Override // el.r
    @os.m
    public Object b(@os.l dk.b bVar, @os.m String str, @os.l um.d<? super S> dVar) {
        if (str == null) {
            return null;
        }
        try {
            return this.f4550b.a(str);
        } catch (Throwable th2) {
            dk.j.a(bVar.a()).debug(l0.C("Failed to deserialize session: ", str), th2);
            return null;
        }
    }

    @Override // el.r
    @os.m
    public Object c(@os.l dk.b bVar, @os.l um.d<? super l2> dVar) {
        return l2.f10208a;
    }

    @os.l
    public final m<S> d() {
        return this.f4550b;
    }

    @os.l
    public final un.d<S> e() {
        return this.f4549a;
    }

    @os.l
    public String toString() {
        return "SessionTrackerByValue";
    }

    @Override // el.r
    public void validate(@os.l S s10) {
        l0.p(s10, "value");
        if (in.b.g(this.f4549a).isAssignableFrom(s10.getClass())) {
            return;
        }
        throw new IllegalArgumentException("Value for this session tracker expected to be of type " + this.f4549a + " but was " + s10);
    }
}
