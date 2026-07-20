package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class m1<T> implements d0<T>, Serializable {

    @os.m
    private volatile Object _value;

    @os.m
    private jn.a<? extends T> initializer;

    @os.l
    private final Object lock;

    public m1(@os.l jn.a<? extends T> aVar, @os.m Object obj) {
        kn.l0.p(aVar, "initializer");
        this.initializer = aVar;
        this._value = e2.f10185a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // lm.d0
    public T getValue() {
        T tInvoke;
        T t10 = (T) this._value;
        e2 e2Var = e2.f10185a;
        if (t10 != e2Var) {
            return t10;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == e2Var) {
                jn.a<? extends T> aVar = this.initializer;
                kn.l0.m(aVar);
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // lm.d0
    public boolean isInitialized() {
        return this._value != e2.f10185a;
    }

    @os.l
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ m1(jn.a aVar, Object obj, int i10, kn.w wVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
