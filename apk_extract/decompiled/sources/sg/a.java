package sg;

import cg.i;
import java.io.InputStream;
import jh.o;
import k3.mb;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10098b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f10097a = i8;
        this.f10098b = obj;
    }

    @Override // cg.i
    public final o e() {
        switch (this.f10097a) {
            case 0:
                return mb.a((InputStream) this.f10098b);
            default:
                return (o) this.f10098b;
        }
    }
}
