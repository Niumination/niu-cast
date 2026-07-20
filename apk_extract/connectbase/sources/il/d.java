package il;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;
import kn.l1;
import kn.x0;
import lm.l2;
import os.l;
import os.m;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements Iterator<T>, ln.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f8247b = {l1.k(new x0(d.class, "previous", "getPrevious()Lio/ktor/util/collections/internal/ForwardListNode;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final qn.f f8248a;

    public static final class a implements qn.f<Object, e<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f8249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8250b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj) {
            this.f8250b = obj;
            this.f8249a = obj;
        }

        @Override // qn.f, qn.e
        public e<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8249a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<T> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8249a = eVar;
        }
    }

    public d(@l e<T> eVar) {
        l0.p(eVar, "head");
        this.f8248a = new a(eVar);
    }

    @m
    public final e<T> a() {
        e<T> eVarC = c();
        if (eVarC == null) {
            return null;
        }
        return eVarC.b();
    }

    @m
    public final e<T> c() {
        return (e) this.f8248a.a(this, f8247b[0]);
    }

    public final void e(@m e<T> eVar) {
        this.f8248a.b(this, f8247b[0], eVar);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        e<T> eVarA = a();
        return (eVarA == null ? null : eVarA.f8253b) != null;
    }

    @Override // java.util.Iterator
    @l
    public T next() {
        e(a());
        e<T> eVarC = c();
        T t10 = eVarC == null ? null : eVarC.f8253b;
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        l2 l2Var;
        e<T> eVarC = c();
        if (eVarC == null) {
            l2Var = null;
        } else {
            eVarC.e();
            l2Var = l2.f10208a;
        }
        if (l2Var == null) {
            throw new IllegalStateException("Fail to remove element before iteration");
        }
    }
}
