package com.iminit.weixin;

import com.jfinal.weixin.iot.msg.InEquDataMsg;
import com.jfinal.weixin.iot.msg.InEqubindEvent;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.msg.in.*;
import com.jfinal.weixin.sdk.msg.in.card.*;
import com.jfinal.weixin.sdk.msg.in.event.*;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.*;

public class WeixinMsgController extends MsgController {

    private static final String helpStr = "有任何问题请留言，24h小时内回复您的信息";
    public ApiConfig getApiConfig() {
        return null;
    }

    protected void processInTextMsg(InTextMsg inTextMsg) {
        String msgContent = inTextMsg.getContent().trim();
        // 帮助提示
        if ("help".equalsIgnoreCase(msgContent)) {
            OutTextMsg outMsg = new OutTextMsg(inTextMsg);
            outMsg.setContent(helpStr);
            render(outMsg);
        }
        // 图文消息测试
        else if ("news".equalsIgnoreCase(msgContent)) {
            OutNewsMsg outMsg = new OutNewsMsg(inTextMsg);
            outMsg.addNews("图文消息title", "图文消息description", "图文消息片 url", "图文消息 url");
            render(outMsg);
        }
        // 音乐消息测试
        else if ("music".equalsIgnoreCase(msgContent)) {
            OutMusicMsg outMsg = new OutMusicMsg(inTextMsg);
            outMsg.setTitle("Day By Day");
            outMsg.setDescription("建议在 WIFI 环境下流畅欣赏此音乐");
            outMsg.setMusicUrl("http://www.jfinal.com/DayByDay-T-ara.mp3");
            outMsg.setHqMusicUrl("http://www.jfinal.com/DayByDay-T-ara.mp3");
            outMsg.setFuncFlag(true);
            render(outMsg);
        }
        else if ("美女".equalsIgnoreCase(msgContent)) {
            OutNewsMsg outMsg = new OutNewsMsg(inTextMsg);
            outMsg.addNews("秀色可餐", "JFinal Weixin 极速开发就是这么爽，有木有 ^_^", "http://mmbiz.qpic.cn/mmbiz/zz3Q6WSrzq2GJLC60ECD7rE7n1cvKWRNFvOyib4KGdic3N5APUWf4ia3LLPxJrtyIYRx93aPNkDtib3ADvdaBXmZJg/0", "http://mp.weixin.qq.com/s?__biz=MjM5ODAwOTU3Mg==&mid=200987822&idx=1&sn=7eb2918275fb0fa7b520768854fb7b80#rd");
            render(outMsg);
        }
        // 其它文本消息直接返回原值 + 帮助提示
        else {
            OutTextMsg outMsg = new OutTextMsg(inTextMsg);
            outMsg.setContent("\t文本消息已成功接收，内容为： " + inTextMsg.getContent() + "\n\n" + helpStr);
            render(outMsg);
        }
    }

    protected void processInImageMsg(InImageMsg inImageMsg) {
        OutImageMsg outMsg = new OutImageMsg(inImageMsg);
        // 将刚发过来的图片再发回去
        outMsg.setMediaId(inImageMsg.getMediaId());
        render(outMsg);
    }

    protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {
        OutVoiceMsg outMsg = new OutVoiceMsg(inVoiceMsg);
        // 将刚发过来的语音再发回去
        outMsg.setMediaId(inVoiceMsg.getMediaId());
        render(outMsg);
    }

    protected void processInVideoMsg(InVideoMsg inVideoMsg) {
		/* 腾讯 api 有 bug，无法回复视频消息，暂时回复文本消息代码测试
		OutVideoMsg outMsg = new OutVideoMsg(inVideoMsg);
		outMsg.setTitle("OutVideoMsg 发送");
		outMsg.setDescription("刚刚发来的视频再发回去");
		// 将刚发过来的视频再发回去，经测试证明是腾讯官方的 api 有 bug，待 api bug 却除后再试
		outMsg.setMediaId(inVideoMsg.getMediaId());
		render(outMsg);
		*/
        OutTextMsg outMsg = new OutTextMsg(inVideoMsg);
        outMsg.setContent("\t视频消息已成功接收，该视频的 mediaId 为: " + inVideoMsg.getMediaId());
        render(outMsg);
    }

    protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {

    }

    protected void processInLocationMsg(InLocationMsg inLocationMsg) {
        OutTextMsg outMsg = new OutTextMsg(inLocationMsg);
        outMsg.setContent("已收到地理位置消息:" +
                "\nlocation_X = " + inLocationMsg.getLocation_X() +
                "\nlocation_Y = " + inLocationMsg.getLocation_Y() +
                "\nscale = " + inLocationMsg.getScale() +
                "\nlabel = " + inLocationMsg.getLabel());
        render(outMsg);
    }

    protected void processInLinkMsg(InLinkMsg inLinkMsg) {
        OutNewsMsg outMsg = new OutNewsMsg(inLinkMsg);
        outMsg.addNews("链接消息已成功接收", "链接使用图文消息的方式发回给你，还可以使用文本方式发回。点击图文消息可跳转到链接地址页面，是不是很好玩 :)" , "http://mmbiz.qpic.cn/mmbiz/zz3Q6WSrzq1ibBkhSA1BibMuMxLuHIvUfiaGsK7CC4kIzeh178IYSHbYQ5eg9tVxgEcbegAu22Qhwgl5IhZFWWXUw/0", inLinkMsg.getUrl());
        render(outMsg);
    }

    protected void processInCustomEvent(InCustomEvent inCustomEvent) {

    }

    protected void processInFollowEvent(InFollowEvent inFollowEvent) {
        OutTextMsg outMsg = new OutTextMsg(inFollowEvent);
        outMsg.setContent("感谢关注 JFinal Weixin 极速开发，为您节约更多时间，去陪恋人、家人和朋友 :) \n\n\n " + helpStr);
        // 如果为取消关注事件，将无法接收到传回的信息
        render(outMsg);
    }

    protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {
        OutTextMsg outMsg = new OutTextMsg(inQrCodeEvent);
        outMsg.setContent("processInQrCodeEvent() 方法测试成功");
        render(outMsg);
    }

    protected void processInLocationEvent(InLocationEvent inLocationEvent) {
        OutTextMsg outMsg = new OutTextMsg(inLocationEvent);
        outMsg.setContent("processInLocationEvent() 方法测试成功");
        render(outMsg);
    }

    protected void processInMassEvent(InMassEvent inMassEvent) {

    }

    protected void processInMenuEvent(InMenuEvent inMenuEvent) {
        OutTextMsg outMsg = new OutTextMsg(inMenuEvent);
        outMsg.setContent("processInMenuEvent() 方法测试成功");
        render(outMsg);
    }

    protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults) {
        OutTextMsg outMsg = new OutTextMsg(inSpeechRecognitionResults);
        outMsg.setContent("processInSpeechRecognitionResults() 方法测试成功");
        render(outMsg);
    }

    protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {

    }

    protected void processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {

    }

    protected void processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent) {

    }

    protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {

    }

    protected void processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {

    }

    protected void processInWifiEvent(InWifiEvent inWifiEvent) {

    }

    protected void processInUserCardEvent(InUserCardEvent inUserCardEvent) {

    }

    protected void processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent) {

    }

    protected void processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent) {

    }

    protected void processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent) {

    }

    protected void processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {

    }

    protected void processIsNotDefinedMsg(InNotDefinedMsg inNotDefinedMsg) {

    }

    protected void processInUserGiftingCardEvent(InUserGiftingCardEvent inUserGiftingCardEvent) {

    }

    protected void processInUserGetCardEvent(InUserGetCardEvent inUserGetCardEvent) {

    }

    protected void processInUserConsumeCardEvent(InUserConsumeCardEvent inUserConsumeCardEvent) {

    }

    protected void processInCardSkuRemindEvent(InCardSkuRemindEvent inCardSkuRemindEvent) {

    }

    protected void processInCardPayOrderEvent(InCardPayOrderEvent inCardPayOrderEvent) {

    }

    protected void processInCardPassCheckEvent(InCardPassCheckEvent inCardPassCheckEvent) {

    }

    protected void processInEqubindEvent(InEqubindEvent inEqubindEvent) {

    }

    protected void processInEquDataMsg(InEquDataMsg inEquDataMsg) {

    }

}