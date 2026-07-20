package e8;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class q implements pg.m {
    @Override // pg.m
    public va.o[] a(int i10) {
        Class clsA = cc.a.a("android.os.ServiceManager");
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.os.IThermalService$Stub"), "asInterface", IBinder.class), null, (IBinder) cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "thermalservice"));
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "getCurrentTemperaturesWithType", Integer.TYPE), objJ, Integer.valueOf(i10));
        if (!(objJ2 instanceof Object[])) {
            return new va.o[0];
        }
        Object[] objArr = (Object[]) objJ2;
        va.o[] oVarArr = new va.o[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            va.o oVar = new va.o();
            oVar.f16804a = ((Float) cc.a.j(cc.a.g(obj.getClass(), "getValue", new Class[0]), obj, new Object[0])).floatValue();
            oVarArr[i11] = oVar;
        }
        return oVarArr;
    }
}
