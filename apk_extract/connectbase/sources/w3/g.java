package w3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s3.f f17918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f17919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n3.a f17921f;

    public g(s3.f fVar, long j10, n3.a aVar) {
        int iL = s3.e.l(k6.g.h0());
        this.f17920e = iL;
        if (fVar.z() > 0 && iL != fVar.o()) {
            y3.b.f("dimensionChanged, so set appConfig version to 0");
            fVar.m(0L);
        }
        this.f17918c = fVar;
        this.f17919d = j10;
        this.f17921f = aVar;
    }

    @Override // w3.c
    public void a() throws Throwable {
        String string;
        try {
            JSONObject jSONObjectG = s3.e.g(k6.g.h0());
            jSONObjectG.put("sname", String.valueOf(this.f17918c.g()));
            jSONObjectG.put("sdkver", s3.g.a(this.f17918c.g()));
            string = jSONObjectG.toString();
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
            string = "";
        }
        l<String> lVarE = d.e(s3.g.b(this.f17918c.k()), string, this.f17918c.z(), this.f17918c.g());
        int i10 = lVarE.f17928a;
        boolean z10 = true;
        if (i10 != 0) {
            if (i10 != 1) {
                s3.f fVar = this.f17918c;
                fVar.s(fVar.v() + 1);
            } else {
                y3.b.g("<-- appIdConfig:%s", "NOT_MODIFIED");
                this.f17918c.i(this.f17920e);
                this.f17918c.j(System.currentTimeMillis() + this.f17919d);
            }
            z10 = false;
        } else {
            String str = lVarE.f17929b;
            y3.b.g("<-- appIdConfig:%s", str);
            n3.b.l().j(this.f17918c, str);
            this.f17918c.i(this.f17920e);
            if (this.f17918c.r() > 0) {
                this.f17919d = ((long) this.f17918c.r()) * 3600000;
            }
            this.f17918c.j(System.currentTimeMillis() + this.f17919d);
        }
        n3.a aVar = this.f17921f;
        if (aVar != null) {
            aVar.a(this.f17918c.g(), z10);
        }
    }

    @Override // w3.c
    public String c() {
        return "Retrieve-" + this.f17918c.g() + "-Config";
    }
}
