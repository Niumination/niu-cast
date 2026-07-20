package kn;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.1")
public final class b1 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Class<?> f9292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f9293b;

    public b1(@os.l Class<?> cls, @os.l String str) {
        l0.p(cls, "jClass");
        l0.p(str, "moduleName");
        this.f9292a = cls;
        this.f9293b = str;
    }

    @Override // un.h
    @os.l
    public Collection<un.c<?>> d() {
        throw new in.r();
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof b1) && l0.g(this.f9292a, ((b1) obj).f9292a);
    }

    public int hashCode() {
        return this.f9292a.hashCode();
    }

    @Override // kn.t
    @os.l
    public Class<?> s() {
        return this.f9292a;
    }

    @os.l
    public String toString() {
        return this.f9292a.toString() + l1.f9320b;
    }
}
