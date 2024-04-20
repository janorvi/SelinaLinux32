package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*

class SuperController: Initializable {

    @FXML var mainController: MainController? = null
    @FXML var loginController: LoginController? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        TODO("Not yet implemented")
    }
}