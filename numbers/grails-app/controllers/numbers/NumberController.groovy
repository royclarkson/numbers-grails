package numbers

class NumberController {

    def numberService

    def index() {
        render "Hello number " + numberService.nextNumber()
    }

}
