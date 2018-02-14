package io.nammok.scripting

import geb.spock.GebReportingSpec

class GebishSiteNavigatorSpec extends GebReportingSpec {

    def "navigate from menu to book of geb section"() {
        given:
        go "http://gebish.org"
        assert title == "Geb - Very Groovy Browser Automation"

        when:
        $("div.menu a.manuals").click()

        then:
        waitFor { !$("#manuals-menu").hasClass("animating") }
        $("#manuals-menu a")[0].click()

        assert title.startsWith("The Book Of Geb")

    }
}
