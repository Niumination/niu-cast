package hj;

import dj.b0;
import dj.j0;
import dj.v;
import dj.w;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5416a = new a();

    @Override // dj.w
    public final j0 intercept(v chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        ij.f chain2 = (ij.f) chain;
        i iVar = chain2.f5878b;
        iVar.getClass();
        Intrinsics.checkNotNullParameter(chain2, "chain");
        synchronized (iVar) {
            if (!iVar.f5451l) {
                throw new IllegalStateException("released");
            }
            if (iVar.f5450k) {
                throw new IllegalStateException("Check failed.");
            }
            if (iVar.f5449j) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        e eVar = iVar.e;
        Intrinsics.checkNotNull(eVar);
        b0 client = iVar.p;
        eVar.getClass();
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain2, "chain");
        try {
            int i8 = chain2.f5881g;
            int i9 = chain2.f5882h;
            int i10 = chain2.f5883i;
            client.getClass();
            dj.m mVar = new dj.m(iVar, eVar, eVar.a(i8, i9, i10, client.f4499h, !Intrinsics.areEqual(chain2.f.f4529c, "GET")).j(client, chain2));
            iVar.f5448i = mVar;
            iVar.f5453n = mVar;
            synchronized (iVar) {
                iVar.f5449j = true;
                iVar.f5450k = true;
            }
            if (iVar.f5452m) {
                throw new IOException("Canceled");
            }
            return ij.f.a(chain2, 0, mVar, null, 61).b(chain2.f);
        } catch (o e) {
            eVar.c(e.getLastConnectException());
            throw e;
        } catch (IOException e4) {
            eVar.c(e4);
            throw new o(e4);
        }
    }
}
