package i2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.zip.Adler32;
import k3.d2;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j2.c f5536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5537c;

    public d(Context context, j2.c cVar, b bVar) {
        this.f5535a = context;
        this.f5536b = cVar;
        this.f5537c = bVar;
    }

    public final void a(d2.j jVar, int i8, boolean z2) {
        Context context = this.f5535a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        d2.d dVar = (d2.d) jVar;
        adler32.update(dVar.f4269a.getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(m2.a.a(dVar.f4271c)).array());
        byte[] bArr = dVar.f4270b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z2) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i9 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i9 < i8) {
                        break;
                    }
                    d2.a(jVar, "JobInfoScheduler", "Upload for context %s is already scheduled. Returning...");
                    return;
                }
            }
        }
        Cursor cursorRawQuery = ((j2.h) this.f5536b).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{dVar.f4269a, String.valueOf(m2.a.a(dVar.f4271c))});
        try {
            Cursor cursor = cursorRawQuery;
            Long lValueOf = cursor.moveToNext() ? Long.valueOf(cursor.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            d2.d dVar2 = (d2.d) jVar;
            b bVar = this.f5537c;
            a2.c cVar = dVar2.f4271c;
            builder.setMinimumLatency(bVar.a(cVar, jLongValue, i8));
            Set set = ((c) bVar.f5531b.get(cVar)).f5534c;
            if (set.contains(f.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(f.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(f.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i8);
            persistableBundle.putString("backendName", dVar2.f4269a);
            persistableBundle.putInt("priority", m2.a.a(cVar));
            byte[] bArr2 = dVar2.f4270b;
            if (bArr2 != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr2, 0));
            }
            builder.setExtras(persistableBundle);
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", jVar, Integer.valueOf(value), Long.valueOf(bVar.a(cVar, jLongValue, i8)), lValueOf, Integer.valueOf(i8)));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th2) {
            cursorRawQuery.close();
            throw th2;
        }
    }
}
