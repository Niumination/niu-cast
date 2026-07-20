package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import ln.a;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Rect>, a {
        private boolean hasMore;

        @l
        private final RegionIterator iterator;

        @l
        private final Rect rect;

        public AnonymousClass1(Region region) {
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @l
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    @l
    public static final Region and(@l Region region, @l Rect rect) {
        l0.p(region, "<this>");
        l0.p(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@l Region region, @l Point point) {
        l0.p(region, "<this>");
        l0.p(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final void forEach(@l Region region, @l jn.l<? super Rect, l2> lVar) {
        l0.p(region, "<this>");
        l0.p(lVar, f.f8937e);
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                lVar.invoke(rect);
            }
        }
    }

    @l
    public static final Iterator<Rect> iterator(@l Region region) {
        l0.p(region, "<this>");
        return new AnonymousClass1(region);
    }

    @l
    public static final Region minus(@l Region region, @l Rect rect) {
        l0.p(region, "<this>");
        l0.p(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @l
    public static final Region not(@l Region region) {
        l0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @l
    public static final Region or(@l Region region, @l Rect rect) {
        l0.p(region, "<this>");
        l0.p(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @l
    public static final Region plus(@l Region region, @l Rect rect) {
        l0.p(region, "<this>");
        l0.p(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @l
    public static final Region unaryMinus(@l Region region) {
        l0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @l
    public static final Region xor(@l Region region, @l Rect rect) {
        l0.p(region, "<this>");
        l0.p(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @l
    public static final Region and(@l Region region, @l Region region2) {
        l0.p(region, "<this>");
        l0.p(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @l
    public static final Region minus(@l Region region, @l Region region2) {
        l0.p(region, "<this>");
        l0.p(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @l
    public static final Region or(@l Region region, @l Region region2) {
        l0.p(region, "<this>");
        l0.p(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @l
    public static final Region plus(@l Region region, @l Region region2) {
        l0.p(region, "<this>");
        l0.p(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @l
    public static final Region xor(@l Region region, @l Region region2) {
        l0.p(region, "<this>");
        l0.p(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
