package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@l Point point) {
        l0.p(point, "<this>");
        return point.x;
    }

    public static final int component2(@l Point point) {
        l0.p(point, "<this>");
        return point.y;
    }

    @l
    public static final Point div(@l Point point, float f10) {
        l0.p(point, "<this>");
        return new Point(Math.round(point.x / f10), Math.round(point.y / f10));
    }

    @l
    public static final Point minus(@l Point point, @l Point point2) {
        l0.p(point, "<this>");
        l0.p(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @l
    public static final Point plus(@l Point point, @l Point point2) {
        l0.p(point, "<this>");
        l0.p(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @l
    public static final Point times(@l Point point, float f10) {
        l0.p(point, "<this>");
        return new Point(Math.round(point.x * f10), Math.round(point.y * f10));
    }

    @l
    public static final Point toPoint(@l PointF pointF) {
        l0.p(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @l
    public static final PointF toPointF(@l Point point) {
        l0.p(point, "<this>");
        return new PointF(point);
    }

    @l
    public static final Point unaryMinus(@l Point point) {
        l0.p(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@l PointF pointF) {
        l0.p(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(@l PointF pointF) {
        l0.p(pointF, "<this>");
        return pointF.y;
    }

    @l
    public static final PointF div(@l PointF pointF, float f10) {
        l0.p(pointF, "<this>");
        return new PointF(pointF.x / f10, pointF.y / f10);
    }

    @l
    public static final PointF times(@l PointF pointF, float f10) {
        l0.p(pointF, "<this>");
        return new PointF(pointF.x * f10, pointF.y * f10);
    }

    @l
    public static final PointF unaryMinus(@l PointF pointF) {
        l0.p(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    @l
    public static final PointF minus(@l PointF pointF, @l PointF pointF2) {
        l0.p(pointF, "<this>");
        l0.p(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @l
    public static final PointF plus(@l PointF pointF, @l PointF pointF2) {
        l0.p(pointF, "<this>");
        l0.p(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @l
    public static final Point minus(@l Point point, int i10) {
        l0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i11 = -i10;
        point2.offset(i11, i11);
        return point2;
    }

    @l
    public static final Point plus(@l Point point, int i10) {
        l0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i10, i10);
        return point2;
    }

    @l
    public static final PointF minus(@l PointF pointF, float f10) {
        l0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f11 = -f10;
        pointF2.offset(f11, f11);
        return pointF2;
    }

    @l
    public static final PointF plus(@l PointF pointF, float f10) {
        l0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f10, f10);
        return pointF2;
    }
}
