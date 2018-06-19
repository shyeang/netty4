package shyeang.w3c.server.handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoServerSecondHandler  extends
        ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println(EchoServerHandler.count++ + ":2server:" + "Server received: " + in.toString(CharsetUtil.UTF_8));        //2
        ctx.write(in);                            //3
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelReadComplete----");
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)//4
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----exceptionCaught----");
        cause.printStackTrace();                //5
        ctx.close();                            //6
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelRegistered----");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelUnregistered----");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelActive----");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelInactive----");
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----userEventTriggered----");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----channelWritabilityChanged----");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----ensureNotSharable----");
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----isSharable----");
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----handlerAdded----");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":2server:" + "----handlerRemoved----");
        super.handlerRemoved(ctx);
    }
}
