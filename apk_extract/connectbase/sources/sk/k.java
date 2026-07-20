package sk;

import lm.l2;
import sk.e0;
import sk.k;

/* JADX INFO: loaded from: classes2.dex */
public interface k<T extends k<? extends T, Options>, Options extends e0> {

    public static final class a {
        @os.l
        public static <T extends k<? extends T, Options>, Options extends e0> T a(@os.l k<? extends T, Options> kVar, @os.l jn.l<? super Options, l2> lVar) {
            kn.l0.p(kVar, "this");
            kn.l0.p(lVar, "block");
            e0 e0VarB = kVar.getOptions().b();
            lVar.invoke(e0VarB);
            kVar.b(e0VarB);
            return kVar;
        }
    }

    @os.l
    T a(@os.l jn.l<? super Options, l2> lVar);

    void b(@os.l Options options);

    @os.l
    Options getOptions();
}
