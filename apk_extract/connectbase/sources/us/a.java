package us;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes3.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsListView f16399a;

    public a(AbsListView absListView) {
        this.f16399a = absListView;
    }

    @Override // us.b
    public View a() {
        return this.f16399a;
    }

    @Override // us.b
    public boolean b() {
        if (this.f16399a.getChildCount() > 0) {
            int childCount = this.f16399a.getChildCount();
            int count = this.f16399a.getCount();
            int firstVisiblePosition = this.f16399a.getFirstVisiblePosition() + childCount;
            int bottom = this.f16399a.getChildAt(childCount - 1).getBottom();
            if (firstVisiblePosition >= count && bottom <= this.f16399a.getHeight() - this.f16399a.getListPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    @Override // us.b
    public boolean c() {
        if (this.f16399a.getChildCount() > 0) {
            return this.f16399a.getFirstVisiblePosition() <= 0 && this.f16399a.getChildAt(0).getTop() >= this.f16399a.getListPaddingTop();
        }
        return false;
    }
}
