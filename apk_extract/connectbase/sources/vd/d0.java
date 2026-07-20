package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranThermalService;
import com.transsion.hubsdk.os.TranTemperature;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements pg.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16917b = "TranThubThermalManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranThermalService f16918a = ITranThermalService.Stub.asInterface(TranServiceManager.getServiceIBinder("thermalservice"));

    @Override // pg.m
    public va.o[] a(int i10) {
        TranTemperature[] currentTemperaturesWithType;
        try {
            ITranThermalService iTranThermalService = this.f16918a;
            if (iTranThermalService != null && (currentTemperaturesWithType = iTranThermalService.getCurrentTemperaturesWithType(i10)) != null) {
                va.o[] oVarArr = new va.o[currentTemperaturesWithType.length];
                for (int i11 = 0; i11 < currentTemperaturesWithType.length; i11++) {
                    va.o oVar = new va.o();
                    oVar.b(currentTemperaturesWithType[i11].getValue());
                    oVarArr[i11] = oVar;
                }
                return oVarArr;
            }
        } catch (RemoteException e10) {
            j7.b.a("getCurrentTemperaturesWithType fail: e = ", e10, f16917b);
        }
        return new va.o[0];
    }
}
