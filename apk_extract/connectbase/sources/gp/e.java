package gp;

import java.util.ArrayList;
import java.util.Set;
import kn.w;
import nm.h0;
import nm.r;

/* JADX INFO: loaded from: classes3.dex */
public enum e {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    @in.f
    @os.l
    public static final Set<e> ALL;

    @in.f
    @os.l
    public static final Set<e> ALL_EXCEPT_ANNOTATIONS;

    @os.l
    public static final a Companion = new a();
    private final boolean includeByDefault;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    static {
        int i10 = 0;
        e[] eVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        int length = eVarArrValues.length;
        while (i10 < length) {
            e eVar = eVarArrValues[i10];
            i10++;
            if (eVar.getIncludeByDefault()) {
                arrayList.add(eVar);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = h0.a6(arrayList);
        ALL = r.mz(values());
    }

    e(boolean z10) {
        this.includeByDefault = z10;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
