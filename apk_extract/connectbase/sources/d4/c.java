package d4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.transsion.backup.R;
import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import jq.e0;
import kn.l0;
import kn.n0;
import kn.r1;
import nm.h0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nAlbumManagerExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumManagerExt.kt\ncom/transsion/backup/ext/AlbumManagerExtKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,82:1\n125#2:83\n152#2,3:84\n*S KotlinDebug\n*F\n+ 1 AlbumManagerExt.kt\ncom/transsion/backup/ext/AlbumManagerExtKt\n*L\n65#1:83\n65#1:84,3\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final String[] f3527a = {"_id", "_display_name", "_size", "_data", "bucket_display_name", "bucket_id", "date_added"};

    public static final class a extends n0 implements jn.l<Long, List<AlbumFile>> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @l
        public final List<AlbumFile> invoke(@l Long l10) {
            l0.p(l10, "it");
            return new ArrayList();
        }
    }

    @l
    public static final List<AlbumInfo> b(@l List<AlbumFile> list) {
        l0.p(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AlbumFile albumFile : list) {
            Long lValueOf = Long.valueOf(albumFile.getAlbumId());
            final a aVar = a.INSTANCE;
            ((List) linkedHashMap.computeIfAbsent(lValueOf, new Function() { // from class: d4.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return c.c(aVar, obj);
                }
            })).add(albumFile);
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            List list2 = (List) entry.getValue();
            arrayList.add(new AlbumInfo(((AlbumFile) h0.B2(list2)).getAlbumName(), jLongValue, list2.size()));
        }
        return arrayList;
    }

    public static final List c(jn.l lVar, Object obj) {
        l0.p(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    @l
    public static final Uri d(@l String str) {
        l0.p(str, "mime");
        if (f(str)) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            l0.o(uri, "EXTERNAL_CONTENT_URI");
            return uri;
        }
        if (g(str)) {
            Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            l0.o(uri2, "EXTERNAL_CONTENT_URI");
            return uri2;
        }
        Uri uri3 = Uri.EMPTY;
        l0.o(uri3, "EMPTY");
        return uri3;
    }

    @l
    public static final String[] e() {
        return f3527a;
    }

    public static final boolean f(@l String str) {
        l0.p(str, "mime");
        return e0.s2(str, "image", false, 2, null);
    }

    public static final boolean g(@l String str) {
        l0.p(str, "mime");
        return e0.s2(str, "video", false, 2, null);
    }

    @l
    public static final String h(@l String str, @l Context context) {
        l0.p(str, "<this>");
        l0.p(context, "context");
        if (l0.g(str, "Camera")) {
            String string = context.getString(R.string.bkp_camera);
            l0.o(string, "getString(...)");
            return string;
        }
        if (!l0.g(str, "Screenshot")) {
            return str;
        }
        String string2 = context.getString(R.string.bkg_screen_shot);
        l0.o(string2, "getString(...)");
        return string2;
    }

    @l
    public static final AlbumFile i(@l Cursor cursor, int i10, @l Context context) {
        l0.p(cursor, "<this>");
        l0.p(context, "context");
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("_data");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("bucket_display_name");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("bucket_id");
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("date_added");
        long j10 = cursor.getLong(columnIndexOrThrow);
        String string = cursor.getString(columnIndexOrThrow2);
        long j11 = cursor.getLong(columnIndexOrThrow3);
        String string2 = cursor.getString(columnIndexOrThrow4);
        String string3 = cursor.getString(columnIndexOrThrow5);
        if (string3 == null) {
            string3 = Build.MODEL;
        }
        l0.m(string3);
        String strH = h(string3, context);
        long j12 = cursor.getLong(columnIndexOrThrow6);
        long j13 = cursor.getLong(columnIndexOrThrow7);
        l0.m(string);
        l0.m(string2);
        return new AlbumFile(j10, string, j11, string2, i10, strH, j12, j13, null, 256, null);
    }
}
