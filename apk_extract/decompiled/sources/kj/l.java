package kj;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends gj.a {
    public final /* synthetic */ a0 e;
    public final /* synthetic */ n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List f6925g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, a0 a0Var, n nVar, List list) {
        super(str, true);
        this.e = a0Var;
        this.f = nVar;
        this.f6925g = list;
    }

    @Override // gj.a
    public final long a() {
        try {
            this.f.f6928b.f6936a.b(this.e);
            return -1L;
        } catch (IOException e) {
            lj.m mVar = lj.m.f7532a;
            lj.m mVar2 = lj.m.f7532a;
            String str = "Http2Connection.Listener failure for " + this.f.f6928b.f6938c;
            mVar2.getClass();
            lj.m.f(str, 4, e);
            try {
                this.e.c(c.PROTOCOL_ERROR, e);
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }
}
