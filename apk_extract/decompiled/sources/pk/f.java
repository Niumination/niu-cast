package pk;

import ck.i;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AtomicReference implements ck.a {
    boolean active;
    volatile Object latest;
    public final fk.d nl;
    ek.b onAdded;
    ek.b onStart;
    ek.b onTerminated;

    public f() {
        super(d.e);
        this.active = true;
        ek.d dVar = ek.e.f4970a;
        this.onStart = dVar;
        this.onAdded = dVar;
        this.onTerminated = dVar;
        this.nl = fk.d.f5057a;
    }

    public boolean add(e eVar) {
        d dVar;
        e[] eVarArr;
        do {
            dVar = (d) get();
            if (dVar.f8922a) {
                this.onTerminated.mo0call(eVar);
                return false;
            }
            e[] eVarArr2 = dVar.f8923b;
            int length = eVarArr2.length;
            eVarArr = new e[length + 1];
            System.arraycopy(eVarArr2, 0, eVarArr, 0, length);
            eVarArr[length] = eVar;
        } while (!compareAndSet(dVar, new d(dVar.f8922a, eVarArr)));
        this.onAdded.mo0call(eVar);
        return true;
    }

    public void addUnsubscriber(i iVar, e eVar) {
        iVar.f1736a.a(new qk.a(new hk.c(3, this, eVar)));
    }

    public Object getLatest() {
        return this.latest;
    }

    public e[] next(Object obj) {
        setLatest(obj);
        return ((d) get()).f8923b;
    }

    public e[] observers() {
        return ((d) get()).f8923b;
    }

    public void remove(e eVar) {
        d dVar;
        d dVar2;
        do {
            dVar = (d) get();
            if (dVar.f8922a) {
                return;
            }
            e[] eVarArr = dVar.f8923b;
            int length = eVarArr.length;
            dVar2 = d.e;
            if (length != 1 || eVarArr[0] != eVar) {
                if (length != 0) {
                    int i8 = length - 1;
                    e[] eVarArr2 = new e[i8];
                    int i9 = 0;
                    int i10 = 0;
                    while (true) {
                        if (i9 >= length) {
                            if (i10 == 0) {
                                break;
                            }
                            if (i10 < i8) {
                                e[] eVarArr3 = new e[i10];
                                System.arraycopy(eVarArr2, 0, eVarArr3, 0, i10);
                                eVarArr2 = eVarArr3;
                            }
                            dVar2 = new d(dVar.f8922a, eVarArr2);
                            break;
                        }
                        e eVar2 = eVarArr[i9];
                        if (eVar2 != eVar) {
                            if (i10 == i8) {
                                dVar2 = dVar;
                                break;
                            } else {
                                eVarArr2[i10] = eVar2;
                                i10++;
                            }
                        }
                        i9++;
                    }
                } else {
                    dVar2 = dVar;
                    break;
                }
            }
            if (dVar2 == dVar) {
                return;
            }
        } while (!compareAndSet(dVar, dVar2));
    }

    public void setLatest(Object obj) {
        this.latest = obj;
    }

    public e[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        return ((d) get()).f8922a ? d.f8920c : ((d) getAndSet(d.f8921d)).f8923b;
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call, reason: merged with bridge method [inline-methods] */
    public void mo0call(i iVar) {
        e eVar = new e(iVar);
        addUnsubscriber(iVar, eVar);
        this.onStart.mo0call(eVar);
        if (!iVar.f1736a.f5909b && add(eVar) && iVar.f1736a.f5909b) {
            remove(eVar);
        }
    }
}
