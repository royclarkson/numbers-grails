package numbers

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableDiscoveryClient
@EnableCircuitBreaker
class Application extends GrailsAutoConfiguration {

    // Unfortunately, @LoadBalanced autoconfiguration is not being applied in Grails
    // Creates a RestTemplate with Ribbon enabled client-side load balancing
   @Bean
   @LoadBalanced
   RestTemplate rest() {
       return new RestTemplate()
   }

    // @Bean
    // public RestTemplate rest(RestTemplateCustomizer customizer) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     customizer.customize(restTemplate);
    //     return restTemplate;
    // }

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

}
