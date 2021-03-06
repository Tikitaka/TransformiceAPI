package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TribeChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatMessageResponse;


public class TribeChatMessageProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        TribeChatMessageResponse response = (TribeChatMessageResponse) command;
        player.notifyListeners(new TribeChatMessageEvent(response.getSender(), response.getMessage()));
    }

}
