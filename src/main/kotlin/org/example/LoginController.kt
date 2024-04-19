package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import lib.MakeHttpRequest
import java.net.URI
import java.net.URL
import java.util.*

class LoginController: Initializable {

    val httpRequest = MakeHttpRequest()

    val url = URI("http://52.67.139.133:8080/api/sanctum/token")

    val body = mapOf(
        Pair("imei", "12345678"),
        Pair("email", "dashfleet@test.com"),
        Pair("password", "12345"),
        Pair("device_name", "32bits_device")
    )

    @FXML var userTextView: TextField? = null
    @FXML var gridPanelKeyboard: GridPane? = null
    @FXML var gridPanelInformation: GridPane? = null
    @FXML var labelServices: Label? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println(userTextView?.text)
    }

    @FXML fun hidePanels(){
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false

        httpRequest.postJSON(url, body)
    }

}