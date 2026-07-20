package al;

import java.net.BindException;
import java.util.concurrent.TimeUnit;
import kn.l0;
import kn.n0;
import lm.l2;
import yk.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final d f331a = new d();

    public static final class a extends n0 implements jn.a<l2> {
        final /* synthetic */ l $engine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(0);
            this.$engine = lVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            yk.g.a(this.$engine, 3L, 5L, TimeUnit.SECONDS);
        }
    }

    public static final class b extends n0 implements jn.l<l.c, l2> {
        final /* synthetic */ yk.b $applicationEnvironment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yk.b bVar) {
            super(1);
            this.$applicationEnvironment = bVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(l.c cVar) {
            invoke2(cVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l l.c cVar) {
            l0.p(cVar, "$this$$receiver");
            d.f331a.b(cVar, this.$applicationEnvironment.b());
        }
    }

    @in.n
    public static final void c(@os.l String[] strArr) throws InterruptedException, BindException {
        l0.p(strArr, d6.a.F);
        yk.b bVarA = yk.p.a(strArr);
        l lVar = new l(bVarA, new b(bVarA));
        j0.a(lVar, new a(lVar));
        lVar.b(true);
    }

    public final void b(l.c cVar, ek.a aVar) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        ek.a aVarB = aVar.b("ktor.deployment");
        yk.p.b(cVar, aVarB);
        ek.b bVarC = aVarB.c("requestQueueLimit");
        if (bVarC != null && (string6 = bVarC.getString()) != null) {
            cVar.f358e = Integer.parseInt(string6);
        }
        ek.b bVarC2 = aVarB.c("runningLimit");
        if (bVarC2 != null && (string5 = bVarC2.getString()) != null) {
            cVar.f359f = Integer.parseInt(string5);
        }
        ek.b bVarC3 = aVarB.c("shareWorkGroup");
        if (bVarC3 != null && (string4 = bVarC3.getString()) != null) {
            cVar.f360g = Boolean.parseBoolean(string4);
        }
        ek.b bVarC4 = aVarB.c("responseWriteTimeoutSeconds");
        if (bVarC4 != null && (string3 = bVarC4.getString()) != null) {
            cVar.f362i = Integer.parseInt(string3);
        }
        ek.b bVarC5 = aVarB.c("requestReadTimeoutSeconds");
        if (bVarC5 != null && (string2 = bVarC5.getString()) != null) {
            cVar.f363j = Integer.parseInt(string2);
        }
        ek.b bVarC6 = aVarB.c("tcpKeepAlive");
        if (bVarC6 == null || (string = bVarC6.getString()) == null) {
            return;
        }
        cVar.f364k = Boolean.parseBoolean(string);
    }
}
