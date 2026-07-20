package fk;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends l {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAgeInMillis;
    final ck.h scheduler;

    public r(int i8, long j8, ck.h hVar) {
        this.scheduler = hVar;
        this.limit = i8;
        this.maxAgeInMillis = j8;
    }

    @Override // fk.l
    public Object enterTransform(Object obj) {
        this.scheduler.getClass();
        return new ok.b(System.currentTimeMillis(), obj);
    }

    @Override // fk.l
    public Object leaveTransform(Object obj) {
        return ((ok.b) obj).f8568b;
    }

    @Override // fk.l
    public void truncate() {
        n nVar;
        this.scheduler.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.maxAgeInMillis;
        n nVar2 = (n) get();
        n nVar3 = (n) nVar2.get();
        int i8 = 0;
        while (true) {
            n nVar4 = nVar3;
            nVar = nVar2;
            nVar2 = nVar4;
            if (nVar2 != null) {
                int i9 = this.size;
                if (i9 <= this.limit) {
                    if (((ok.b) nVar2.value).f8567a > jCurrentTimeMillis) {
                        break;
                    }
                    i8++;
                    this.size = i9 - 1;
                    nVar3 = (n) nVar2.get();
                } else {
                    i8++;
                    this.size = i9 - 1;
                    nVar3 = (n) nVar2.get();
                }
            } else {
                break;
            }
        }
        if (i8 != 0) {
            setFirst(nVar);
        }
    }

    @Override // fk.l
    public void truncateFinal() {
        n nVar;
        int i8;
        this.scheduler.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.maxAgeInMillis;
        n nVar2 = (n) get();
        n nVar3 = (n) nVar2.get();
        int i9 = 0;
        while (true) {
            n nVar4 = nVar3;
            nVar = nVar2;
            nVar2 = nVar4;
            if (nVar2 == null || (i8 = this.size) <= 1 || ((ok.b) nVar2.value).f8567a > jCurrentTimeMillis) {
                break;
            }
            i9++;
            this.size = i8 - 1;
            nVar3 = (n) nVar2.get();
        }
        if (i9 != 0) {
            setFirst(nVar);
        }
    }
}
