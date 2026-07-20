package ic;

import android.app.TaskInfo;
import com.transsion.hubsdk.app.TranTaskInfo;

/* JADX INFO: loaded from: classes2.dex */
public class o1 implements bf.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranTaskInfo f7868a = new TranTaskInfo();

    @Override // bf.p
    public int a(TaskInfo taskInfo) {
        TranTaskInfo tranTaskInfo = this.f7868a;
        if (tranTaskInfo != null) {
            return tranTaskInfo.getDisplayId(taskInfo);
        }
        return 0;
    }

    @Override // bf.p
    public boolean b(TaskInfo taskInfo) {
        TranTaskInfo tranTaskInfo = this.f7868a;
        if (tranTaskInfo != null) {
            return tranTaskInfo.getSupportsMultiWindow(taskInfo);
        }
        return false;
    }

    @Override // bf.p
    public int c(TaskInfo taskInfo) {
        TranTaskInfo tranTaskInfo = this.f7868a;
        if (tranTaskInfo != null) {
            return tranTaskInfo.getUserId(taskInfo);
        }
        return 0;
    }
}
