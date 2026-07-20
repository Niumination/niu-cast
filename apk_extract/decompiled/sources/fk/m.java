package fk;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends AtomicLong implements ck.e, ck.j {
    static final long UNSUBSCRIBED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final ck.i child;
    boolean emitting;
    Object index;
    boolean missed;
    final q parent;
    final AtomicLong totalRequested = new AtomicLong();

    public m(q qVar, ck.i iVar) {
        this.parent = qVar;
        this.child = iVar;
    }

    public void addTotalRequested(long j8) {
        long j10;
        long j11;
        do {
            j10 = this.totalRequested.get();
            j11 = j10 + j8;
            if (j11 < 0) {
                j11 = Long.MAX_VALUE;
            }
        } while (!this.totalRequested.compareAndSet(j10, j11));
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // ck.j
    public boolean isUnsubscribed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j8) {
        long j10;
        long j11;
        if (j8 <= 0) {
            throw new IllegalArgumentException("Cant produce zero or less");
        }
        do {
            j10 = get();
            if (j10 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            j11 = j10 - j8;
            if (j11 < 0) {
                StringBuilder sb2 = new StringBuilder("More produced (");
                sb2.append(j8);
                sb2.append(") than requested (");
                throw new IllegalStateException(o.d.p(sb2, j10, ")"));
            }
        } while (!compareAndSet(j10, j11));
        return j11;
    }

    @Override // ck.e
    public void request(long j8) {
        long j10;
        long j11;
        if (j8 < 0) {
            return;
        }
        do {
            j10 = get();
            if (j10 == Long.MIN_VALUE) {
                return;
            }
            if (j10 >= 0 && j8 == 0) {
                return;
            }
            j11 = j10 + j8;
            if (j11 < 0) {
                j11 = Long.MAX_VALUE;
            }
        } while (!compareAndSet(j10, j11));
        addTotalRequested(j8);
        this.parent.c();
        this.parent.e.replay(this);
    }

    @Override // ck.j
    public void unsubscribe() {
        AtomicReference atomicReference;
        m[] mVarArr;
        m[] mVarArr2;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
            return;
        }
        q qVar = this.parent;
        do {
            atomicReference = qVar.f5085i;
            mVarArr = (m[]) atomicReference.get();
            mVarArr2 = q.f5083o;
            if (mVarArr != mVarArr2 && mVarArr != q.p) {
                int length = mVarArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        i8 = -1;
                        break;
                    } else if (mVarArr[i8].equals(this)) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i8 < 0) {
                    break;
                }
                if (length != 1) {
                    mVarArr2 = new m[length - 1];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, i8);
                    System.arraycopy(mVarArr, i8 + 1, mVarArr2, i8, (length - i8) - 1);
                }
            } else {
                break;
            }
        } while (!atomicReference.compareAndSet(mVarArr, mVarArr2));
        this.parent.c();
    }
}
