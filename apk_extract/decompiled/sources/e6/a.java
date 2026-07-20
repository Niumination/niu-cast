package e6;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaExtractor;
import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4694a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Closeable f4696c;

    public a(AssetManager assetManager, String assetsPath) throws IOException {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        AssetFileDescriptor assetFileDescriptorOpenFd = assetManager.openFd(assetsPath);
        Intrinsics.checkNotNullExpressionValue(assetFileDescriptorOpenFd, "assetManager.openFd(assetsPath)");
        this.f4695b = assetFileDescriptorOpenFd;
        this.f4696c = (AssetManager.AssetInputStream) assetManager.open(assetsPath, 2);
        Intrinsics.checkNotNullParameter("AnimPlayer.FileContainer", "tag");
        Intrinsics.checkNotNullParameter("AssetsFileContainer init", NotificationCompat.CATEGORY_MESSAGE);
    }

    @Override // e6.b
    public final void a() {
        switch (this.f4694a) {
            case 0:
                Intrinsics.checkNotNullParameter("AnimPlayer.FileContainer", "tag");
                Intrinsics.checkNotNullParameter("AssetsFileContainer startRandomRead", NotificationCompat.CATEGORY_MESSAGE);
                break;
            default:
                this.f4696c = new RandomAccessFile((File) this.f4695b, "r");
                break;
        }
    }

    @Override // e6.b
    public final int b(int i8, byte[] b9) {
        switch (this.f4694a) {
            case 0:
                Intrinsics.checkNotNullParameter(b9, "b");
                return ((AssetManager.AssetInputStream) this.f4696c).read(b9, 0, i8);
            default:
                Intrinsics.checkNotNullParameter(b9, "b");
                RandomAccessFile randomAccessFile = (RandomAccessFile) this.f4696c;
                if (randomAccessFile == null) {
                    return -1;
                }
                return randomAccessFile.read(b9, 0, i8);
        }
    }

    @Override // e6.b
    public final void c() throws IOException {
        switch (this.f4694a) {
            case 0:
                ((AssetManager.AssetInputStream) this.f4696c).close();
                break;
            default:
                RandomAccessFile randomAccessFile = (RandomAccessFile) this.f4696c;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    break;
                }
                break;
        }
    }

    @Override // e6.b
    public final void close() throws IOException {
        switch (this.f4694a) {
            case 0:
                ((AssetFileDescriptor) this.f4695b).close();
                ((AssetManager.AssetInputStream) this.f4696c).close();
                break;
            default:
                Intrinsics.checkNotNullParameter("AnimPlayer.FileContainer", "tag");
                Intrinsics.checkNotNullParameter("FileContainer close", NotificationCompat.CATEGORY_MESSAGE);
                break;
        }
    }

    @Override // e6.b
    public final void d(MediaExtractor extractor) throws IOException {
        switch (this.f4694a) {
            case 0:
                Intrinsics.checkNotNullParameter(extractor, "extractor");
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) this.f4695b;
                if (assetFileDescriptor.getDeclaredLength() >= 0) {
                    extractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                } else {
                    extractor.setDataSource(assetFileDescriptor.getFileDescriptor());
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(extractor, "extractor");
                extractor.setDataSource(((File) this.f4695b).toString());
                break;
        }
    }

    @Override // e6.b
    public final void skip(long j8) throws IOException {
        switch (this.f4694a) {
            case 0:
                ((AssetManager.AssetInputStream) this.f4696c).skip(j8);
                break;
            default:
                RandomAccessFile randomAccessFile = (RandomAccessFile) this.f4696c;
                if (randomAccessFile != null) {
                    randomAccessFile.skipBytes((int) j8);
                    break;
                }
                break;
        }
    }

    public a(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f4695b = file;
        Intrinsics.checkNotNullParameter("AnimPlayer.FileContainer", "tag");
        Intrinsics.checkNotNullParameter("FileContainer init", NotificationCompat.CATEGORY_MESSAGE);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new FileNotFoundException(Intrinsics.stringPlus("Unable to read ", file));
        }
    }
}
