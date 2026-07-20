package ik;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    public static final class a extends kn.n0 implements jn.l<vk.h, l2> {
        final /* synthetic */ String $encodedPath;
        final /* synthetic */ b1 $parameters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, b1 b1Var) {
            super(1);
            this.$encodedPath = str;
            this.$parameters = b1Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(vk.h hVar) {
            invoke2(hVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l vk.h hVar) {
            kn.l0.p(hVar, "$this$push");
            hVar.a().o(this.$encodedPath);
            hVar.a().f8127g.g();
            hVar.a().f8127g.b(this.$parameters);
        }
    }

    @vk.j
    public static final void a(@os.l dk.b bVar, @os.l String str) {
        lm.t0 t0Var;
        kn.l0.p(bVar, "<this>");
        kn.l0.p(str, "pathAndQuery");
        int iP3 = jq.h0.p3(str, "?", 0, false, 6, null);
        if (iP3 == -1) {
            t0Var = new lm.t0(str, "");
        } else {
            String strSubstring = str.substring(0, iP3);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = str.substring(iP3 + 1);
            kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            t0Var = new lm.t0(strSubstring, strSubstring2);
        }
        b(bVar, (String) t0Var.component1(), h1.d((String) t0Var.component2(), 0, 0, 6, null));
    }

    @vk.j
    public static final void b(@os.l dk.b bVar, @os.l String str, @os.l b1 b1Var) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(str, "encodedPath");
        kn.l0.p(b1Var, "parameters");
        c(bVar, new a(str, b1Var));
    }

    @vk.j
    public static final void c(@os.l dk.b bVar, @os.l jn.l<? super vk.h, l2> lVar) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(lVar, "block");
        vk.a aVarE = bVar.e();
        vk.e eVar = new vk.e(bVar);
        lVar.invoke(eVar);
        aVarE.d(eVar);
    }
}
