package numbers

import grails.transaction.Transactional
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Value

@Transactional
class NumberService {

    def rest

    def jsonSlurper = new JsonSlurper()

    @Value('${defaultNumber:0}')
    def defaultNumber

    def getDefaultNumber() {
        return defaultNumber
    }

//    @HystrixCommand(fallbackMethod = 'getDefaultNumber')
    def nextNumber() {
        def result = jsonSlurper.parseText(rest.getForObject('https://numbers-service/number', String.class))
        return result.number
    }

}
