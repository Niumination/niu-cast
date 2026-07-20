package p6;

import android.app.TaskInfo;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class t implements bf.p {
    @Override // bf.p
    public int a(TaskInfo taskInfo) {
        Integer num;
        Field fieldD = cc.a.d(TaskInfo.class, "displayId");
        if (fieldD == null || (num = (Integer) cc.a.f(fieldD, taskInfo)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // bf.p
    public boolean b(TaskInfo taskInfo) {
        Field fieldD = cc.a.d(TaskInfo.class, "supportsMultiWindow");
        if (fieldD != null) {
            return ((Boolean) cc.a.f(fieldD, taskInfo)).booleanValue();
        }
        return false;
    }

    @Override // bf.p
    public int c(TaskInfo taskInfo) {
        Field fieldD = cc.a.d(TaskInfo.class, "userId");
        if (fieldD != null) {
            return ((Integer) cc.a.f(fieldD, taskInfo)).intValue();
        }
        return 0;
    }
}
