package j3;

import java.util.concurrent.Callable;
import k3.be;
import m3.oa;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6084b;

    public /* synthetic */ t(Object obj, int i8) {
        this.f6083a = i8;
        this.f6084b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i8 = this.f6083a;
        Object obj = this.f6084b;
        switch (i8) {
            case 0:
                v vVar = (v) obj;
                vVar.getClass();
                return u2.d.f10329c.a(vVar.f6088a);
            case 1:
                be beVar = (be) obj;
                beVar.getClass();
                return u2.d.f10329c.a(beVar.f6386g);
            default:
                oa oaVar = (oa) obj;
                oaVar.getClass();
                return u2.d.f10329c.a(oaVar.f7825g);
        }
    }
}
