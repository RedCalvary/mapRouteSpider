package jufe.mapRouteSpider;

import jufe.webutil.RoutingRequestSender;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RoutingRequestSender sender = new RoutingRequestSender();
        System.out.println(sender.sendRoutingRequest("115.824540,28.736451", "115.823572,28.726299"));
    }
}
