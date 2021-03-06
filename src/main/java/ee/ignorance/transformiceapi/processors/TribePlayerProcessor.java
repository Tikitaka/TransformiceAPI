package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TribePlayerConnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerDisconnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerJoinEvent;
import ee.ignorance.transformiceapi.event.TribePlayerQuitEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;


public class TribePlayerProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        TribePlayerResponse response = (TribePlayerResponse) command;
        if(response.getType() == 1){
            player.notifyListeners(new TribePlayerConnectEvent(response.getPlayerName()));
        }
        if(response.getType() == 2){
            player.notifyListeners(new TribePlayerDisconnectEvent(response.getPlayerName()));
        }
        if(response.getType() == 6){
            player.notifyListeners(new TribePlayerJoinEvent(response.getPlayerName()));
        }
        if(response.getType() == 11){
            player.notifyListeners(new TribePlayerQuitEvent(response.getPlayerName()));
        }
    }
}
