package androidx.camera.video;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements MediaScannerConnection.OnScanCompletedListener {
    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String str, Uri uri) {
        Recorder.RecordingRecord.lambda$initializeRecording$3(str, uri);
    }
}
