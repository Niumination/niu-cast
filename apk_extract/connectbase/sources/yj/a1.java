package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends DefaultByteBufHolder implements k1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f20850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fm.b f20852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChannelPromise f20853d;

    public a1(d1 d1Var, ByteBuf byteBuf, boolean z10) {
        super(byteBuf);
        this.f20850a = d1Var;
        this.f20851b = z10;
        this.f20852c = fm.c.o();
    }

    @Override // yj.k1.c
    public final void a(Channel channel) {
        channel.write(this, this.f20853d);
    }

    @Override // yj.k1.c
    public fm.b b() {
        return this.f20852c;
    }

    @Override // yj.k1.c
    public void c(ChannelPromise channelPromise) {
        this.f20853d = channelPromise;
    }

    public boolean d() {
        return this.f20851b;
    }

    public d1 e() {
        return this.f20850a;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(a1.class)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return a1Var.f20850a.equals(this.f20850a) && a1Var.f20851b == this.f20851b && a1Var.content().equals(content());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int iHashCode = this.f20850a.hashCode() + (content().hashCode() * 31);
        return this.f20851b ? -iHashCode : iHashCode;
    }

    @Override // yj.k1.c
    public ChannelPromise promise() {
        return this.f20853d;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new a1(this.f20850a, byteBuf, this.f20851b);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return a1.class.getSimpleName() + "(streamId=" + this.f20850a.id() + ", endStream=" + this.f20851b + ", content=" + content() + ")";
    }
}
