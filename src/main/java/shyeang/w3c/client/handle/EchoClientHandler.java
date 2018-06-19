package shyeang.w3c.client.handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import shyeang.w3c.client.EchoClient;
import shyeang.w3c.server.handle.EchoServerHandler;

@ChannelHandler.Sharable                                //1
public class EchoClientHandler extends
        SimpleChannelInboundHandler<ByteBuf> {
    private  int clientCount;
    public  EchoClientHandler(int count){
        clientCount = count;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("------channelActive--------" + ":--clientCount:" + clientCount);
        ctx.writeAndFlush(Unpooled.copiedBuffer("client Netty rocks!", //2
                CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             ByteBuf in) {
        System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));    //3
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----acceptInboundMessage----" + ":--clientCount:" + clientCount);
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelRead----" + ":--clientCount:" + clientCount);
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelRegistered----" + ":--clientCount:" + clientCount);
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelUnregistered----" + ":--clientCount:" + clientCount);
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelInactive----" + ":--clientCount:" + clientCount);
        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelReadComplete----" + ":--clientCount:" + clientCount);
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----userEventTriggered----" + ":--clientCount:" + clientCount);
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----channelWritabilityChanged----" + ":--clientCount:" + clientCount);
        super.channelWritabilityChanged(ctx);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----ensureNotSharable----" + ":--clientCount:" + clientCount);
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----isSharable----" + ":--clientCount:" + clientCount);
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----handlerAdded----" + ":--clientCount:" + clientCount);
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(EchoServerHandler.count++ + ":client:" + "----handlerRemoved----" + ":--clientCount:" + clientCount);
        super.handlerRemoved(ctx);
    }
}

