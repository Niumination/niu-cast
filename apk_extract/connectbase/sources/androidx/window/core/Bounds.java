package androidx.window.core;

import android.graphics.Rect;
import c.a;
import io.netty.util.internal.StringUtil;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class Bounds {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public Bounds(int i10, int i11, int i12, int i13) {
        this.left = i10;
        this.top = i11;
        this.right = i12;
        this.bottom = i13;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l0.g(Bounds.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        Bounds bounds = (Bounds) obj;
        return this.left == bounds.left && this.top == bounds.top && this.right == bounds.right && this.bottom == bounds.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final boolean isEmpty() {
        return getHeight() == 0 || getWidth() == 0;
    }

    public final boolean isZero() {
        return getHeight() == 0 && getWidth() == 0;
    }

    @l
    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Bounds { [");
        sb2.append(this.left);
        sb2.append(StringUtil.COMMA);
        sb2.append(this.top);
        sb2.append(StringUtil.COMMA);
        sb2.append(this.right);
        sb2.append(StringUtil.COMMA);
        return a.a(sb2, this.bottom, "] }");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(@l Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        l0.p(rect, "rect");
    }
}
