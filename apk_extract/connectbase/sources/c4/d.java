package c4;

import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import java.io.InputStream;
import java.util.List;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    @m
    String a(long j10);

    @m
    byte[] b(long j10);

    @m
    Object c(@l List<Long> list, @l um.d<? super List<AlbumFile>> dVar);

    void d(@l f4.a aVar);

    @l
    List<AlbumFile> e();

    @l
    InputStream f(long j10);

    boolean g(@l List<Long> list);

    void h(@l f4.a aVar);

    @l
    List<AlbumInfo> i();
}
