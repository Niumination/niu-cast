package xj;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends a {
    private static final long serialVersionUID = -7041884104854048950L;

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atDebug() {
        return super.atDebug();
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atError() {
        return super.atError();
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atInfo() {
        return super.atInfo();
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atLevel(wj.b bVar) {
        return super.atLevel(bVar);
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atTrace() {
        return super.atTrace();
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atWarn() {
        return super.atWarn();
    }

    @Override // xj.a, vj.b
    public abstract /* synthetic */ boolean isDebugEnabled();

    @Override // xj.a
    public boolean isDebugEnabled(vj.e eVar) {
        return isDebugEnabled();
    }

    @Override // xj.a, vj.b
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(wj.b bVar) {
        return super.isEnabledForLevel(bVar);
    }

    @Override // xj.a, vj.b
    public abstract /* synthetic */ boolean isErrorEnabled();

    @Override // xj.a
    public boolean isErrorEnabled(vj.e eVar) {
        return isErrorEnabled();
    }

    @Override // xj.a, vj.b
    public abstract /* synthetic */ boolean isInfoEnabled();

    @Override // xj.a
    public boolean isInfoEnabled(vj.e eVar) {
        return isInfoEnabled();
    }

    @Override // xj.a, vj.b
    public abstract /* synthetic */ boolean isTraceEnabled();

    @Override // xj.a
    public boolean isTraceEnabled(vj.e eVar) {
        return isTraceEnabled();
    }

    @Override // xj.a, vj.b
    public abstract /* synthetic */ boolean isWarnEnabled();

    @Override // xj.a
    public boolean isWarnEnabled(vj.e eVar) {
        return isWarnEnabled();
    }

    @Override // xj.a, vj.b
    public yj.a makeLoggingEventBuilder(wj.b bVar) {
        return new yj.b();
    }
}
