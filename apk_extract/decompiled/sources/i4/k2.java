package i4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import k3.v8;
import k3.w8;

/* JADX INFO: loaded from: classes.dex */
public abstract class k2 extends w implements Serializable {
    private static final long serialVersionUID = 3;
    final int concurrencyLevel;
    transient ConcurrentMap<Object, Object> delegate;
    final h4.l keyEquivalence;
    final w2 keyStrength;
    final h4.l valueEquivalence;
    final w2 valueStrength;

    public k2(w2 w2Var, w2 w2Var2, h4.l lVar, h4.l lVar2, int i8, ConcurrentMap<Object, Object> concurrentMap) {
        this.keyStrength = w2Var;
        this.valueStrength = w2Var2;
        this.keyEquivalence = lVar;
        this.valueEquivalence = lVar2;
        this.concurrencyLevel = i8;
        this.delegate = concurrentMap;
    }

    public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            }
            this.delegate.put(object, objectInputStream.readObject());
        }
    }

    public i2 readMapMaker(ObjectInputStream objectInputStream) throws IOException {
        int i8 = objectInputStream.readInt();
        i2 i2Var = new i2();
        v8.e(i8 >= 0);
        i2Var.f5608b = i8;
        w2 w2Var = this.keyStrength;
        w2 w2Var2 = i2Var.f5610d;
        v8.l("Key strength was already set to %s", w2Var2 == null, w2Var2);
        w2Var.getClass();
        i2Var.f5610d = w2Var;
        w2 w2Var3 = w2.STRONG;
        if (w2Var != w2Var3) {
            i2Var.f5607a = true;
        }
        w2 w2Var4 = this.valueStrength;
        w2 w2Var5 = i2Var.e;
        v8.l("Value strength was already set to %s", w2Var5 == null, w2Var5);
        w2Var4.getClass();
        i2Var.e = w2Var4;
        if (w2Var4 != w2Var3) {
            i2Var.f5607a = true;
        }
        h4.l lVar = this.keyEquivalence;
        h4.l lVar2 = i2Var.f;
        v8.l("key equivalence was already set to %s", lVar2 == null, lVar2);
        lVar.getClass();
        i2Var.f = lVar;
        i2Var.f5607a = true;
        int i9 = this.concurrencyLevel;
        int i10 = i2Var.f5609c;
        if (!(i10 == -1)) {
            throw new IllegalStateException(w8.a("concurrency level was already set to %s", Integer.valueOf(i10)));
        }
        v8.e(i9 > 0);
        i2Var.f5609c = i9;
        return i2Var;
    }

    public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.delegate.size());
        for (Map.Entry<Object, Object> entry : this.delegate.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    @Override // i4.x, i4.y
    public ConcurrentMap<Object, Object> delegate() {
        return this.delegate;
    }
}
