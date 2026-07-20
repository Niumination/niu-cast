package io.netty.channel.unix;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GenericUnixChannelOption<T> extends UnixChannelOption<T> {
    private final int level;
    private final int optname;

    public GenericUnixChannelOption(String str, int i10, int i11) {
        super(str);
        this.level = i10;
        this.optname = i11;
    }

    public int level() {
        return this.level;
    }

    public int optname() {
        return this.optname;
    }
}
