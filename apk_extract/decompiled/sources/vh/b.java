package vh;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m3.a0;
import o.d;
import rh.f;

/* JADX INFO: loaded from: classes3.dex */
public enum b implements uj.b {
    CANCELLED;

    public static void deferredRequest(AtomicReference<uj.b> atomicReference, AtomicLong atomicLong, long j8) {
        long j10;
        long j11;
        uj.b bVar = atomicReference.get();
        if (bVar != null) {
            bVar.request(j8);
            return;
        }
        if (validate(j8)) {
            do {
                j10 = atomicLong.get();
                if (j10 == Long.MAX_VALUE) {
                    break;
                } else {
                    j11 = j10 + j8;
                }
            } while (!atomicLong.compareAndSet(j10, j11 >= 0 ? j11 : Long.MAX_VALUE));
            uj.b bVar2 = atomicReference.get();
            if (bVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    bVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<uj.b> atomicReference, AtomicLong atomicLong, uj.b bVar) {
        if (!setOnce(atomicReference, bVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        bVar.request(andSet);
        return true;
    }

    public static boolean isCancelled(uj.b bVar) {
        return bVar == CANCELLED;
    }

    public static boolean replace(AtomicReference<uj.b> atomicReference, uj.b bVar) {
        uj.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == CANCELLED) {
                if (bVar == null) {
                    return false;
                }
                bVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static void reportMoreProduced(long j8) {
        a0.a(new f(d.j("More produced than requested: ", j8)));
    }

    public static void reportSubscriptionSet() {
        a0.a(new f("Subscription already set!"));
    }

    public static boolean set(AtomicReference<uj.b> atomicReference, uj.b bVar) {
        uj.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == CANCELLED) {
                if (bVar == null) {
                    return false;
                }
                bVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<uj.b> atomicReference, uj.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("s is null");
        }
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(uj.b bVar, uj.b bVar2) {
        if (bVar2 == null) {
            a0.a(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // uj.b
    public void cancel() {
    }

    @Override // uj.b
    public void request(long j8) {
    }

    public static boolean cancel(AtomicReference<uj.b> atomicReference) {
        uj.b andSet;
        uj.b bVar = atomicReference.get();
        b bVar2 = CANCELLED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j8) {
        if (j8 > 0) {
            return true;
        }
        a0.a(new IllegalArgumentException(d.j("n > 0 required but it was ", j8)));
        return false;
    }

    public static boolean setOnce(AtomicReference<uj.b> atomicReference, uj.b bVar, long j8) {
        if (!setOnce(atomicReference, bVar)) {
            return false;
        }
        bVar.request(j8);
        return true;
    }
}
