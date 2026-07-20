package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class m2<T> implements d0<T>, Serializable {

    @os.m
    private Object _value;

    @os.m
    private jn.a<? extends T> initializer;

    public m2(@os.l jn.a<? extends T> aVar) {
        kn.l0.p(aVar, "initializer");
        this.initializer = aVar;
        this._value = e2.f10185a;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // lm.d0
    public T getValue() {
        if (this._value == e2.f10185a) {
            jn.a<? extends T> aVar = this.initializer;
            kn.l0.m(aVar);
            this._value = aVar.invoke();
            this.initializer = null;
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
