package t7;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.CancellationSignal;
import android.util.Base64;
import android.util.Log;
import android.util.Size;
import com.transsion.capability.bean.FileInfo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import q7.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10198a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f10199b = new ArrayList();

    public static String a(String str) throws IOException {
        if (str == null || str.length() == 0) {
            Log.d("TransFileUtil", "path is null");
            return "";
        }
        Log.d("TransFileUtil", "path is ".concat(str));
        Bitmap bitmapCreateImageThumbnail = ThumbnailUtils.createImageThumbnail(new File(str), new Size(200, 200), new CancellationSignal());
        ArrayList arrayList = f10199b;
        if (bitmapCreateImageThumbnail == null) {
            return null;
        }
        Log.d("TransFileUtil", "bitmap:" + bitmapCreateImageThumbnail + "---width:" + bitmapCreateImageThumbnail.getWidth() + " height:" + bitmapCreateImageThumbnail.getHeight() + " byteCount:" + (bitmapCreateImageThumbnail.getByteCount() / 1024) + "kb");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        try {
            bitmapCreateImageThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        } catch (Exception unused) {
            Bitmap bitmapCopy = bitmapCreateImageThumbnail.copy(Bitmap.Config.ARGB_8888, false);
            bitmapCopy.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            arrayList.add(bitmapCopy);
        }
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        arrayList.add(bitmapCreateImageThumbnail);
        return strEncodeToString;
    }

    public static void b() {
        ArrayList<Bitmap> arrayList = f10199b;
        for (Bitmap bitmap : arrayList) {
            try {
                bitmap.recycle();
                Log.d("TransFileUtil", "bitmap recycle " + bitmap);
            } catch (Throwable th2) {
                Log.d("TransFileUtil", "bitmap recycle " + bitmap);
                throw th2;
            }
        }
        arrayList.clear();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object c(Cursor cursor, int i8, ContinuationImpl continuationImpl) {
        d dVar;
        Cursor cursor2;
        Throwable th2;
        Closeable closeable;
        if (continuationImpl instanceof d) {
            dVar = (d) continuationImpl;
            int i9 = dVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                dVar.label = i9 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, continuationImpl);
            }
        } else {
            dVar = new d(this, continuationImpl);
        }
        Object obj = dVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = dVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            gc.a("TransFileUtil", "on transferInstantPicture");
            if (i8 != 6 && i8 != 2) {
                gc.b("TransFileUtil", "transferInstantPicture error type:" + i8);
                return Unit.INSTANCE;
            }
            cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                String string = cursor3.getString(cursor3.getColumnIndex("_data"));
                File file = new File(string);
                ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(new FileInfo(string, a(string), file.getName(), "image/jpeg", 0, file.length()));
                String packageName = pb.a().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                String strB = na.b.b(new h(arrayListArrayListOf, packageName, i8, ""));
                b();
                Log.d("TransFileUtil", "picFromCamera: filePath=" + file.getPath());
                s7.d dVar2 = (s7.d) o7.a.b("com.transsion.file");
                if (dVar2 != null) {
                    dVar.L$0 = cursor2;
                    dVar.label = 1;
                    if (dVar2.c(strB) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = cursor2;
                }
                CloseableKt.closeFinally(cursor2, null);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th2 = th3;
                closeable = cursor2;
                throw th2;
            }
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        closeable = (Closeable) dVar.L$0;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Throwable th4) {
            th2 = th4;
            try {
                throw th2;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(closeable, th2);
                throw th5;
            }
        }
        Unit unit = Unit.INSTANCE;
        cursor2 = closeable;
        CloseableKt.closeFinally(cursor2, null);
        return Unit.INSTANCE;
    }
}
