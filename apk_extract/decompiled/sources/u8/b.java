package u8;

import android.graphics.Canvas;
import se.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f10413c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o9.a f10414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f10415b;

    static {
        int[] iArr = new int[a.values().length];
        f10413c = iArr;
        a aVar = a.TOP_LEFT;
        iArr[aVar.ordinal()] = 1;
        a aVar2 = a.TOP_RIGHT;
        iArr[aVar2.ordinal()] = 2;
        a aVar3 = a.BOTTOM_RIGHT;
        iArr[aVar3.ordinal()] = 4;
        a aVar4 = a.BOTTOM_LEFT;
        iArr[aVar4.ordinal()] = 8;
        iArr[a.LEFT.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar4.ordinal()];
        iArr[a.TOP.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar2.ordinal()];
        iArr[a.RIGHT.ordinal()] = iArr[aVar2.ordinal()] | iArr[aVar3.ordinal()];
        iArr[a.BOTTOM.ordinal()] = iArr[aVar4.ordinal()] | iArr[aVar3.ordinal()];
        iArr[a.ALL.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar2.ordinal()] | iArr[aVar4.ordinal()] | iArr[aVar3.ordinal()];
    }

    public final void a(Canvas canvas, float f, float f4, float f10, a aVar) {
        if (canvas == null) {
            throw new IllegalArgumentException("Illegal parameters canvas == null");
        }
        b(l9.a.f7350k).a(canvas, f, f4, f10 * 1.4f, f10413c[aVar.ordinal()]);
    }

    public final z9.a b(String str) {
        if (l9.b.a(str)) {
            o9.a aVar = this.f10414a;
            if (aVar != null) {
                return aVar;
            }
            o9.a aVar2 = new o9.a();
            this.f10414a = aVar2;
            return aVar2;
        }
        h hVar = this.f10415b;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        this.f10415b = hVar2;
        return hVar2;
    }
}
