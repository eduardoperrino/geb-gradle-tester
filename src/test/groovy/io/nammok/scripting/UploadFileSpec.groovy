package io.nammok.scripting

import geb.spock.GebReportingSpec
import org.junit.Rule
import org.junit.rules.TemporaryFolder

class UploadFileSpec extends GebReportingSpec {

    @Rule
    TemporaryFolder dir = new TemporaryFolder()

    def "uploadig a file"() {
        given:
        go "http://localhost:8080"
        def uploadedFile = dir.newFile() << "from file"


        // tag::upload[]
        $("form").file = uploadedFile.absolutePath

        waitFor(3000) {

        }
        // end::upload[]
        //$('form input[type="submit"]').click()

        //$().text() == "from file"
    }


}
