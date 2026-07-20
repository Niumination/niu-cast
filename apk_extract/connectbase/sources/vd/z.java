package vd;

import com.transsion.hubsdk.os.TranProcess;

/* JADX INFO: loaded from: classes2.dex */
public class z implements pg.i {
    @Override // pg.i
    public String a() {
        return TranProcess.getAllCpuLoading();
    }

    @Override // pg.i
    public double b() {
        return TranProcess.getCpuInfo();
    }
}
