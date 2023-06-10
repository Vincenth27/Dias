package pe.edu.idat.vincenth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean(name = "weekday")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema weekdaySchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("WeekdayPort");
    wsdl11Definition.setLocationUri("/wsec1e1");
    wsdl11Definition.setTargetNamespace("http://localhost:8080/wsec1e1/");
    wsdl11Definition.setSchema(weekdaySchema);
    return wsdl11Definition;
}

	@Bean
	public XsdSchema weekdaySchema() {
    return new SimpleXsdSchema(new ClassPathResource("xsd/weekday.xsd"));
}

	
}