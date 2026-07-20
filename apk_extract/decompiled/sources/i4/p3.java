package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class p3 extends s2 {
    private final ReferenceQueue<Object> queueForKeys;
    private final ReferenceQueue<Object> queueForValues;

    public p3(u3 u3Var, int i8) {
        super(u3Var, i8);
        this.queueForKeys = new ReferenceQueue<>();
        this.queueForValues = new ReferenceQueue<>();
    }

    @Override // i4.s2
    public ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
        return this.queueForKeys;
    }

    @Override // i4.s2
    public ReferenceQueue<Object> getValueReferenceQueueForTesting() {
        return this.queueForValues;
    }

    @Override // i4.s2
    public r3 getWeakValueReferenceForTesting(p2 p2Var) {
        return castForTesting(p2Var).f5669b;
    }

    @Override // i4.s2
    public void maybeClearReferenceQueues() {
        clearReferenceQueue(this.queueForKeys);
    }

    @Override // i4.s2
    public void maybeDrainReferenceQueues() {
        drainKeyReferenceQueue(this.queueForKeys);
        drainValueReferenceQueue(this.queueForValues);
    }

    @Override // i4.s2
    public r3 newWeakValueReferenceForTesting(p2 p2Var, Object obj) {
        return new s3(this.queueForValues, obj, castForTesting(p2Var));
    }

    @Override // i4.s2
    public void setWeakValueReferenceForTesting(p2 p2Var, r3 r3Var) {
        o3 o3VarCastForTesting = castForTesting(p2Var);
        r3 r3Var2 = o3VarCastForTesting.f5669b;
        o3VarCastForTesting.f5669b = r3Var;
        r3Var2.clear();
    }

    @Override // i4.s2
    public o3 castForTesting(p2 p2Var) {
        return (o3) p2Var;
    }

    @Override // i4.s2
    public p3 self() {
        return this;
    }
}
