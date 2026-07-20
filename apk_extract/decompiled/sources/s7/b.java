package s7;

import android.app.Application;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.transsion.connectx.sdk.ReceiveFileStatusListener;
import com.transsion.iotservice.multiscreen.pc.R$string;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import li.l0;
import na.k;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ReceiveFileStatusListener {
    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onCancelTransfer(int i8) {
        String strM = o.d.m("registerReceiveFileListener:onConfirmReceiveFile", "CastSourceFileTransfer", "tag", "log", i8);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), strM);
        }
        i.f10898j.clear();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0184 A[Catch: Exception -> 0x0159, TryCatch #0 {Exception -> 0x0159, blocks: (B:23:0x00f1, B:25:0x0105, B:27:0x010b, B:30:0x0126, B:32:0x013f, B:33:0x0148, B:36:0x015c, B:38:0x0184, B:40:0x018e, B:42:0x01c5, B:44:0x01cb, B:46:0x01e9), top: B:57:0x00f1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01e9 A[Catch: Exception -> 0x0159, TRY_LEAVE, TryCatch #0 {Exception -> 0x0159, blocks: (B:23:0x00f1, B:25:0x0105, B:27:0x010b, B:30:0x0126, B:32:0x013f, B:33:0x0148, B:36:0x015c, B:38:0x0184, B:40:0x018e, B:42:0x01c5, B:44:0x01cb, B:46:0x01e9), top: B:57:0x00f1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x01e9, please report this as an issue */
    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onConfirmReceiveFile(List list, long j8, String str, String str2, int i8) {
        String str3;
        CharSequence charSequenceSubSequence;
        CharSequence charSequenceSubSequence2;
        String log;
        int i9;
        String str4;
        String str5;
        String log2;
        String log3 = "registerReceiveFileListener:onConfirmReceiveFile" + list + "——" + j8 + "——" + str;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter(log3, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log3);
        }
        String log4 = "FileReceiver:onConfirmReceiveFile:urls:" + list + ",fileSize:" + j8 + ",packageName:" + i.f10892b;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log4, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log4);
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("confirmReceiveFile:file id list is null", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), "confirmReceiveFile:file id list is null");
                return;
            }
            return;
        }
        String log5 = "confirmReceiveFile: fileSize:" + j8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log5, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log5);
        }
        if (Environment.getExternalStorageDirectory().getUsableSpace() < j8) {
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getString(R$string.module_pc_insufficient_memory);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.b(applicationA, string);
            return;
        }
        ob.b.f8417b.getClass();
        ob.b.E = true;
        if (ob.b.C == 0) {
            ob.b.C = SystemClock.elapsedRealtime();
        }
        ob.b.A++;
        ob.b.B += j8;
        String str6 = (String) list.get(0);
        try {
            String str7 = i.p;
            String strSubstring = str6.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) str6, '\\', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            HashSet hashSet = i.f10898j;
            if (hashSet.contains(strSubstring)) {
                int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strSubstring, ".", 0, false, 6, (Object) null);
                charSequenceSubSequence = strSubstring.subSequence(iLastIndexOf$default, strSubstring.length());
                charSequenceSubSequence2 = strSubstring.subSequence(0, iLastIndexOf$default);
                log = "getSavedPath, subFileName:" + ((Object) charSequenceSubSequence2);
                Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
                }
                i9 = 1;
                while (true) {
                    str4 = ((Object) charSequenceSubSequence2) + "(" + i9 + ")" + ((Object) charSequenceSubSequence);
                    str5 = str7 + str4;
                    i9++;
                    File file = new File(str5);
                    if (hashSet.contains(str4)) {
                    }
                }
                hashSet.add(str4);
                log2 = "getSavedPath, savedFileName:" + str4;
                Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b + "FileTransferProcessor", log2);
                }
                str3 = str5;
            } else {
                if (new File(str7 + strSubstring).exists()) {
                    int iLastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strSubstring, ".", 0, false, 6, (Object) null);
                    charSequenceSubSequence = strSubstring.subSequence(iLastIndexOf$default2, strSubstring.length());
                    charSequenceSubSequence2 = strSubstring.subSequence(0, iLastIndexOf$default2);
                    log = "getSavedPath, subFileName:" + ((Object) charSequenceSubSequence2);
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
                    }
                    i9 = 1;
                    while (true) {
                        str4 = ((Object) charSequenceSubSequence2) + "(" + i9 + ")" + ((Object) charSequenceSubSequence);
                        str5 = str7 + str4;
                        i9++;
                        File file2 = new File(str5);
                        if (hashSet.contains(str4) && !file2.exists()) {
                            break;
                        }
                    }
                    hashSet.add(str4);
                    log2 = "getSavedPath, savedFileName:" + str4;
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b + "FileTransferProcessor", log2);
                    }
                    str3 = str5;
                } else {
                    hashSet.add(strSubstring);
                    String log6 = "getSavedPath, fileName:" + strSubstring;
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter(log6, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), log6);
                    }
                    str3 = str7 + strSubstring;
                }
            }
        } catch (Exception e) {
            String log7 = "getSavedPath, Exception:" + e;
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter(log7, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), log7);
            }
            str3 = "";
        }
        sj.a aVar = i.f10891a;
        q7.b bVar = new q7.b(str3, str2, list);
        l0.p(i.f10893c, null, null, new xa.b(bVar, na.b.b(bVar), null), 3);
    }

    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onFailed(String str, int i8, String str2, int i9) {
        String log = "FileReceiver:onFailed: path:" + str + ",reason:" + i8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
        }
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerReceiveFileListener:onFailed", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerReceiveFileListener:onFailed");
        }
    }

    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onProgress(String str, int i8, String str2, int i9) {
        String log = "FileReceiver:onProgress: path:" + str + ",progress:" + i8;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
        }
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerReceiveFileListener:onProgres", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerReceiveFileListener:onProgres");
        }
    }

    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onSuccess(String str, String str2, int i8) {
        String strN = o.d.n("FileReceiver:onSuccess: path:", str, "FileTransferProcessor", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), strN);
        }
        ob.b.f8417b.getClass();
        ob.b.D++;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerReceiveFileListener:onSuccess", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerReceiveFileListener:onSuccess");
        }
    }

    @Override // com.transsion.connectx.sdk.ReceiveFileTransferListener
    public final void onTransferFinish() {
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("FileReceiver:onTransferFinish", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "FileReceiver:onTransferFinish");
        }
        i.f10905s.invoke();
        i.f10898j.clear();
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter("registerReceiveFileListener:onTransferFinish", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), "registerReceiveFileListener:onTransferFinish");
        }
    }
}
