package zc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.transsion.capability.bean.FileInfo;
import com.transsion.pcconnect.service.FileService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import na.b;
import o.d;
import q7.h;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Binder implements IInterface {
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("com.transsion.iotservice.pc.IDeviceService");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("com.transsion.iotservice.pc.IDeviceService");
            return true;
        }
        if (i8 == 1) {
            parcel.readString();
            String fileInfo = parcel.readString();
            Intrinsics.checkNotNullParameter("FileService", "tag");
            Intrinsics.checkNotNullParameter("obtainStep", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("FileService"), "obtainStep");
            }
            sj.a aVar = i.f10891a;
            if (fileInfo == null) {
                fileInfo = "";
            }
            Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
            ArrayList arrayList = new ArrayList();
            Iterator it = b.c(FileInfo[].class, fileInfo).iterator();
            while (it.hasNext()) {
                arrayList.add((FileInfo) it.next());
            }
            h hVar = new h(arrayList, i.f10892b, 1, UUID.randomUUID().toString());
            String strN = d.n("sendFileInfoByDrag taskId: ", hVar.getTaskId(), "FileTransferProcessor", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), strN);
            }
            l0.p(i.f10893c, null, null, new xa.h(hVar, null), 3);
            parcel2.writeNoException();
        } else {
            if (i8 != 2) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            String strM = d.m("sIsEnable: ", "FileService", "tag", "log", FileService.f2953b);
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("FileService"), strM);
            }
            int i10 = FileService.f2953b;
            parcel2.writeNoException();
            parcel2.writeInt(i10);
        }
        return true;
    }
}
