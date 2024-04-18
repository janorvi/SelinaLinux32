package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import java.net.URL
import java.util.*

class LoginController: Initializable {

    @FXML var userTextField: TextField? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println(userTextField?.text)
    }


}