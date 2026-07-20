package rb;

import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14382c = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.e f14383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.d f14384b;

    public lh.d a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14382c, "TranThubDragAndDropPermissions");
            re.e eVar = this.f14383a;
            if (eVar != null) {
                return eVar;
            }
            re.e eVar2 = new re.e();
            this.f14383a = eVar2;
            return eVar2;
        }
        dc.e.f(f14382c, "TranAospDragAndDropPermissions");
        b9.d dVar = this.f14384b;
        if (dVar != null) {
            return dVar;
        }
        b9.d dVar2 = new b9.d();
        this.f14384b = dVar2;
        return dVar2;
    }

    public DragAndDropPermissions b(DragEvent dragEvent) {
        if (dragEvent != null) {
            return a(fc.b.a.f6001u).b(dragEvent);
        }
        throw new IllegalArgumentException("DragEvent is null");
    }

    public boolean c(DragAndDropPermissions dragAndDropPermissions) {
        if (dragAndDropPermissions != null) {
            return a(fc.b.a.f6001u).a(dragAndDropPermissions);
        }
        throw new IllegalArgumentException("DragAndDropPermissions is null");
    }
}
