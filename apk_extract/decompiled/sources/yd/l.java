package yd;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f11158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f11159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11160d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11162h;

    public int getAdapterPosition() {
        ArrayList arrayList = this.f11158b;
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public Context getContext() {
        return this.f11159c;
    }

    public int getHiosCircleRadius() {
        return this.f11162h;
    }

    public float getHiosSpaceRatio() {
        if (this.f11158b.size() <= 0) {
            return 0.0f;
        }
        return ((this.e + this.f) * 2.0f) / getMenuTotalWidth();
    }

    public int getMenuItemPadding() {
        return this.f;
    }

    public List<o> getMenuItems() {
        return this.f11158b;
    }

    public int getMenuPadding() {
        return this.e;
    }

    public int getMenuTotalWidth() {
        boolean z2 = this.f11160d;
        ArrayList arrayList = this.f11158b;
        if (z2 && this.f11161g) {
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
        } else if (arrayList.size() > 0) {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
        return 0;
    }

    public int getOrientation() {
        return this.f11157a;
    }

    public void setContext(Context context) {
        this.f11159c = context;
    }

    public void setIsMenuImageType(boolean z2) {
        this.f11161g = z2;
    }

    public void setOrientation(int i8) {
        this.f11157a = i8;
    }
}
