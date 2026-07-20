package fk;

import java.util.ArrayList;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends ArrayList implements o {
    private static final long serialVersionUID = 7063189396499112664L;
    final d nl;
    volatile int size;

    public t(int i8) {
        super(i8);
        this.nl = d.f5057a;
    }

    @Override // fk.o
    public void complete() {
        this.nl.getClass();
        add(d.f5058b);
        this.size++;
    }

    @Override // fk.o
    public void error(Throwable th2) {
        this.nl.getClass();
        add(new c(th2));
        this.size++;
    }

    @Override // fk.o
    public void next(Object obj) {
        this.nl.getClass();
        if (obj == null) {
            obj = d.f5059c;
        }
        add(obj);
        this.size++;
    }

    @Override // fk.o
    public void replay(m mVar) {
        synchronized (mVar) {
            try {
                if (mVar.emitting) {
                    mVar.missed = true;
                    return;
                }
                mVar.emitting = true;
                while (!mVar.isUnsubscribed()) {
                    int i8 = this.size;
                    Integer num = (Integer) mVar.index();
                    int iIntValue = num != null ? num.intValue() : 0;
                    long j8 = mVar.get();
                    long j10 = j8;
                    long j11 = 0;
                    while (j10 != 0 && iIntValue < i8) {
                        Object obj = get(iIntValue);
                        try {
                            d dVar = this.nl;
                            ck.i iVar = mVar.child;
                            dVar.getClass();
                            if (d.a(iVar, obj) || mVar.isUnsubscribed()) {
                                return;
                            }
                            iIntValue++;
                            j10--;
                            j11++;
                        } catch (Throwable th2) {
                            x1.b(th2);
                            mVar.unsubscribe();
                            this.nl.getClass();
                            if (obj instanceof c) {
                                return;
                            }
                            this.nl.getClass();
                            if (obj == d.f5058b) {
                                return;
                            }
                            ck.i iVar2 = mVar.child;
                            this.nl.getClass();
                            if (obj == d.f5059c) {
                                obj = null;
                            }
                            iVar2.onError(dk.j.addValueAsLastCause(th2, obj));
                            return;
                        }
                    }
                    if (j11 != 0) {
                        mVar.index = Integer.valueOf(iIntValue);
                        if (j8 != Long.MAX_VALUE) {
                            mVar.produced(j11);
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
}
