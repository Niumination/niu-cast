package yn;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public interface d<M extends Member> {

    public static final class a {
        public static <M extends Member> void a(@l d<? extends M> dVar, @l Object[] objArr) {
            l0.p(dVar, "this");
            l0.p(objArr, d6.a.F);
            if (f.a(dVar) == objArr.length) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("Callable expects ");
            sb2.append(f.a(dVar));
            sb2.append(" arguments, but ");
            throw new IllegalArgumentException(c.a.a(sb2, objArr.length, " were provided."));
        }
    }

    @l
    List<Type> a();

    M b();

    @m
    Object call(@l Object[] objArr);

    @l
    Type getReturnType();
}
