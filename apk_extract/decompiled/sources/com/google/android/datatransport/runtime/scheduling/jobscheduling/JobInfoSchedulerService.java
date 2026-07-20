package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import d2.c;
import d2.d;
import d2.j;
import d2.l;
import i2.e;
import i2.g;
import i2.i;
import m2.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1772a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i8 = jobParameters.getExtras().getInt("priority");
        int i9 = jobParameters.getExtras().getInt("attemptNumber");
        l.b(getApplicationContext());
        c cVarA = j.a();
        if (string == null) {
            throw new NullPointerException("Null backendName");
        }
        cVarA.f4266a = string;
        cVarA.f4268c = a.b(i8);
        if (string2 != null) {
            cVarA.f4267b = Base64.decode(string2, 0);
        }
        i iVar = l.a().f4288d;
        d dVarA = cVarA.a();
        e eVar = new e(0, this, jobParameters);
        iVar.getClass();
        iVar.e.execute(new g(iVar, dVarA, i9, eVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
