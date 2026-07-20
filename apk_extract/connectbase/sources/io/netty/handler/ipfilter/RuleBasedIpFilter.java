package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final boolean acceptIfNotFound;
    private final List<IpFilterRule> rules;

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        this(true, ipFilterRuleArr);
    }

    public RuleBasedIpFilter(boolean z10, IpFilterRule... ipFilterRuleArr) {
        ObjectUtil.checkNotNull(ipFilterRuleArr, "rules");
        this.acceptIfNotFound = z10;
        this.rules = new ArrayList(ipFilterRuleArr.length);
        for (IpFilterRule ipFilterRule : ipFilterRuleArr) {
            if (ipFilterRule != null) {
                this.rules.add(ipFilterRule);
            }
        }
    }

    @Override // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) throws Exception {
        for (IpFilterRule ipFilterRule : this.rules) {
            if (ipFilterRule.matches(inetSocketAddress)) {
                return ipFilterRule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }
}
