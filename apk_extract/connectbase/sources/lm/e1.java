package lm;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class e1<T> implements d0<T>, Serializable {

    @os.l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<e1<?>, Object> f10184a = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_value");

    @os.m
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    @os.l
    private final Object f0final;

    @os.m
    private volatile jn.a<? extends T> initializer;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public e1(@os.l jn.a<? extends T> aVar) {
        kn.l0.p(aVar, "initializer");
        this.initializer = aVar;
        e2 e2Var = e2.f10185a;
        this._value = e2Var;
        this.f0final = e2Var;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // lm.d0
    public T getValue() {
        T t10 = (T) this._value;
        e2 e2Var = e2.f10185a;
        if (t10 != e2Var) {
            return t10;
        }
        jn.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (j.d.a(f10184a, this, e2Var, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override // lm.d0
    public boolean isInitialized() {
        return this._value != e2.f10185a;
    }

    @os.l
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
