package jl;

import ik.y0;
import java.util.List;
import kn.l0;
import lm.z0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements jl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final un.d<?> f8746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final jn.l<List<String>, Object> f8747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final jn.l<Object, List<String>> f8748c;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final un.d<T> f8749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m
        public jn.l<? super List<String>, ? extends T> f8750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m
        public jn.l<? super T, ? extends List<String>> f8751c;

        @z0
        public a(@l un.d<T> dVar) {
            l0.p(dVar, "klass");
            this.f8749a = dVar;
        }

        public final void a(@l jn.l<? super List<String>, ? extends T> lVar) {
            l0.p(lVar, "converter");
            if (this.f8750b == null) {
                this.f8750b = lVar;
                return;
            }
            throw new IllegalStateException("Decoder has already been set for type '" + this.f8749a + '\'');
        }

        public final void b(@l jn.l<? super T, ? extends List<String>> lVar) {
            l0.p(lVar, "converter");
            if (this.f8751c == null) {
                this.f8751c = lVar;
                return;
            }
            throw new IllegalStateException("Encoder has already been set for type '" + this.f8749a + '\'');
        }

        @m
        public final jn.l<List<String>, T> c() {
            return this.f8750b;
        }

        @m
        public final jn.l<T, List<String>> d() {
            return this.f8751c;
        }

        @l
        public final un.d<T> e() {
            return this.f8749a;
        }

        public final void f(@m jn.l<? super List<String>, ? extends T> lVar) {
            this.f8750b = lVar;
        }

        public final void g(@m jn.l<? super T, ? extends List<String>> lVar) {
            this.f8751c = lVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@l un.d<?> dVar, @m jn.l<? super List<String>, ? extends Object> lVar, @m jn.l<Object, ? extends List<String>> lVar2) {
        l0.p(dVar, "klass");
        this.f8746a = dVar;
        this.f8747b = lVar;
        this.f8748c = lVar2;
    }

    @Override // jl.a
    @l
    public List<String> a(@m Object obj) {
        jn.l<Object, List<String>> lVar = this.f8748c;
        if (lVar != null) {
            l0.m(lVar);
            return lVar.invoke(obj);
        }
        throw new IllegalStateException("Encoder was not specified for type '" + this.f8746a + '\'');
    }

    @Override // jl.a
    @m
    public Object b(@l List<String> list, @l ol.b bVar) {
        l0.p(list, "values");
        l0.p(bVar, y0.a.f8215h);
        jn.l<List<String>, Object> lVar = this.f8747b;
        if (lVar != null) {
            l0.m(lVar);
            return lVar.invoke(list);
        }
        throw new IllegalStateException("Decoder was not specified for type '" + this.f8746a + '\'');
    }
}
