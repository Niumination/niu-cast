package p001if;

import k3.v8;
import ze.i;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f5820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f5821c;

    public k(m mVar, i iVar, int i8) {
        this.f5819a = i8;
        switch (i8) {
            case 1:
                v8.c("success rate ejection config is null", mVar.e != null);
                this.f5820b = mVar;
                this.f5821c = iVar;
                break;
            default:
                this.f5820b = mVar;
                this.f5821c = iVar;
                break;
        }
    }
}
