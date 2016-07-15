package numbers.service

import grails.transaction.Transactional

import java.util.concurrent.atomic.AtomicLong

@Transactional
class NumberService {

    AtomicLong counter = new AtomicLong();

    def nextNumber() {
        return counter.incrementAndGet()
    }

}
