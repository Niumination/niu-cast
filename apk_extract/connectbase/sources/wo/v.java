package wo;

import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public interface v {

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f19825a = new a();

        @Override // wo.v
        @os.l
        public List<String> a(@os.l String str) {
            l0.p(str, "packageFqName");
            return k0.INSTANCE;
        }
    }

    @os.l
    List<String> a(@os.l String str);
}
