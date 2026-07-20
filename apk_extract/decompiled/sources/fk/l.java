package fk;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public class l extends AtomicReference implements o {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    final d nl = d.f5057a;
    int size;
    n tail;

    public l() {
        n nVar = new n(null, 0L);
        this.tail = nVar;
        set(nVar);
    }

    public final void addLast(n nVar) {
        this.tail.set(nVar);
        this.tail = nVar;
        this.size++;
    }

    public final void collect(Collection<Object> collection) {
        n nVar = (n) get();
        while (true) {
            nVar = (n) nVar.get();
            if (nVar == null) {
                return;
            }
            Object objLeaveTransform = leaveTransform(nVar.value);
            this.nl.getClass();
            if (objLeaveTransform == d.f5058b) {
                return;
            }
            this.nl.getClass();
            if (objLeaveTransform instanceof c) {
                return;
            }
            this.nl.getClass();
            if (objLeaveTransform == d.f5059c) {
                objLeaveTransform = null;
            }
            collection.add(objLeaveTransform);
        }
    }

    @Override // fk.o
    public final void complete() {
        this.nl.getClass();
        Object objEnterTransform = enterTransform(d.f5058b);
        long j8 = this.index + 1;
        this.index = j8;
        addLast(new n(objEnterTransform, j8));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    @Override // fk.o
    public final void error(Throwable th2) {
        this.nl.getClass();
        Object objEnterTransform = enterTransform(new c(th2));
        long j8 = this.index + 1;
        this.index = j8;
        addLast(new n(objEnterTransform, j8));
        truncateFinal();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        if (obj != null) {
            d dVar = this.nl;
            Object objLeaveTransform = leaveTransform(obj);
            dVar.getClass();
            if (objLeaveTransform == d.f5058b) {
                return true;
            }
        }
        return false;
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        if (obj != null) {
            d dVar = this.nl;
            Object objLeaveTransform = leaveTransform(obj);
            dVar.getClass();
            if (objLeaveTransform instanceof c) {
                return true;
            }
        }
        return false;
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    @Override // fk.o
    public final void next(Object obj) {
        this.nl.getClass();
        if (obj == null) {
            obj = d.f5059c;
        }
        Object objEnterTransform = enterTransform(obj);
        long j8 = this.index + 1;
        this.index = j8;
        addLast(new n(objEnterTransform, j8));
        truncate();
    }

    public final void removeFirst() {
        n nVar = (n) ((n) get()).get();
        if (nVar == null) {
            throw new IllegalStateException("Empty list!");
        }
        this.size--;
        setFirst(nVar);
    }

    public final void removeSome(int i8) {
        n nVar = (n) get();
        while (i8 > 0) {
            nVar = (n) nVar.get();
            i8--;
            this.size--;
        }
        setFirst(nVar);
    }

    @Override // fk.o
    public final void replay(m mVar) {
        n nVar;
        synchronized (mVar) {
            try {
                if (mVar.emitting) {
                    mVar.missed = true;
                    return;
                }
                mVar.emitting = true;
                while (!mVar.isUnsubscribed()) {
                    long j8 = mVar.get();
                    boolean z2 = j8 == Long.MAX_VALUE;
                    n nVar2 = (n) mVar.index();
                    if (nVar2 == null) {
                        nVar2 = (n) get();
                        mVar.index = nVar2;
                        mVar.addTotalRequested(nVar2.index);
                    }
                    if (mVar.isUnsubscribed()) {
                        return;
                    }
                    long j10 = 0;
                    while (j8 != 0 && (nVar = (n) nVar2.get()) != null) {
                        Object objLeaveTransform = leaveTransform(nVar.value);
                        try {
                            d dVar = this.nl;
                            ck.i iVar = mVar.child;
                            dVar.getClass();
                            if (d.a(iVar, objLeaveTransform)) {
                                mVar.index = null;
                                return;
                            }
                            j10++;
                            j8--;
                            if (mVar.isUnsubscribed()) {
                                return;
                            } else {
                                nVar2 = nVar;
                            }
                        } catch (Throwable th2) {
                            mVar.index = null;
                            x1.b(th2);
                            mVar.unsubscribe();
                            this.nl.getClass();
                            if (objLeaveTransform instanceof c) {
                                return;
                            }
                            this.nl.getClass();
                            if (objLeaveTransform == d.f5058b) {
                                return;
                            }
                            ck.i iVar2 = mVar.child;
                            this.nl.getClass();
                            if (objLeaveTransform == d.f5059c) {
                                objLeaveTransform = null;
                            }
                            iVar2.onError(dk.j.addValueAsLastCause(th2, objLeaveTransform));
                            return;
                        }
                    }
                    if (j10 != 0) {
                        mVar.index = nVar2;
                        if (!z2) {
                            mVar.produced(j10);
                        }
                    }
                    synchronized (mVar) {
                        try {
                            if (!mVar.missed) {
                                mVar.emitting = false;
                                return;
                            }
                            mVar.missed = false;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void setFirst(n nVar) {
        set(nVar);
    }

    public void truncate() {
    }

    public void truncateFinal() {
    }
}
