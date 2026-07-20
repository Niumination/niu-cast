package re;

import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import com.transsion.hubsdk.view.TranDragAndDropPermissions;

/* JADX INFO: loaded from: classes2.dex */
public class e implements lh.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranDragAndDropPermissions f14468a;

    @Override // lh.d
    public boolean a(DragAndDropPermissions dragAndDropPermissions) {
        return c().takeTransient(dragAndDropPermissions);
    }

    @Override // lh.d
    public DragAndDropPermissions b(DragEvent dragEvent) {
        return c().obtain(dragEvent);
    }

    public final TranDragAndDropPermissions c() {
        if (this.f14468a == null) {
            this.f14468a = new TranDragAndDropPermissions();
        }
        return this.f14468a;
    }
}
