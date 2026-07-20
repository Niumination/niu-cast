package d4;

import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import com.transsion.backup.model.PageData;
import com.transsion.backup.protos.BackupData;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import nm.h0;
import nm.k0;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nAlbumFileExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumFileExt.kt\ncom/transsion/backup/ext/AlbumFileExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1549#2:64\n1620#2,3:65\n1549#2:68\n1620#2,3:69\n*S KotlinDebug\n*F\n+ 1 AlbumFileExt.kt\ncom/transsion/backup/ext/AlbumFileExtKt\n*L\n24#1:64\n24#1:65,3\n32#1:68\n32#1:69,3\n*E\n"})
public final class a {
    @l
    public static final BackupData.AlbumFileInfo a(@l AlbumFile albumFile) {
        l0.p(albumFile, "<this>");
        BackupData.AlbumFileInfo.Builder createDate = BackupData.AlbumFileInfo.newBuilder().setId(albumFile.getId()).setName(albumFile.getName()).setSize(albumFile.getSize()).setType(albumFile.getType()).setAlbumId(albumFile.getAlbumId()).setCreateDate(albumFile.getCreateDate());
        Boolean boolIsDeleted = albumFile.isDeleted();
        BackupData.AlbumFileInfo albumFileInfoBuild = createDate.setIsDeleted(boolIsDeleted != null ? boolIsDeleted.booleanValue() : false).build();
        l0.o(albumFileInfoBuild, "build(...)");
        return albumFileInfoBuild;
    }

    @l
    public static final List<BackupData.AlbumFileInfo> b(@l List<AlbumFile> list) {
        l0.p(list, "<this>");
        List<AlbumFile> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(a((AlbumFile) it.next()));
        }
        return h0.V5(arrayList);
    }

    @l
    public static final BackupData.AlbumInfo c(@l AlbumInfo albumInfo) {
        l0.p(albumInfo, "<this>");
        BackupData.AlbumInfo albumInfoBuild = BackupData.AlbumInfo.newBuilder().setId(albumInfo.getAlbumId()).setName(albumInfo.getAlbumName()).build();
        l0.o(albumInfoBuild, "build(...)");
        return albumInfoBuild;
    }

    @l
    public static final List<BackupData.AlbumInfo> d(@l List<AlbumInfo> list) {
        l0.p(list, "<this>");
        List<AlbumInfo> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(c((AlbumInfo) it.next()));
        }
        return h0.V5(arrayList);
    }

    @l
    public static final BackupData e(@l PageData<AlbumFile> pageData, @m List<AlbumInfo> list) {
        Iterable<? extends BackupData.AlbumFileInfo> iterableB;
        Iterable<? extends BackupData.AlbumInfo> iterableD;
        l0.p(pageData, "<this>");
        List<AlbumFile> data = pageData.getData();
        if (data == null || (iterableB = b(data)) == null) {
            iterableB = k0.INSTANCE;
        }
        if (list == null || (iterableD = d(list)) == null) {
            iterableD = k0.INSTANCE;
        }
        BackupData backupDataBuild = BackupData.newBuilder().setCurrentPage(pageData.getCurrentPage()).setTotalPage(pageData.getTotalPage()).addAllFiles(iterableB).addAllAlbums(iterableD).build();
        l0.m(backupDataBuild);
        return backupDataBuild;
    }

    @l
    public static final BackupData f(@l List<AlbumFile> list, @m List<AlbumInfo> list2, int i10, int i11) {
        Iterable<? extends BackupData.AlbumInfo> iterableD;
        l0.p(list, "<this>");
        k4.m.e("toBackupData", "toBackupData albumFiles: " + list + " albumInfos:" + list2);
        List<BackupData.AlbumFileInfo> listB = b(list);
        if (list2 == null || (iterableD = d(list2)) == null) {
            iterableD = k0.INSTANCE;
        }
        k4.m.e("toBackupData", "toBackupData albumFileInfos: " + listB + " backupAlbumInfos:" + iterableD);
        BackupData backupDataBuild = BackupData.newBuilder().setCurrentPage(i10).setTotalPage(i11).addAllFiles(listB).addAllAlbums(iterableD).build();
        l0.m(backupDataBuild);
        return backupDataBuild;
    }

    public static /* synthetic */ BackupData g(PageData pageData, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = null;
        }
        return e(pageData, list);
    }

    public static /* synthetic */ BackupData h(List list, List list2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list2 = null;
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 1;
        }
        return f(list, list2, i10, i11);
    }

    @l
    public static final String i(@l BackupData backupData) {
        l0.p(backupData, "<this>");
        String strEncodeToString = Base64.getEncoder().encodeToString(backupData.toByteArray());
        l0.o(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
