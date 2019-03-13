package rmit.Proxy;

import rmit.Proxy.ActuaLBanner;
import rmit.Proxy.Banner;

public class ProxyBanner implements Banner {
    ActuaLBanner actuaLBanner;
    @Override
    public void show() {
        if (actuaLBanner == null){
            System.out.println("Loading....");
            actuaLBanner = new ActuaLBanner();
        }
        actuaLBanner.show();
    }
}
