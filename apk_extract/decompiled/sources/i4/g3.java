package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class g3 extends s2 {
    private final ReferenceQueue<Object> queueForValues;

    public g3(u3 u3Var, int i8) {
        super(u3Var, i8);
        this.queueForValues = new ReferenceQueue<>();
    }

    @Override // i4.s2
    public ReferenceQueue<Object> getValueReferenceQueueForTesting() {
        return this.queueForValues;
    }

    @Override // i4.s2
    public r3 getWeakValueReferenceForTesting(p2 p2Var) {
        return castForTesting(p2Var).f5586c;
    }

    @Override // i4.s2
    public void maybeClearReferenceQueues() {
        clearReferenceQueue(this.queueForValues);
    }

    @Override // i4.s2
    public void maybeDrainReferenceQueues() {
        drainValueReferenceQueue(this.queueForValues);
    }

    @Override // i4.s2
    public r3 newWeakValueReferenceForTesting(p2 p2Var, Object obj) {
        return new s3(this.queueForValues, obj, castForTesting(p2Var));
    }

    @Override // i4.s2
    public void setWeakValueReferenceForTesting(p2 p2Var, r3 r3Var) {
        f3 f3VarCastForTesting = castForTesting(p2Var);
        r3 r3Var2 = f3VarCastForTesting.f5586c;
        f3VarCastForTesting.f5586c = r3Var;
        r3Var2.clear();
    }

    @Override // i4.s2
    public f3 castForTesting(p2 p2Var) {
        return (f3) p2Var;
    }

    @Override // i4.s2
    public g3 self() {
        return this;
    }
}
