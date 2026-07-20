package s7;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.transsion.capability.bean.FileInfo;
import com.transsion.connectx.sdk.SendFileStatusListener;
import com.transsion.message.bank.MessageBank;
import h3.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import m3.u;
import tj.w;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SendFileStatusListener {
    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onCancelTransfer(int i8) {
        String strM = o.d.m("registerFileSendListener:  onCancelTransfer ", "CastSourceFileTransfer", "tag", "log", i8);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), strM);
        }
        String strM2 = o.d.m("FileSend:onCancelTransfer: type:", "FileTransferProcessor", "tag", "log", i8);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), strM2);
        }
        sj.a aVar = i.f10891a;
        i.c(Integer.valueOf(i8), false, 2);
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onConfirmRequestFile(List urls, String str, int i8) {
        String log = "registerFileSendListener:  onConfirmRequestFile url:" + urls + ", p1:" + str;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log);
        }
        if (urls != null) {
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullParameter(urls, "urls");
            String log2 = "FileSend:onConfirmRequestFile:fileId:" + str + ", urls" + urls;
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), log2);
            }
            e eVar = i.q;
            eVar.removeMessages(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
            eVar.sendEmptyMessageDelayed(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, 60000L);
            q7.c cVar = new q7.c(urls, str == null ? "" : str);
            l0.p(i.f10893c, null, null, new xa.c(cVar, na.b.b(cVar), null), 3);
            i.a(0, i8, str);
        }
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onFailed(String str, int i8, String str2, int i9) {
        String log = "registerFileSendListener:  onFailed path:" + str + "  p1:" + i8;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log);
        }
        String log2 = "FileSend:onFailed:fileId:" + str2 + ", type:" + i9 + ", reason:" + i8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log2);
        }
        sj.a aVar = i.f10891a;
        i.b(i9, str2);
        int i10 = i.f;
        if (i10 == 3 || i10 == 5) {
            fb.b.f5014b.e();
        }
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onFileTaskConfirmResult(int i8, String str, List list) {
        String strM = o.d.m("registerFileSendListener:  onFileTaskConfirmResult ", "CastSourceFileTransfer", "tag", "log", i8);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), strM);
        }
        String log = "FileSend:confirm result responseCode: " + i8 + "----key: " + str;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
        }
        sj.a aVar = i.f10891a;
        if (i8 != 1) {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("processTaskConfirmResult: peer refuse", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), "processTaskConfirmResult: peer refuse");
                return;
            }
            return;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FileInfo file = (FileInfo) na.b.a((String) it.next(), FileInfo.class);
                if (file != null) {
                    String log2 = "processTaskConfirmResult add(" + file.getId() + ")";
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), log2);
                    }
                    i.f10895g.add(file.getId());
                    ob.b.f8417b.getClass();
                    Intrinsics.checkNotNullParameter(file, "file");
                    ob.b.f8436z = file.getFileSize() + ob.b.f8436z;
                    ob.b.f8435y.add(file);
                }
            }
        }
        int i9 = i.f;
        if (i9 == 5 || i9 == 3) {
            u.d(pb.a());
        }
        ob.b.f8417b.getClass();
        ob.b.f8433w = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onProgress(String str, int i8, String str2, int i9) {
        String log = "registerFileSendListener:  onProgress  path: " + str + " filesize:" + i8;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log);
        }
        String log2 = "FileSend:onProgress: fileId:" + str2 + ", progress:" + i8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log2);
        }
        e eVar = i.q;
        eVar.removeMessages(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
        eVar.sendEmptyMessageDelayed(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, 60000L);
        i.a(i8, i9, str2);
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onSuccess(String str, String str2, int i8) {
        FileInfo fileInfo;
        FileInfo fileInfo2;
        String str3;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerFileSendListener:  onSuccess", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerFileSendListener:  onSuccess");
        }
        String log = "FileSend:onSuccess:fileId:" + str2 + ", type:" + i8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
        }
        ob.b bVar = ob.b.f8417b;
        int i9 = i.f10894d;
        bVar.getClass();
        if (i8 == 1) {
            ob.b.f8434x++;
        } else {
            long fileSize = 0;
            if (i9 == 1) {
                ob.b.f8430s = 0L;
                ob.b.f8431t = 1;
                ArrayList arrayList = ob.b.f8429r;
                if (arrayList != null && (fileInfo2 = (FileInfo) arrayList.get(0)) != null) {
                    fileSize = fileInfo2.getFileSize();
                }
                ob.b.f8430s = fileSize;
            } else {
                ob.b.f8431t++;
                long j8 = ob.b.f8430s;
                ArrayList arrayList2 = ob.b.f8429r;
                if (arrayList2 != null && (fileInfo = (FileInfo) arrayList2.get(i9 - 1)) != null) {
                    fileSize = fileInfo.getFileSize();
                }
                ob.b.f8430s = j8 + fileSize;
            }
        }
        i.b(i8, str2);
        bVar.f8437a.getClass();
        Bundle bundleD = w.D();
        switch (i8) {
            case 1:
                str3 = "TYPE_FILE_DRAG_TRANSFER";
                break;
            case 2:
                str3 = "TYPE_FILE_DIRECT_TRANSFER";
                break;
            case 3:
                str3 = "TYPE_GESTURE_DIRECT_TRANSFER";
                break;
            case 4:
                str3 = "TYPE_SHARE_DIRECT_TRANSFER";
                break;
            case 5:
                str3 = "TYPE_AIR_COPY_TRANSFER";
                break;
            case 6:
                str3 = "TYPE_SCREEN_SHOT_TRANSFER";
                break;
            default:
                str3 = "Undefined";
                break;
        }
        bundleD.putString(MessageBank.KEY_TYPE, str3);
        w.X("iot_pc_con_photo_screenshot_sync", bundleD);
    }

    @Override // com.transsion.connectx.sdk.SendFileTransferListener
    public final void onTransferFinish() {
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerFileSendListener:  onTransferFinish", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerFileSendListener:  onTransferFinish");
        }
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("FileSend:onTransferFinish", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "FileSend:onTransferFinish");
        }
        i.q.removeMessages(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
    }
}
