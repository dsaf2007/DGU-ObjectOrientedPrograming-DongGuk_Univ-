
public class TV implements on_off{

    public int channel=0;
    public String channel_name;
    public boolean on_off = false;
    public int prev_channel=0;
    public String prev_channel_name ="";
    public void On()
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("TV가 켜졌습니다.");
        }
        else
        {
            System.out.println("TV가 이미 켜져있습니다.");
        }
    }
    public void Off()
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("TV가 꺼졌습니다.");
        }
        else
        {
            System.out.println("TV가 이미 꺼져있습니다.");
        }
    }
    public void channelUp()
    {
        this.prev_channel = this.channel;
        this.channel ++;
        System.out.println("channel is "+channel);
    }
    public void channelDown()
    {
        this.prev_channel = this.channel;
        this.channel --;
        System.out.println("channel is "+channel);
    }
}
