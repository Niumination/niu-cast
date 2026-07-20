package b9;

import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d implements lh.d {
    @Override // lh.d
    public boolean a(DragAndDropPermissions dragAndDropPermissions) {
        Method methodG = cc.a.g(cc.a.a("android.view.DragAndDropPermissions"), "takeTransient", DragAndDropPermissions.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, dragAndDropPermissions, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // lh.d
    public DragAndDropPermissions b(DragEvent dragEvent) {
        Method methodG = cc.a.g(cc.a.a("android.view.DragAndDropPermissions"), "obtain", DragEvent.class);
        if (methodG != null) {
            return (DragAndDropPermissions) cc.a.j(methodG, null, dragEvent);
        }
        return null;
    }
}
