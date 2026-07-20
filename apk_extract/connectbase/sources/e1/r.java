package e1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@i
public final class r extends a0 implements Serializable, p {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream s10) throws ClassNotFoundException, IOException {
        s10.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = s10.readLong();
    }

    private void writeObject(ObjectOutputStream s10) throws IOException {
        s10.defaultWriteObject();
        s10.writeLong(sum());
    }

    @Override // e1.p
    public void add(long x10) {
        int length;
        a0.b bVar;
        a0.b[] bVarArr = this.cells;
        if (bVarArr == null) {
            long j10 = this.base;
            if (casBase(j10, j10 + x10)) {
                return;
            }
        }
        int[] iArr = a0.threadHashCode.get();
        boolean zA = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j11 = bVar.f3876h;
            zA = bVar.a(j11, j11 + x10);
            if (zA) {
                return;
            }
        }
        retryUpdate(x10, iArr, zA);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // e1.a0
    public final long fn(long v10, long x10) {
        return v10 + x10;
    }

    @Override // e1.p
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // e1.p
    public long sum() {
        long j10 = this.base;
        a0.b[] bVarArr = this.cells;
        if (bVarArr != null) {
            for (a0.b bVar : bVarArr) {
                if (bVar != null) {
                    j10 += bVar.f3876h;
                }
            }
        }
        return j10;
    }

    public long sumThenReset() {
        long j10 = this.base;
        a0.b[] bVarArr = this.cells;
        this.base = 0L;
        if (bVarArr != null) {
            for (a0.b bVar : bVarArr) {
                if (bVar != null) {
                    j10 += bVar.f3876h;
                    bVar.f3876h = 0L;
                }
            }
        }
        return j10;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
