package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import b.a;
import kn.l0;
import kn.r1;
import os.l;
import p6.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class RectKt {
    @a({"CheckResult"})
    @l
    public static final Rect and(@l Rect rect, @l Rect rect2) {
        l0.p(rect, "<this>");
        l0.p(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@l Rect rect) {
        l0.p(rect, "<this>");
        return rect.left;
    }

    public static final int component2(@l Rect rect) {
        l0.p(rect, "<this>");
        return rect.top;
    }

    public static final int component3(@l Rect rect) {
        l0.p(rect, "<this>");
        return rect.right;
    }

    public static final int component4(@l Rect rect) {
        l0.p(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(@l Rect rect, @l Point point) {
        l0.p(rect, "<this>");
        l0.p(point, "p");
        return rect.contains(point.x, point.y);
    }

    @l
    public static final Region minus(@l Rect rect, @l Rect rect2) {
        l0.p(rect, "<this>");
        l0.p(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @l
    public static final Rect or(@l Rect rect, @l Rect rect2) {
        l0.p(rect, "<this>");
        l0.p(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @l
    public static final Rect plus(@l Rect rect, @l Rect rect2) {
        l0.p(rect, "<this>");
        l0.p(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @l
    public static final Rect times(@l Rect rect, int i10) {
        l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i10;
        rect2.left *= i10;
        rect2.right *= i10;
        rect2.bottom *= i10;
        return rect2;
    }

    @l
    public static final Rect toRect(@l RectF rectF) {
        l0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @l
    public static final RectF toRectF(@l Rect rect) {
        l0.p(rect, "<this>");
        return new RectF(rect);
    }

    @l
    public static final Region toRegion(@l Rect rect) {
        l0.p(rect, "<this>");
        return new Region(rect);
    }

    @l
    public static final RectF transform(@l RectF rectF, @l Matrix matrix) {
        l0.p(rectF, "<this>");
        l0.p(matrix, m.f13003a);
        matrix.mapRect(rectF);
        return rectF;
    }

    @l
    public static final Region xor(@l Rect rect, @l Rect rect2) {
        l0.p(rect, "<this>");
        l0.p(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@l RectF rectF) {
        l0.p(rectF, "<this>");
        return rectF.left;
    }

    public static final float component2(@l RectF rectF) {
        l0.p(rectF, "<this>");
        return rectF.top;
    }

    public static final float component3(@l RectF rectF) {
        l0.p(rectF, "<this>");
        return rectF.right;
    }

    public static final float component4(@l RectF rectF) {
        l0.p(rectF, "<this>");
        return rectF.bottom;
    }

    public static final boolean contains(@l RectF rectF, @l PointF pointF) {
        l0.p(rectF, "<this>");
        l0.p(pointF, "p");
        return rectF.contains(pointF.x, pointF.y);
    }

    @l
    public static final Region toRegion(@l RectF rectF) {
        l0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @a({"CheckResult"})
    @l
    public static final RectF and(@l RectF rectF, @l RectF rectF2) {
        l0.p(rectF, "<this>");
        l0.p(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @l
    public static final Region minus(@l RectF rectF, @l RectF rectF2) {
        l0.p(rectF, "<this>");
        l0.p(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @l
    public static final RectF or(@l RectF rectF, @l RectF rectF2) {
        l0.p(rectF, "<this>");
        l0.p(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @l
    public static final RectF plus(@l RectF rectF, @l RectF rectF2) {
        l0.p(rectF, "<this>");
        l0.p(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @l
    public static final Region xor(@l RectF rectF, @l RectF rectF2) {
        l0.p(rectF, "<this>");
        l0.p(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @l
    public static final Rect plus(@l Rect rect, int i10) {
        l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i10, i10);
        return rect2;
    }

    @l
    public static final RectF times(@l RectF rectF, float f10) {
        l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @l
    public static final RectF plus(@l RectF rectF, float f10) {
        l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f10, f10);
        return rectF2;
    }

    @l
    public static final Rect plus(@l Rect rect, @l Point point) {
        l0.p(rect, "<this>");
        l0.p(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @l
    public static final Rect minus(@l Rect rect, int i10) {
        l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i11 = -i10;
        rect2.offset(i11, i11);
        return rect2;
    }

    @l
    public static final RectF plus(@l RectF rectF, @l PointF pointF) {
        l0.p(rectF, "<this>");
        l0.p(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @l
    public static final RectF times(@l RectF rectF, int i10) {
        l0.p(rectF, "<this>");
        float f10 = i10;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @l
    public static final RectF minus(@l RectF rectF, float f10) {
        l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f11 = -f10;
        rectF2.offset(f11, f11);
        return rectF2;
    }

    @l
    public static final Rect minus(@l Rect rect, @l Point point) {
        l0.p(rect, "<this>");
        l0.p(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @l
    public static final RectF minus(@l RectF rectF, @l PointF pointF) {
        l0.p(rectF, "<this>");
        l0.p(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
