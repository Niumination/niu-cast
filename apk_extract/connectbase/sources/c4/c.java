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
@r1({"SMAP\nAlbumManagerPad.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumManagerPad.kt\ncom/transsion/backup/album/AlbumManagerPad\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,327:1\n17#2:328\n1855#3,2:329\n1855#3,2:331\n1194#3,2:333\n1222#3,4:335\n1855#3,2:339\n1855#3,2:341\n1855#3:343\n1855#3,2:344\n1856#3:346\n819#3:347\n847#3,2:348\n1549#3:350\n1620#3,3:351\n819#3:354\n847#3,2:355\n1549#3:357\n1620#3,3:358\n766#3:361\n857#3,2:362\n1855#3,2:364\n1855#3,2:366\n*S KotlinDebug\n*F\n+ 1 AlbumManagerPad.kt\ncom/transsion/backup/album/AlbumManagerPad\n*L\n40#1:328\n97#1:329,2\n98#1:331,2\n100#1:333,2\n100#1:335,4\n134#1:339,2\n212#1:341,2\n225#1:343\n229#1:344,2\n225#1:346\n233#1:347\n233#1:348,2\n234#1:350\n234#1:351,3\n236#1:354\n236#1:355,2\n237#1:357\n237#1:358,3\n240#1:361\n240#1:362,2\n241#1:364,2\n256#1:366,2\n*E\n"})
public final class c implements c4.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public static final a f1343j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public static final String f1344k = "AlbumManagerPad";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f1345l = 500;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f1346m = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Application f1347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final List<f4.a> f1348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public ContentObserver f1349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final Handler f1350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public Map<Long, AlbumFile> f1351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public List<AlbumInfo> f1352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final Runnable f1353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final List<Uri> f1354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final List<Uri> f1355i;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @r1({"SMAP\nAlbumManagerPad.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumManagerPad.kt\ncom/transsion/backup/album/AlbumManagerPad$getAlbumFileByIds$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1603#2,9:328\n1855#2:337\n1856#2:339\n1612#2:340\n819#2:341\n847#2:342\n1747#2,3:343\n848#2:346\n1360#2:347\n1446#2,2:348\n1549#2:350\n1620#2,3:351\n1549#2:354\n1620#2,3:355\n1448#2,3:358\n1#3:338\n*S KotlinDebug\n*F\n+ 1 AlbumManagerPad.kt\ncom/transsion/backup/album/AlbumManagerPad$getAlbumFileByIds$2\n*L\n177#1:328,9\n177#1:337\n177#1:339\n177#1:340\n180#1:341\n180#1:342\n180#1:343,3\n180#1:346\n181#1:347\n181#1:348,2\n183#1:350\n183#1:351,3\n194#1:354\n194#1:355,3\n181#1:358,3\n177#1:338\n*E\n"})
    @f(c = "com.transsion.backup.album.AlbumManagerPad$getAlbumFileByIds$2", f = "AlbumManagerPad.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
        final /* synthetic */ List<Long> $ids;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ c this$0;

        @f(c = "com.transsion.backup.album.AlbumManagerPad$getAlbumFileByIds$2$deferred$1$1$1", f = "AlbumManagerPad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
            final /* synthetic */ String $idList;
            final /* synthetic */ Uri $uri;
            int label;
            final /* synthetic */ c this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Uri uri, String str, um.d<? super a> dVar) {
                super(2, dVar);
                this.this$0 = cVar;
                this.$uri = uri;
                this.$idList = str;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                return new a(this.this$0, this.$uri, this.$idList, dVar);
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
                c cVar = this.this$0;
                Uri uri = this.$uri;
                l0.o(uri, "$uri");
                return cVar.u(uri, 0, n.a.a("_id IN (", this.$idList, ")"), null, null);
            }

            @m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: c4.c$b$b, reason: collision with other inner class name */
        @f(c = "com.transsion.backup.album.AlbumManagerPad$getAlbumFileByIds$2$deferred$1$2$1", f = "AlbumManagerPad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0057b extends o implements p<s0, um.d<? super List<? extends AlbumFile>>, Object> {
            final /* synthetic */ String $idList;
            final /* synthetic */ Uri $uri;
            int label;
            final /* synthetic */ c this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0057b(c cVar, Uri uri, String str, um.d<? super C0057b> dVar) {
                super(2, dVar);
                this.this$0 = cVar;
                this.$uri = uri;
                this.$idList = str;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                return new C0057b(this.this$0, this.$uri, this.$idList, dVar);
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
                c cVar = this.this$0;
                Uri uri = this.$uri;
                l0.o(uri, "$uri");
                return cVar.u(uri, 1, n.a.a("_id IN (", this.$idList, ")"), null, null);
            }

            @m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
                return ((C0057b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List<Long> list, c cVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$ids = list;
            this.this$0 = cVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            b bVar = new b(this.$ids, this.this$0, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super List<? extends AlbumFile>> dVar) {
            return invoke2(s0Var, (um.d<? super List<AlbumFile>>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            Object objA;
            um.d dVar;
            Collection collection;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                s0 s0Var = (s0) this.L$0;
                if (this.$ids.isEmpty()) {
                    return k0.INSTANCE;
                }
                List<Long> list = this.$ids;
                c cVar = this.this$0;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    AlbumFile albumFile = (AlbumFile) cVar.f1351e.get(new Long(((Number) it.next()).longValue()));
                    if (albumFile != null) {
                        arrayList.add(albumFile);
                    }
                }
                if (arrayList.size() == this.$ids.size()) {
                    return arrayList;
                }
                List<Long> list2 = this.$ids;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    long jLongValue = ((Number) obj2).longValue();
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        do {
                            if (it2.hasNext()) {
                            }
                        } while (((AlbumFile) it2.next()).getId() != jLongValue);
                    }
                    arrayList2.add(obj2);
                }
                List listP1 = h0.P1(arrayList2, 20);
                c cVar2 = this.this$0;
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = listP1.iterator();
                while (it3.hasNext()) {
                    String strM3 = h0.m3((List) it3.next(), g.f9491d, null, null, 0, null, null, 62, null);
                    List list3 = cVar2.f1354h;
                    int i11 = 10;
                    ArrayList arrayList4 = new ArrayList(z.b0(list3, 10));
                    Iterator it4 = list3.iterator();
                    while (true) {
                        dVar = null;
                        if (!it4.hasNext()) {
                            break;
                        }
                        arrayList4.add(k.b(s0Var, null, null, new a(cVar2, (Uri) it4.next(), strM3, null), 3, null));
                        i11 = i11;
                    }
                    List<Uri> list4 = cVar2.f1355i;
                    ArrayList arrayList5 = new ArrayList(z.b0(list4, i11));
                    Iterator<T> it5 = list4.iterator();
                    while (it5.hasNext()) {
                        s0 s0Var2 = s0Var;
                        s0 s0Var3 = s0Var;
                        ArrayList arrayList6 = arrayList5;
                        arrayList6.add(k.b(s0Var2, null, null, new C0057b(cVar2, (Uri) it5.next(), strM3, dVar), 3, null));
                        arrayList5 = arrayList6;
                        dVar = dVar;
                        s0Var = s0Var3;
                    }
                    d0.r0(arrayList3, h0.E4(arrayList4, arrayList5));
                    s0Var = s0Var;
                }
                this.L$0 = arrayList;
                this.label = 1;
                objA = nq.f.a(arrayList3, this);
                collection = arrayList;
                if (objA == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Collection collection2 = (Collection) this.L$0;
                d1.n(obj);
                collection = collection2;
                objA = obj;
            }
            return h0.E4(collection, z.d0((Iterable) objA));
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@l s0 s0Var, @m um.d<? super List<AlbumFile>> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: c4.c$c, reason: collision with other inner class name */
    public static final class C0058c extends ContentObserver {
        public C0058c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            k4.m.b(c.f1344k, "Media content changed, debounce fetch");
            c.this.p();
        }
    }

    @r1({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 AlbumManagerPad.kt\ncom/transsion/backup/album/AlbumManagerPad\n*L\n1#1,18:1\n40#2:19\n*E\n"})
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IllegalAccessException, IOException, InvocationTargetException {
            c.this.t();
        }
    }

    public c(@l Application application) {
        l0.p(application, "context");
        this.f1347a = application;
        this.f1348b = new ArrayList();
        this.f1350d = new Handler(Looper.getMainLooper());
        this.f1351e = nm.d1.z();
        this.f1353g = new d();
        this.f1354h = y.O(MediaStore.Images.Media.getContentUri("external_primary"), MediaStore.Images.Media.getContentUri("external"));
        this.f1355i = y.O(MediaStore.Video.Media.getContentUri("external_primary"), MediaStore.Video.Media.getContentUri("external"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.f1350d.removeCallbacks(this.f1353g);
        this.f1350d.postDelayed(this.f1353g, 500L);
    }

    private final AlbumFile q(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        String strA = a(j10);
        if (strA == null) {
            return null;
        }
        Uri uriR = r(j10);
        if (l0.g(uriR, Uri.EMPTY)) {
            return null;
        }
        return (AlbumFile) h0.G2(u(uriR, !e0.s2(strA, "image", false, 2, null) ? 1 : 0, "_id = ?", new String[]{String.valueOf(j10)}, null));
    }

    private final Uri r(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        String strA = a(j10);
        if (strA != null) {
            return d4.c.d(strA);
        }
        Uri uri = Uri.EMPTY;
        l0.o(uri, "EMPTY");
        return uri;
    }

    private final List<AlbumFile> s(Uri uri, int i10) {
        return u(uri, i10, null, null, "date_added DESC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() throws IllegalAccessException, IOException, InvocationTargetException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Uri uri : h0.E4(this.f1354h, this.f1355i)) {
            String string = uri.toString();
            l0.o(string, "toString(...)");
            int i10 = !jq.h0.T2(string, "image", false, 2, null) ? 1 : 0;
            l0.m(uri);
            for (AlbumFile albumFile : s(uri, i10)) {
                linkedHashMap.put(Long.valueOf(albumFile.getId()), albumFile);
            }
        }
        Collection collectionValues = linkedHashMap.values();
        ArrayList<AlbumFile> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!this.f1351e.containsKey(Long.valueOf(((AlbumFile) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(z.b0(arrayList, 10));
        for (AlbumFile albumFile2 : arrayList) {
            arrayList2.add(albumFile2.copy((255 & 1) != 0 ? albumFile2.f1827id : 0L, (255 & 2) != 0 ? albumFile2.name : null, (255 & 4) != 0 ? albumFile2.size : 0L, (255 & 8) != 0 ? albumFile2.path : null, (255 & 16) != 0 ? albumFile2.type : 0, (255 & 32) != 0 ? albumFile2.albumName : null, (255 & 64) != 0 ? albumFile2.albumId : 0L, (255 & 128) != 0 ? albumFile2.createDate : 0L, (255 & 256) != 0 ? albumFile2.isDeleted : null));
        }
        Collection<AlbumFile> collectionValues2 = this.f1351e.values();
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
            AlbumFile albumFileQ = q(albumFile4.getId());
            if (albumFileQ != null) {
                listY5.remove(albumFile4);
                listY5.add(albumFileQ);
            }
        }
        this.f1351e = linkedHashMap;
        if (listY5.isEmpty()) {
            return;
        }
        k4.m.b(f1344k, "Detected changes: New files: " + arrayList2.size() + ", Deleted files: " + arrayList4.size());
        this.f1352f = null;
        Iterator<T> it = this.f1348b.iterator();
        while (it.hasNext()) {
            ((f4.a) it.next()).a(listY5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AlbumFile> u(Uri uri, int i10, String str, String[] strArr, String str2) throws IllegalAccessException, IOException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f1347a.getContentResolver().query(uri, d4.c.e(), str, strArr, str2);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    arrayList.add(d4.c.i(cursor2, i10, this.f1347a));
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

    private final void v() {
        ContentObserver contentObserver = this.f1349c;
        if (contentObserver != null) {
            Iterator it = h0.E4(this.f1354h, this.f1355i).iterator();
            while (it.hasNext()) {
                this.f1347a.getContentResolver().registerContentObserver((Uri) it.next(), true, contentObserver);
            }
        }
    }

    @Override // c4.d
    @m
    public String a(long j10) throws IllegalAccessException, IOException, InvocationTargetException {
        Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), j10);
        l0.o(uriWithAppendedId, "withAppendedId(...)");
        Cursor cursorQuery = this.f1347a.getContentResolver().query(uriWithAppendedId, new String[]{"mime_type"}, null, null, null);
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
        Uri uriR = r(j10);
        if (l0.g(uriR, Uri.EMPTY)) {
            return null;
        }
        try {
            Bitmap bitmapLoadThumbnail = this.f1347a.getContentResolver().loadThumbnail(ContentUris.withAppendedId(uriR, j10), new Size(256, 256), null);
            l0.o(bitmapLoadThumbnail, "loadThumbnail(...)");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapLoadThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            k4.m.c(f1344k, "getThumb error");
            return null;
        }
    }

    @Override // c4.d
    @m
    public Object c(@l List<Long> list, @l um.d<? super List<AlbumFile>> dVar) {
        return t0.g(new b(list, this, null), dVar);
    }

    @Override // c4.d
    public void d(@l f4.a aVar) {
        l0.p(aVar, "listener");
        if (this.f1348b.contains(aVar)) {
            k4.m.b(f1344k, "listener already registered");
        } else {
            this.f1348b.add(aVar);
            k4.m.b(f1344k, "added listener");
        }
        if (this.f1349c != null) {
            k4.m.b(f1344k, "registerAlbumDataChangeListener: media observer already exists");
            return;
        }
        if (this.f1351e.isEmpty()) {
            k4.m.b(f1344k, "registerAlbumDataChangeListener: preload all data");
            e();
        }
        this.f1349c = new C0058c(this.f1350d);
        v();
        k4.m.e(f1344k, "registerAlbumDataChangeListener: media observer registered");
    }

    @Override // c4.d
    @l
    public List<AlbumFile> e() {
        if (!this.f1351e.isEmpty()) {
            k4.m.b(f1344k, "Return cached data");
            return h0.V5(this.f1351e.values());
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : this.f1354h) {
            l0.m(uri);
            arrayList.addAll(s(uri, 0));
        }
        for (Uri uri2 : this.f1355i) {
            l0.m(uri2);
            arrayList.addAll(s(uri2, 1));
        }
        int iJ = c1.j(z.b0(arrayList, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((AlbumFile) obj).getId()), obj);
        }
        this.f1351e = linkedHashMap;
        return arrayList;
    }

    @Override // c4.d
    @l
    public InputStream f(long j10) throws FileNotFoundException {
        Uri uriWithAppendedId = ContentUris.withAppendedId(r(j10), j10);
        l0.o(uriWithAppendedId, "withAppendedId(...)");
        InputStream inputStreamOpenInputStream = this.f1347a.getContentResolver().openInputStream(uriWithAppendedId);
        return inputStreamOpenInputStream == null ? new ByteArrayInputStream(new byte[0]) : inputStreamOpenInputStream;
    }

    @Override // c4.d
    public boolean g(@l List<Long> list) throws IllegalAccessException, IOException, InvocationTargetException {
        l2 l2Var;
        l0.p(list, "ids");
        if (list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            String strA = a(jLongValue);
            if (strA == null) {
                k4.m.c(f1344k, "File with ID: " + jLongValue + " does not exist");
            } else {
                Uri uriR = r(jLongValue);
                if (l0.g(uriR, Uri.EMPTY)) {
                    k4.m.c(f1344k, "Unsupported content URI for ID: " + jLongValue + ", mime=" + strA);
                } else {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uriR, jLongValue);
                    l0.o(uriWithAppendedId, "withAppendedId(...)");
                    Cursor cursorQuery = this.f1347a.getContentResolver().query(uriWithAppendedId, null, null, null, null);
                    if (cursorQuery != null) {
                        Cursor cursor = cursorQuery;
                        try {
                            if (cursor.moveToFirst()) {
                                l2Var = l2.f10208a;
                                dn.c.a(cursor, null);
                            } else {
                                k4.m.c(f1344k, "File with ID: " + jLongValue + " not found for deletion");
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
                        k4.m.c(f1344k, "Query failed for ID: " + jLongValue + " before deletion");
                    } else if (this.f1347a.getContentResolver().delete(uriWithAppendedId, null, null) > 0) {
                        k4.m.e(f1344k, "Deleted file with ID: " + jLongValue);
                    } else {
                        k4.m.c(f1344k, "Failed to delete file with ID: " + jLongValue);
                    }
                }
            }
            z10 = false;
        }
        return z10;
    }

    @Override // c4.d
    public void h(@l f4.a aVar) {
        l0.p(aVar, "listener");
        this.f1348b.remove(aVar);
        if (this.f1348b.isEmpty() && this.f1349c != null) {
            ContentResolver contentResolver = this.f1347a.getContentResolver();
            ContentObserver contentObserver = this.f1349c;
            l0.m(contentObserver);
            contentResolver.unregisterContentObserver(contentObserver);
            this.f1349c = null;
        }
        this.f1351e = nm.d1.z();
        this.f1352f = null;
    }

    @Override // c4.d
    @l
    public List<AlbumInfo> i() {
        List<AlbumInfo> list = this.f1352f;
        if (list == null) {
            List<AlbumInfo> listB = d4.c.b(e());
            this.f1352f = listB;
            return listB;
        }
        k4.m.b(f1344k, "Returning cached album info " + list);
        return list;
    }
}
