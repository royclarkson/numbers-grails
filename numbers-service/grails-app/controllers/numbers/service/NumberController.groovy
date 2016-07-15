package numbers.service

import grails.converters.JSON

class NumberController {

    def numberService

    def index() {
        Number number = numberService.nextNumber()
        def msg = [number:number]
        render msg as JSON
    }
}
