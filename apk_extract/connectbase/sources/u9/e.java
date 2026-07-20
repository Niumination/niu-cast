package u9;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f16226c = 1.4f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f16227d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.e f16228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d7.d f16229b;

    public enum a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        ALL
    }

    static {
        int[] iArr = new int[u9.a.EnumC0431a.values().length];
        f16227d = iArr;
        u9.a.EnumC0431a enumC0431a = u9.a.EnumC0431a.TOP_LEFT;
        iArr[enumC0431a.ordinal()] = 1;
        u9.a.EnumC0431a enumC0431a2 = u9.a.EnumC0431a.TOP_RIGHT;
        iArr[enumC0431a2.ordinal()] = 2;
        u9.a.EnumC0431a enumC0431a3 = u9.a.EnumC0431a.BOTTOM_RIGHT;
        iArr[enumC0431a3.ordinal()] = 4;
        u9.a.EnumC0431a enumC0431a4 = u9.a.EnumC0431a.BOTTOM_LEFT;
        iArr[enumC0431a4.ordinal()] = 8;
        iArr[u9.a.EnumC0431a.LEFT.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a4.ordinal()];
        iArr[u9.a.EnumC0431a.TOP.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a2.ordinal()];
        iArr[u9.a.EnumC0431a.RIGHT.ordinal()] = iArr[enumC0431a2.ordinal()] | iArr[enumC0431a3.ordinal()];
        iArr[u9.a.EnumC0431a.BOTTOM.ordinal()] = iArr[enumC0431a4.ordinal()] | iArr[enumC0431a3.ordinal()];
        iArr[u9.a.EnumC0431a.ALL.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a2.ordinal()] | iArr[enumC0431a4.ordinal()] | iArr[enumC0431a3.ordinal()];
    }

    public of.d a(String str) {
        if (fc.b.b(str)) {
            vc.e eVar = this.f16228a;
            if (eVar != null) {
                return eVar;
            }
            vc.e eVar2 = new vc.e();
            this.f16228a = eVar2;
            return eVar2;
        }
        d7.d dVar = this.f16229b;
        if (dVar != null) {
            return dVar;
        }
        d7.d dVar2 = new d7.d();
        this.f16229b = dVar2;
        return dVar2;
    }

    public void b(Outline outline, int i10, int i11, int i12, int i13, float f10, a aVar) {
        if (outline == null) {
            throw new IllegalArgumentException("Illegal parameters outline == null");
        }
        a(fc.b.a.G).b(outline, i10, i11, i12, i13, f10 * 1.4f, f16227d[aVar.ordinal()]);
    }

    public boolean c() {
        return a(fc.b.a.G).a();
    }
}
