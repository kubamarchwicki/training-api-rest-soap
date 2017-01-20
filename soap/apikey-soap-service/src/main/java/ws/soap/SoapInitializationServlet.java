package ws.soap;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

@WebServlet(urlPatterns = "/services/*")
public class SoapInitializationServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);
        final Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/ApiKeys", new ApikeyServiceImpl());
    }

}
