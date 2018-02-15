package io.nammok.scripting

import geb.spock.GebReportingSpec

class EkorCppLoginSpec extends GebReportingSpec {

    def "do success login"() {
        given:
        go "http://192.168.1.120"
        assert title == "ekorCCP"


        when:
        def userInput = $("input", name: "user")
        userInput.value("admin")

        //localizar input password name=paswd
        def passInput = $("input", name: "paswd")
        passInput.value("modifica")

        //localizar ok button  type=submit
        def loginInput = $("input", id: "btnLogin01")
        loginInput.click()

        //hacer click sobre el button

        then:
        assert $("input", id: "rdbModoAdmin").size() == 1

    }


}
