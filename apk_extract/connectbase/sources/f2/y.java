package f2;

import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import java.io.File;
import lm.t0;

/* JADX INFO: loaded from: classes.dex */
public interface y {
    void a();

    void b();

    void c(@os.l g2.c cVar);

    void d(boolean z10, boolean z11);

    void e(@os.l File file);

    void f(@os.l AssetManager assetManager, @os.l String str);

    void g(@os.m i2.b bVar);

    @os.l
    t0<Integer, Integer> getRealSize();

    @os.m
    SurfaceTexture getSurfaceTexture();

    boolean isRunning();

    void setAnimListener(@os.m h2.a aVar);

    void setFetchResource(@os.m h2.b bVar);

    void setFps(int i10);

    void setLoop(int i10);

    void setMute(boolean z10);

    void setOnResourceClickListener(@os.m h2.c cVar);

    void setScaleType(@os.l l2.e eVar);

    void setScaleType(@os.l l2.g gVar);
}
