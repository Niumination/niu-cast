package u9;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f16213c = 1.4f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f16214d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.a f16215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d7.a f16216b;

    /* JADX INFO: renamed from: u9.a$a, reason: collision with other inner class name */
    public enum EnumC0431a {
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
        int[] iArr = new int[EnumC0431a.values().length];
        f16214d = iArr;
        EnumC0431a enumC0431a = EnumC0431a.TOP_LEFT;
        iArr[enumC0431a.ordinal()] = 1;
        EnumC0431a enumC0431a2 = EnumC0431a.TOP_RIGHT;
        iArr[enumC0431a2.ordinal()] = 2;
        EnumC0431a enumC0431a3 = EnumC0431a.BOTTOM_RIGHT;
        iArr[enumC0431a3.ordinal()] = 4;
        EnumC0431a enumC0431a4 = EnumC0431a.BOTTOM_LEFT;
        iArr[enumC0431a4.ordinal()] = 8;
        iArr[EnumC0431a.LEFT.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a4.ordinal()];
        iArr[EnumC0431a.TOP.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a2.ordinal()];
        iArr[EnumC0431a.RIGHT.ordinal()] = iArr[enumC0431a2.ordinal()] | iArr[enumC0431a3.ordinal()];
        iArr[EnumC0431a.BOTTOM.ordinal()] = iArr[enumC0431a4.ordinal()] | iArr[enumC0431a3.ordinal()];
        iArr[EnumC0431a.ALL.ordinal()] = iArr[enumC0431a.ordinal()] | iArr[enumC0431a2.ordinal()] | iArr[enumC0431a4.ordinal()] | iArr[enumC0431a3.ordinal()];
    }

    public boolean a(Canvas canvas, float f10, float f11, float f12, float f13, float f14, EnumC0431a enumC0431a) {
        if (canvas == null) {
            throw new IllegalArgumentException("Illegal parameters canvas == null");
        }
        return d(fc.b.a.G).b(canvas, f10, f11, f12, f13, f14 * 1.4f, f16214d[enumC0431a.ordinal()]);
    }

    public void b(Canvas canvas, float f10, float f11, float f12, float f13, float f14, Paint paint) {
        if (canvas == null) {
            throw new IllegalArgumentException("Illegal parameters canvas == null");
        }
        d(fc.b.a.F).c(canvas, f10, f11, f12, f13, f14 * 1.4f, paint);
    }

    public void c(Canvas canvas, float f10, float f11, float f12, float f13, float f14, EnumC0431a enumC0431a, Paint paint) {
        if (canvas == null) {
            throw new IllegalArgumentException("Illegal parameters canvas == null");
        }
        d(fc.b.a.G).d(canvas, f10, f11, f12, f13, f14 * 1.4f, f16214d[enumC0431a.ordinal()], paint);
    }

    public of.a d(String str) {
        if (fc.b.b(str)) {
            vc.a aVar = this.f16215a;
            if (aVar != null) {
                return aVar;
            }
            vc.a aVar2 = new vc.a();
            this.f16215a = aVar2;
            return aVar2;
        }
        d7.a aVar3 = this.f16216b;
        if (aVar3 != null) {
            return aVar3;
        }
        d7.a aVar4 = new d7.a();
        this.f16216b = aVar4;
        return aVar4;
    }

    public boolean e() {
        return d(fc.b.a.G).a();
    }
}
