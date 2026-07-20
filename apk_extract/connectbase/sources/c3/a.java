package c3;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.RequiresApi;
import java.io.OutputStream;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nDownloadFileCreator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadFileCreator.kt\ncom/transsion/airtransfer/filetransfer/process/file/DownloadFileCreatorAfterQ\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
public final class a implements x2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Context f1272a;

    public a(@os.l Context context) {
        l0.p(context, "context");
        this.f1272a = context;
    }

    @Override // x2.b
    @os.m
    @RequiresApi(29)
    public OutputStream a(@os.l String str) {
        l0.p(str, "fileName");
        try {
            ContentValues contentValues = new ContentValues();
            q2.a.f13797a.getClass();
            contentValues.put("relative_path", q2.a.f13799c);
            contentValues.put("_display_name", str);
            Uri uriInsert = this.f1272a.getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
            if (uriInsert != null) {
                return this.f1272a.getContentResolver().openOutputStream(uriInsert);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
