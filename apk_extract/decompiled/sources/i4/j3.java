package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class j3 extends s2 {
    private final ReferenceQueue<Object> queueForKeys;

    public j3(u3 u3Var, int i8) {
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
    public i3 castForTesting(p2 p2Var) {
        return (i3) p2Var;
    }

    @Override // i4.s2
    public j3 self() {
        return this;
    }
}
