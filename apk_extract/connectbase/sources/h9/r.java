package h9;

import android.app.TaskInfo;
import ic.o1;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7068c = "r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o1 f7069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.t f7070b;

    public int a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            return b(fc.b.a.A).a(taskInfo);
        }
        throw new NullPointerException("taskInfo is null");
    }

    public bf.p b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7068c, "TranThubTaskInfo");
            o1 o1Var = this.f7069a;
            if (o1Var != null) {
                return o1Var;
            }
            o1 o1Var2 = new o1();
            this.f7069a = o1Var2;
            return o1Var2;
        }
        dc.e.f(f7068c, "TranAospTaskInfo");
        p6.t tVar = this.f7070b;
        if (tVar != null) {
            return tVar;
        }
        p6.t tVar2 = new p6.t();
        this.f7070b = tVar2;
        return tVar2;
    }

    public boolean c(TaskInfo taskInfo) {
        if (taskInfo != null) {
            return b(fc.b.a.f6004x).b(taskInfo);
        }
        throw new NullPointerException("taskInfo is null");
    }

    public int d(TaskInfo taskInfo) {
        if (taskInfo != null) {
            return b(fc.b.a.f6001u).c(taskInfo);
        }
        throw new IllegalArgumentException("taskInfo is null");
    }
}
