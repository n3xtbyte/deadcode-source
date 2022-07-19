/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelDuplexHandler
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.ChannelPromise
 */
import i.gishreloaded.EventsHandler;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;

public class cw
extends ChannelDuplexHandler {
    private EventsHandler a;

    public cw(EventsHandler eventsHandler) {
        this.a = eventsHandler;
        try {
            ChannelPipeline channelPipeline = Wrapper.INSTANCE.getMinecraft().getConnection().getNetworkManager().channel().pipeline();
            channelPipeline.addBefore(\u200b\u2000.void()[11], \u200b\u2000.void()[12], (ChannelHandler)this);
            ChatUtils.debug("Connection: attached.");
        }
        catch (Exception exception) {
            ChatUtils.exception("Connection: Error on attaching.", exception);
        }
    }

    public void a(ChannelHandlerContext channelHandlerContext, Object object) {
        if (!this.a.a(object, bw.a)) {
            return;
        }
        super.channelRead(channelHandlerContext, object);
    }

    public void a(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) {
        if (!this.a.a(object, bw.b)) {
            return;
        }
        super.write(channelHandlerContext, object, channelPromise);
    }
}

