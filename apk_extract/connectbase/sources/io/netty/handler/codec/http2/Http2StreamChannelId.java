package io.netty.handler.codec.http2;

import el.b0;
import io.netty.channel.ChannelId;

/* JADX INFO: loaded from: classes3.dex */
final class Http2StreamChannelId implements ChannelId {
    private static final long serialVersionUID = -6642338822166867585L;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f8318id;
    private final ChannelId parentId;

    public Http2StreamChannelId(ChannelId channelId, int i10) {
        this.parentId = channelId;
        this.f8318id = i10;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return this.parentId.asLongText() + b0.f4502a + this.f8318id;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return this.parentId.asShortText() + b0.f4502a + this.f8318id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2StreamChannelId)) {
            return false;
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) obj;
        return this.f8318id == http2StreamChannelId.f8318id && this.parentId.equals(http2StreamChannelId.parentId);
    }

    public int hashCode() {
        return this.parentId.hashCode() + (this.f8318id * 31);
    }

    public String toString() {
        return asShortText();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (!(channelId instanceof Http2StreamChannelId)) {
            return this.parentId.compareTo(channelId);
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) channelId;
        int iCompareTo = this.parentId.compareTo(http2StreamChannelId.parentId);
        return iCompareTo == 0 ? this.f8318id - http2StreamChannelId.f8318id : iCompareTo;
    }
}
