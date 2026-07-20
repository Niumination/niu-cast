package c4;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Size;
import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jn.p;
import jq.e0;
import kn.l0;
import kn.r1;
import kn.w;
import ks.g;
import lm.d1;
import lm.l2;
import nm.c1;
import nm.d0;
import nm.h0;
import nm.k0;
import nm.y;
import nm.z;
import nq.k;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nAlbumManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumManager.kt\ncom/transsion/backup/album/AlbumManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,368:1\n1360#2:369\n1446#2,5:370\n1194#2,2:375\n1222#2,4:377\n1855#2,2:381\n1855#2,2:383\n1855#2:385\n1855#2,2:386\n1856#2:388\n819#2:389\n847#2,2:390\n1549#2:392\n1620#2,3:393\n819#2:396\n847#2,2:397\n1549#2:399\n1620#2,3:400\n766#2:403\n857#2,2:404\n1855#2,2:406\n1855#2,2:408\n*S KotlinDebug\n*F\n+ 1 AlbumManager.kt\ncom/transsion/backup/album/AlbumManager\n*L\n81#1:369\n81#1:370,5\n85#1:375,2\n85#1:377,4\n125#1:381,2\n239#1:383,2\n255#1:385\n256#1:386,2\n255#1:388\n261#1:389\n261#1:390,2\n262#1:392\n262#1:393,3\n263#1:396\n263#1:397,2\n264#1:399\n264#1:400,3\n267#1:403\n267#1:404,2\n268#1:406,2\n283#1:408,2\n*E\n"})
public final class b implements d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final a f1331h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final String f1332i = "AlbumManager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f1333j = 500;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1334k = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Application f1335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final List<f4.a> f1336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public ContentObserver f1337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public Map<Long, AlbumFile> f1338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public List<AlbumInfo> f1339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final Handler f1340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final Runnable f1341g;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX INFO: renamed from: c4.b$b, reason: collision with other inner class name */
    @r1({"SMAP\nAlbumManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumManager.kt\ncom/transsion/backup/album/AlbumManager$getAlbumFileByIds$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,368:1\n1603#2,9:369\n1855#2:378\n1856#2:380\n1612#2:381\n1549#2:382\n1620#2,3:383\n819#2:386\n847#2:387\n1747#2,3:388\n848#2:391\n1360#2:392\n1446#2,5:393\n1#3:379\n*S KotlinDebug\n*F\n+ 1 AlbumManager.kt\ncom/transsion/backup/album/AlbumManager$getAlbumFileByIds$2\n*L\n186#1:369,9\n186#1:378\n186#1:380\n186#1:381\n187#1:382\n187#1:383,3\n193#1:386\n193#1:387\n193#1:388,3\n193#1:391\n195#1:392\n195#1:393,5\n186#1:379\n*E\n"})
    @f(c = "com.transsion.backup.album.AlbumManager$getAlbumFileByIds$2", f = "AlbumManager.kt", i = {0}, l = {217}, m = "invokeSuspend", n = {"cachedFiles"}, s = {"L$0"})
    public static final class C0055b extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
        final /* synthetic */ List<Long> $ids;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ b this$0;

        /* JADX INFO: renamed from: c4.b$b$a */
        @f(c = "com.transsion.backup.album.AlbumManager$getAlbumFileByIds$2$deferredResults$1$1", f = "AlbumManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
            final /* synthetic */ List<Long> $idBatch;
            int label;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, List<Long> list, um.d<? super a> dVar) {
                super(2, dVar);
                this.this$0 = bVar;
                this.$idBatch = list;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                return new a(this.this$0, this.$idBatch, dVar);
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super List<? extends AlbumFile>> dVar) {
                return invoke2(s0Var, (um.d<? super List<AlbumFile>>) dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                b bVar = this.this$0;
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                l0.o(uri, "EXTERNAL_CONTENT_URI");
                return bVar.t(uri, 0, n.a.a("_id IN (", h0.m3(this.$idBatch, g.f9491d, null, null, 0, null, null, 62, null), ")"), null, null);
            }

            @m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: c4.b$b$b, reason: collision with other inner class name */
        @f(c = "com.transsion.backup.album.AlbumManager$getAlbumFileByIds$2$deferredResults$1$2", f = "AlbumManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0056b extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
            final /* synthetic */ List<Long> $idBatch;
            int label;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0056b(b bVar, List<Long> list, um.d<? super C0056b> dVar) {
                super(2, dVar);
                this.this$0 = bVar;
                this.$idBatch = list;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                return new C0056b(this.this$0, this.$idBatch, dVar);
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super List<? extends AlbumFile>> dVar) {
                return invoke2(s0Var, (um.d<? super List<AlbumFile>>) dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                b bVar = this.this$0;
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                l0.o(uri, "EXTERNAL_CONTENT_URI");
                return bVar.t(uri, 1, n.a.a("_id IN (", h0.m3(this.$idBatch, g.f9491d, null, null, 0, null, null, 62, null), ")"), null, null);
            }

            @m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
                return ((C0056b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0055b(List<Long> list, b bVar, um.d<? super C0055b> dVar) {
            super(2, dVar);
            this.$ids = list;
            this.this$0 = bVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            C0055b c0055b = new C0055b(this.$ids, this.this$0, dVar);
            c0055b.L$0 = obj;
            return c0055b;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super List<? extends AlbumFile>> dVar) {
            return invoke2(s0Var, (um.d<? super List<AlbumFile>>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            List arrayList;
            Object objA;
            int i10 = 1;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = this.label;
            if (i11 == 0) {
                d1.n(obj);
                s0 s0Var = (s0) this.L$0;
                if (this.$ids.isEmpty()) {
                    k4.m.c(b.f1332i, "IDs list is empty");
                    return k0.INSTANCE;
                }
                List<Long> list = this.$ids;
                b bVar = this.this$0;
                arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    AlbumFile albumFile = (AlbumFile) bVar.f1338d.get(new Long(((Number) it.next()).longValue()));
                    if (albumFile != null) {
                        arrayList.add(albumFile);
                    }
                }
                ArrayList arrayList2 = new ArrayList(z.b0(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new Long(((AlbumFile) it2.next()).getId()));
                }
                k4.m.b(b.f1332i, "Cached files: " + arrayList2);
                if (arrayList.size() == this.$ids.size()) {
                    return arrayList;
                }
                List<Long> list2 = this.$ids;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list2) {
                    long jLongValue = ((Number) obj2).longValue();
                    if (!arrayList.isEmpty()) {
                        Iterator it3 = arrayList.iterator();
                        do {
                            if (it3.hasNext()) {
                            }
                        } while (((AlbumFile) it3.next()).getId() != jLongValue);
                    }
                    arrayList3.add(obj2);
                }
                List<List> listP1 = h0.P1(arrayList3, 20);
                b bVar2 = this.this$0;
                ArrayList arrayList4 = new ArrayList();
                for (List list3 : listP1) {
                    d0.r0(arrayList4, y.O(k.b(s0Var, null, null, new a(bVar2, list3, null), 3, null), k.b(s0Var, null, null, new C0056b(bVar2, list3, null), 3, null)));
                    i10 = 1;
                }
                this.L$0 = arrayList;
                this.label = i10;
                objA = nq.f.a(arrayList4, this);
                if (objA == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List list4 = (List) this.L$0;
                d1.n(obj);
                arrayList = list4;
                objA = obj;
            }
            List listD0 = z.d0((Iterable) objA);
            k4.m.b(b.f1332i, "Total files found: " + (arrayList.size() + listD0.size()));
            return h0.E4(arrayList, listD0);
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
            return ((C0055b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            b.this.o();
        }
    }

    public b(@l Application application) {
        l0.p(application, "context");
        this.f1335a = application;
        this.f1336b = new ArrayList();
        this.f1338d = nm.d1.z();
        this.f1340f = new Handler(Looper.getMainLooper());
        this.f1341g = new Runnable() { // from class: c4.a
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IOException, InvocationTargetException {
                b.n(this.f1330a);
            }
        };
    }

    public static final void n(b bVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(bVar, "this$0");
        bVar.s();
    }

    @Override // c4.d
    @m
    public String a(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), j10);
        l0.o(uriWithAppendedId, "withAppendedId(...)");
        Cursor cursorQuery = this.f1335a.getContentResolver().query(uriWithAppendedId, new String[]{"mime_type"}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            String string = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type")) : null;
            dn.c.a(cursor, null);
            return string;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(cursor, th2);
                throw th3;
            }
        }
    }

    @Override // c4.d
    @m
    public byte[] b(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        Uri uriQ = q(j10);
        if (l0.g(uriQ, Uri.EMPTY)) {
            k4.m.c(f1332i, "File with ID: " + j10 + " does not exist");
            return null;
        }
        Bitmap bitmapLoadThumbnail = this.f1335a.getContentResolver().loadThumbnail(ContentUris.withAppendedId(uriQ, j10), new Size(256, 256), null);
        l0.o(bitmapLoadThumbnail, "loadThumbnail(...)");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapLoadThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // c4.d
    @m
    public Object c(@l List<Long> list, @l um.d<? super List<AlbumFile>> dVar) {
        return t0.g(new C0055b(list, this, null), dVar);
    }

    @Override // c4.d
    public void d(@l f4.a aVar) {
        l0.p(aVar, "listener");
        this.f1336b.add(aVar);
        if (this.f1337c == null) {
            if (this.f1338d.isEmpty()) {
                e();
            }
            this.f1337c = new c(this.f1340f);
            u();
        }
    }

    @Override // c4.d
    @l
    public List<AlbumFile> e() {
        if (!this.f1338d.isEmpty()) {
            k4.m.b(f1332i, "Returning cached data");
            return h0.V5(this.f1338d.values());
        }
        List<lm.t0> listO = y.O(new lm.t0(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, 0), new lm.t0(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 1));
        ArrayList arrayList = new ArrayList();
        for (lm.t0 t0Var : listO) {
            Uri uri = (Uri) t0Var.component1();
            int iIntValue = ((Number) t0Var.component2()).intValue();
            l0.m(uri);
            d0.r0(arrayList, r(uri, iIntValue));
        }
        int iJ = c1.j(z.b0(arrayList, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((AlbumFile) obj).getId()), obj);
        }
        this.f1338d = linkedHashMap;
        return arrayList;
    }

    @Override // c4.d
    @l
    public InputStream f(long j10) throws FileNotFoundException {
        Uri uriWithAppendedId = ContentUris.withAppendedId(q(j10), j10);
        l0.o(uriWithAppendedId, "withAppendedId(...)");
        if (!l0.g(uriWithAppendedId, Uri.EMPTY)) {
            InputStream inputStreamOpenInputStream = this.f1335a.getContentResolver().openInputStream(uriWithAppendedId);
            return inputStreamOpenInputStream == null ? new ByteArrayInputStream(new byte[0]) : inputStreamOpenInputStream;
        }
        k4.m.c(f1332i, "File with ID: " + j10 + " does not exist");
        return new ByteArrayInputStream(new byte[0]);
    }

    @Override // c4.d
    public boolean g(@l List<Long> list) throws IllegalAccessException, IOException, InvocationTargetException {
        Uri uri;
        l2 l2Var;
        l0.p(list, "ids");
        if (list.isEmpty()) {
            k4.m.c(f1332i, "File list is empty");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            String strA = a(jLongValue);
            if (strA == null) {
                k4.m.c(f1332i, "File with ID: " + jLongValue + " does not exist");
                arrayList.add(Long.valueOf(jLongValue));
            } else {
                if (e0.s2(strA, "image", false, 2, null)) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if (e0.s2(strA, "video", false, 2, null)) {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    k4.m.c(f1332i, "File with ID: " + jLongValue + " has unsupported MIME type: " + strA);
                    arrayList2.add(Long.valueOf(jLongValue));
                }
                Uri uriWithAppendedId = ContentUris.withAppendedId(uri, jLongValue);
                l0.o(uriWithAppendedId, "withAppendedId(...)");
                Cursor cursorQuery = this.f1335a.getContentResolver().query(uriWithAppendedId, null, null, null, null);
                if (cursorQuery != null) {
                    Cursor cursor = cursorQuery;
                    try {
                        if (cursor.moveToFirst()) {
                            l2Var = l2.f10208a;
                            dn.c.a(cursor, null);
                        } else {
                            arrayList.add(Long.valueOf(jLongValue));
                            dn.c.a(cursor, null);
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            dn.c.a(cursor, th2);
                            throw th3;
                        }
                    }
                } else {
                    l2Var = null;
                }
                if (l2Var == null) {
                    k4.m.c(f1332i, "Failed to query file with ID: " + jLongValue);
                } else if (this.f1335a.getContentResolver().delete(uriWithAppendedId, null, null) > 0) {
                    k4.m.e(f1332i, "Deleted file with ID: " + jLongValue);
                } else {
                    k4.m.c(f1332i, "Failed to delete file with ID: " + jLongValue);
                }
            }
            z10 = false;
        }
        if (!arrayList.isEmpty()) {
            k4.m.c(f1332i, "Files with IDs do not exist: " + h0.m3(arrayList, ", ", null, null, 0, null, null, 62, null));
        }
        if (!arrayList2.isEmpty()) {
            k4.m.c(f1332i, "Files with unsupported MIME types: " + h0.m3(arrayList2, ", ", null, null, 0, null, null, 62, null));
        }
        return z10;
    }

    @Override // c4.d
    public void h(@l f4.a aVar) {
        l0.p(aVar, "listener");
        this.f1336b.remove(aVar);
        if (this.f1336b.isEmpty() && this.f1337c != null) {
            ContentResolver contentResolver = this.f1335a.getContentResolver();
            ContentObserver contentObserver = this.f1337c;
            l0.m(contentObserver);
            contentResolver.unregisterContentObserver(contentObserver);
            this.f1337c = null;
        }
        this.f1338d = nm.d1.z();
        this.f1339e = null;
    }

    @Override // c4.d
    @l
    public List<AlbumInfo> i() {
        List<AlbumInfo> list = this.f1339e;
        if (list == null) {
            List<AlbumInfo> listB = d4.c.b(e());
            this.f1339e = listB;
            return listB;
        }
        k4.m.b(f1332i, "Returning cached album info " + list);
        return list;
    }

    public final void o() {
        this.f1340f.removeCallbacks(this.f1341g);
        this.f1340f.postDelayed(this.f1341g, 500L);
    }

    public final AlbumFile p(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        String strA = a(j10);
        if (strA == null) {
            k4.m.c(f1332i, "Failed to get MIME type for file with ID: " + j10);
            return null;
        }
        Uri uriQ = q(j10);
        if (!l0.g(uriQ, Uri.EMPTY)) {
            return (AlbumFile) h0.G2(t(uriQ, !e0.s2(strA, "image", false, 2, null) ? 1 : 0, "_id = ?", new String[]{String.valueOf(j10)}, null));
        }
        k4.m.c(f1332i, "Failed to get content URI for file with ID: " + j10);
        return null;
    }

    public final Uri q(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        String strA = a(j10);
        if (strA == null) {
            k4.m.c(f1332i, "File with ID: " + j10 + " does not exist");
            Uri uri = Uri.EMPTY;
            l0.o(uri, "EMPTY");
            return uri;
        }
        Uri uriD = d4.c.d(strA);
        if (l0.g(uriD, Uri.EMPTY)) {
            k4.m.c(f1332i, "File with ID: " + j10 + " Unsupported media type: " + strA);
        }
        return uriD;
    }

    public final List<AlbumFile> r(Uri uri, int i10) {
        return t(uri, i10, null, null, "date_added DESC");
    }

    public final void s() throws IllegalAccessException, IOException, InvocationTargetException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (lm.t0 t0Var : y.O(new lm.t0(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, 0), new lm.t0(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 1))) {
            Uri uri = (Uri) t0Var.component1();
            int iIntValue = ((Number) t0Var.component2()).intValue();
            l0.m(uri);
            for (AlbumFile albumFile : r(uri, iIntValue)) {
                linkedHashMap.put(Long.valueOf(albumFile.getId()), albumFile);
            }
        }
        Collection collectionValues = linkedHashMap.values();
        ArrayList<AlbumFile> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!this.f1338d.containsKey(Long.valueOf(((AlbumFile) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(z.b0(arrayList, 10));
        for (AlbumFile albumFile2 : arrayList) {
            arrayList2.add(albumFile2.copy((255 & 1) != 0 ? albumFile2.f1827id : 0L, (255 & 2) != 0 ? albumFile2.name : null, (255 & 4) != 0 ? albumFile2.size : 0L, (255 & 8) != 0 ? albumFile2.path : null, (255 & 16) != 0 ? albumFile2.type : 0, (255 & 32) != 0 ? albumFile2.albumName : null, (255 & 64) != 0 ? albumFile2.albumId : 0L, (255 & 128) != 0 ? albumFile2.createDate : 0L, (255 & 256) != 0 ? albumFile2.isDeleted : null));
        }
        Collection<AlbumFile> collectionValues2 = this.f1338d.values();
        ArrayList<AlbumFile> arrayList3 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (!linkedHashMap.containsKey(Long.valueOf(((AlbumFile) obj2).getId()))) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(z.b0(arrayList3, 10));
        for (AlbumFile albumFile3 : arrayList3) {
            arrayList4.add(albumFile3.copy((255 & 1) != 0 ? albumFile3.f1827id : 0L, (255 & 2) != 0 ? albumFile3.name : null, (255 & 4) != 0 ? albumFile3.size : 0L, (255 & 8) != 0 ? albumFile3.path : null, (255 & 16) != 0 ? albumFile3.type : 0, (255 & 32) != 0 ? albumFile3.albumName : null, (255 & 64) != 0 ? albumFile3.albumId : 0L, (255 & 128) != 0 ? albumFile3.createDate : 0L, (255 & 256) != 0 ? albumFile3.isDeleted : Boolean.TRUE));
        }
        List<AlbumFile> listY5 = h0.Y5(h0.E4(arrayList2, arrayList4));
        ArrayList<AlbumFile> arrayList5 = new ArrayList();
        for (Object obj3 : listY5) {
            if (((AlbumFile) obj3).getSize() == 0) {
                arrayList5.add(obj3);
            }
        }
        for (AlbumFile albumFile4 : arrayList5) {
            AlbumFile albumFileP = p(albumFile4.getId());
            if (albumFileP != null) {
                listY5.remove(albumFile4);
                listY5.add(albumFileP);
            }
        }
        this.f1338d = linkedHashMap;
        if (listY5.isEmpty()) {
            return;
        }
        k4.m.b(f1332i, "Detected changes: New files: " + arrayList2.size() + ", Deleted files: " + arrayList4.size());
        this.f1339e = null;
        Iterator<T> it = this.f1336b.iterator();
        while (it.hasNext()) {
            ((f4.a) it.next()).a(listY5);
        }
    }

    public final List<AlbumFile> t(Uri uri, int i10, String str, String[] strArr, String str2) throws IllegalAccessException, IOException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f1335a.getContentResolver().query(uri, d4.c.e(), str, strArr, str2);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    arrayList.add(d4.c.i(cursor2, i10, this.f1335a));
                }
                l2 l2Var = l2.f10208a;
                dn.c.a(cursor, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    dn.c.a(cursor, th2);
                    throw th3;
                }
            }
        }
        return arrayList;
    }

    public final void u() {
        ContentObserver contentObserver = this.f1337c;
        if (contentObserver != null) {
            Iterator it = y.O(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.EXTERNAL_CONTENT_URI).iterator();
            while (it.hasNext()) {
                this.f1335a.getContentResolver().registerContentObserver((Uri) it.next(), true, contentObserver);
            }
        }
    }
}
