package mo;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final a f10855a = new a();

        @Override // mo.c
        public boolean a() {
            return false;
        }

        @Override // mo.c
        public void b(@l String str, @l e eVar, @l String str2, @l f fVar, @l String str3) {
            l0.p(str, "filePath");
            l0.p(eVar, "position");
            l0.p(str2, "scopeFqName");
            l0.p(fVar, "scopeKind");
            l0.p(str3, "name");
        }
    }

    boolean a();

    void b(@l String str, @l e eVar, @l String str2, @l f fVar, @l String str3);
}
