package scripting

import geb.spock.GebReportingSpec

class GoogleSearchGebSpec extends GebReportingSpec {
    def 'should search for Geb in Google'() {
        given:
        go "http://www.google.es"

        when:
        $("input", name: "q").value("Gebish")
        $("input", name: "btnK").click()

        then:
        waitFor { $("#search").displayed }

        assert $("#search").text().contains("gebish.org")
    }
}
