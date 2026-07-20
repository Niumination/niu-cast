package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class m3 extends s2 {
    private final ReferenceQueue<Object> queueForKeys;

    public m3(u3 u3Var, int i8) {
        super(u3Var, i8);
        this.queueForKeys = new ReferenceQueue<>();
    }

    @Override // i4.s2
    public ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
        return this.queueForKeys;
    }

    @Override // i4.s2
    public void maybeClearReferenceQueues() {
        clearReferenceQueue(this.queueForKeys);
    }

    @Override // i4.s2
    public void maybeDrainReferenceQueues() {
        drainKeyReferenceQueue(this.queueForKeys);
    }

    @Override // i4.s2
    public l3 castForTesting(p2 p2Var) {
        return (l3) p2Var;
    }

    @Override // i4.s2
    public m3 self() {
        return this;
    }
}
