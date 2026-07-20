package ok;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.l2;
import nm.d0;
import nm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    public static final class a extends n0 implements jn.a<e> {
        final /* synthetic */ jn.l<f, l2> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super f, l2> lVar) {
            super(0);
            this.$block = lVar;
        }

        @Override // jn.a
        @os.l
        public final e invoke() {
            f fVar = new f();
            this.$block.invoke(fVar);
            return o.g(fVar.a());
        }
    }

    @os.l
    public static final e a(@os.l String str) {
        l0.p(str, "value");
        return new ok.a(str);
    }

    @os.l
    public static final e b(@os.l e eVar) {
        l0.p(eVar, "grammar");
        return new b(eVar);
    }

    public static final <T extends c> List<e> c(List<? extends e> list) {
        l0.p(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            l0.P();
            if (obj instanceof c) {
                d0.r0(arrayList, ((c) obj).a());
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @os.l
    public static final e d(@os.l e eVar) {
        l0.p(eVar, "grammar");
        return new h(eVar);
    }

    @os.l
    public static final jn.a<e> e(@os.l jn.l<? super f, l2> lVar) {
        l0.p(lVar, "block");
        return new a(lVar);
    }

    @os.l
    public static final e f(@os.l String str) {
        l0.p(str, "value");
        return new i(new u(str));
    }

    @os.l
    public static final e g(@os.l e eVar) {
        l0.p(eVar, "grammar");
        return new i(eVar);
    }

    @os.l
    public static final e h(@os.l e eVar, @os.l String str) {
        l0.p(eVar, "<this>");
        l0.p(str, "name");
        return new j(str, eVar);
    }

    @os.l
    public static final e i(@os.l String str, @os.l e eVar) {
        l0.p(str, "<this>");
        l0.p(eVar, "grammar");
        return k(new u(str), eVar);
    }

    @os.l
    public static final e j(@os.l e eVar, @os.l String str) {
        l0.p(eVar, "<this>");
        l0.p(str, "value");
        return k(eVar, new u(str));
    }

    @os.l
    public static final e k(@os.l e eVar, @os.l e eVar2) {
        l0.p(eVar, "<this>");
        l0.p(eVar2, "grammar");
        return new k(y.O(eVar, eVar2));
    }

    @os.l
    public static final e l(@os.l String str, @os.l e eVar) {
        l0.p(str, "<this>");
        l0.p(eVar, "grammar");
        return n(new u(str), eVar);
    }

    @os.l
    public static final e m(@os.l e eVar, @os.l String str) {
        l0.p(eVar, "<this>");
        l0.p(str, "value");
        return n(eVar, new u(str));
    }

    @os.l
    public static final e n(@os.l e eVar, @os.l e eVar2) {
        l0.p(eVar, "<this>");
        l0.p(eVar2, "grammar");
        return new s(y.O(eVar, eVar2));
    }

    @os.l
    public static final e o(char c10, char c11) {
        return new q(c10, c11);
    }
}
