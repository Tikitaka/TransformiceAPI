package ee.ignorance.transformiceapi.protocol.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;


public class NormalChatResponse extends AbstractResponse{

    private String sender;
    private String message;

    public NormalChatResponse(byte[] rawMessage) {
            super(rawMessage);
    }

    @Override
    public void parse(byte[] rawMessage) {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
            try {
                    int playerCode = in.readInt();
                    setSender(in.readUTF());
                    setMessage(in.readUTF());
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public void setSender(String sender){
            this.sender = sender;
    }

    public void setMessage(String message){
            this.message = message;
    }

    public String getSender(){
            return sender;
    }

    public String getMessage(){
            return message;
    }
}
