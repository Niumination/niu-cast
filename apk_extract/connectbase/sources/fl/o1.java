package fl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f6082a = a.f6083a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6083a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final o1 f6084b = new q1(false, null, 3, 0 == true ? 1 : 0);

        public static /* synthetic */ o1 b(a aVar, boolean z10, jn.l lVar, int i10, Object obj) {
            int i11 = i10 & 1;
            int i12 = 0;
            if (i11 != 0) {
                z10 = false;
            }
            kn.l0.p(lVar, "builder");
            p1 p1Var = new p1(z10, i12, 2, null);
            lVar.invoke(p1Var);
            return p1Var.f();
        }

        @os.l
        public final o1 a(boolean z10, @os.l jn.l<? super p1, l2> lVar) {
            kn.l0.p(lVar, "builder");
            p1 p1Var = new p1(z10, 0, 2, null);
            lVar.invoke(p1Var);
            return p1Var.f();
        }

        @os.l
        public final o1 c() {
            return f6084b;
        }
    }

    public static final class b {
        public static boolean a(@os.l o1 o1Var, @os.l String str) {
            kn.l0.p(o1Var, "this");
            kn.l0.p(str, "name");
            return o1Var.b(str) != null;
        }

        public static boolean b(@os.l o1 o1Var, @os.l String str, @os.l String str2) {
            kn.l0.p(o1Var, "this");
            kn.l0.p(str, "name");
            kn.l0.p(str2, "value");
            List<String> listB = o1Var.b(str);
            if (listB == null) {
                return false;
            }
            return listB.contains(str2);
        }

        public static void c(@os.l o1 o1Var, @os.l jn.p<? super String, ? super List<String>, l2> pVar) {
            kn.l0.p(o1Var, "this");
            kn.l0.p(pVar, "body");
            Iterator<T> it = o1Var.entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                pVar.invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }

        @os.m
        public static String d(@os.l o1 o1Var, @os.l String str) {
            kn.l0.p(o1Var, "this");
            kn.l0.p(str, "name");
            List<String> listB = o1Var.b(str);
            if (listB == null) {
                return null;
            }
            return (String) nm.h0.G2(listB);
        }
    }

    boolean a();

    @os.m
    List<String> b(@os.l String str);

    boolean contains(@os.l String str);

    boolean d(@os.l String str, @os.l String str2);

    void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar);

    @os.l
    Set<Map.Entry<String, List<String>>> entries();

    @os.m
    String get(@os.l String str);

    boolean isEmpty();

    @os.l
    Set<String> names();
}
